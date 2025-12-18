package customer.smartutilitymanagement.handlers;

import cds.gen.smartutility.*;
import cds.gen.utilityservice.Customers;
import cds.gen.utilityservice.Customers_;
import cds.gen.utilityservice.LoginContext;
import cds.gen.utilityservice.UtilityService_;
import com.sap.cds.CdsData;
import com.sap.cds.ql.Insert;
import com.sap.cds.ql.Select;
import com.sap.cds.ql.cqn.CqnSelect;
import com.sap.cds.reflect.CdsEnumType;
import com.sap.cds.reflect.CdsModel;
import com.sap.cds.services.ErrorStatuses;
import com.sap.cds.services.ServiceException;
import com.sap.cds.services.cds.CdsCreateEventContext;
import com.sap.cds.services.cds.CdsUpdateEventContext;
import com.sap.cds.services.cds.CqnService;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.Before;
import com.sap.cds.services.handler.annotations.On;
import com.sap.cds.services.handler.annotations.ServiceName;
import com.sap.cds.services.persistence.PersistenceService;
import customer.smartutilitymanagement.utils.JwtUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.*;


@Component
@ServiceName("UtilityService")
public class SMartUtilityHandler implements EventHandler {

    private PersistenceService db;
    @Autowired
    CdsModel model;


    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
    private final JwtUtils jwtUtils;

    public SMartUtilityHandler(PersistenceService db, JwtUtils jwtUtils) {
        this.db = db;
        this.jwtUtils = jwtUtils;
    }

    @Before(event = CqnService.EVENT_CREATE, entity = Customers_.CDS_NAME)
    public void validateCustomers(CdsCreateEventContext ctx, List<Customers> customers) {
        CdsModel model = ctx.getModel();

        CdsEnumType<?> enumAccountType = model.getType("smartUtility.AccountType").as(CdsEnumType.class);
        CdsEnumType<?> enumCustomerStatus = model.getType("smartUtility.CustomerStatus").as(CdsEnumType.class);
        CdsEnumType<?> enumCustomerRole = model.getType("smartUtility.CustomerRole").as(CdsEnumType.class);

        Set<String> allowedRoles = enumCustomerRole.enumerals().keySet();
        Set<String> allowedStatus = enumCustomerStatus.enumerals().keySet();
        Set<String> allowedAccountTypes = enumAccountType.enumerals().keySet();

        for (Customers c : customers) {
            if (c.getName() == null || c.getName().isBlank()) {
                throw new ServiceException(ErrorStatuses.BAD_REQUEST, "Name is required");
            }
            if (c.getEmail() == null || c.getEmail().isBlank()) {
                throw new ServiceException(ErrorStatuses.BAD_REQUEST, "Email is required");
            }
            if (!c.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                throw new ServiceException(ErrorStatuses.BAD_REQUEST, "Email format is invalid");
            }
            if (c.getPassword() == null || c.getPassword().isBlank()) {
                throw new ServiceException(ErrorStatuses.BAD_REQUEST, "Password is required");
            }
            if (c.getPassword().length() < 8) {
                throw new ServiceException(ErrorStatuses.BAD_REQUEST, "Password must be at least 8 characters");
            }
            String encodedPassword = passwordEncoder.encode(c.getPassword());
            c.setPassword(encodedPassword);
            String role = c.getRole();
            if (role == null || role.isBlank()) {
                throw new ServiceException(ErrorStatuses.BAD_REQUEST, "Role is required");
            }
            if (!allowedRoles.contains(role)) {
                throw new ServiceException(ErrorStatuses.BAD_REQUEST,
                        "Invalid role '" + role + "', allowed: " + allowedRoles);
            }
            if (c.getAddress() == null || c.getAddress().isBlank()) {
                throw new ServiceException(ErrorStatuses.BAD_REQUEST, "Address is required");
            }
            String status = c.getStatus();
            if (status == null || status.isBlank()) {
                throw new ServiceException(ErrorStatuses.BAD_REQUEST, "Status is required");
            }
            if (!allowedStatus.contains(status)) {
                throw new ServiceException(ErrorStatuses.BAD_REQUEST,
                        "Invalid status '" + status + "', allowed: " + allowedStatus);
            }

            if (c.getRegion() != null && c.getRegion().length() > 50) {
                throw new ServiceException(ErrorStatuses.BAD_REQUEST, "Region must be max 50 characters");
            }

            if (c.getCategory() != null && c.getCategory().length() > 50) {
                throw new ServiceException(ErrorStatuses.BAD_REQUEST, "Category must be max 50 characters");
            }

            String accountType = c.getAccountType();
            if (accountType == null || accountType.isBlank()) {
                throw new ServiceException(ErrorStatuses.BAD_REQUEST, "Account type is required");
            }
            if (!allowedAccountTypes.contains(accountType)) {
                throw new ServiceException(ErrorStatuses.BAD_REQUEST,
                        "Invalid account type '" + accountType + "', allowed: " + allowedAccountTypes);
            }
        }

    }

    @Before(event = CqnService.EVENT_UPDATE, entity = Customers_.CDS_NAME)
    public void validateCustomersOnUpdate(CdsUpdateEventContext ctx, List<Customers> customers) {

        CdsModel model = ctx.getModel();

        CdsEnumType<?> enumAccountType = model.getType("smartUtility.AccountType").as(CdsEnumType.class);
        CdsEnumType<?> enumCustomerStatus = model.getType("smartUtility.CustomerStatus").as(CdsEnumType.class);
        CdsEnumType<?> enumCustomerRole = model.getType("smartUtility.CustomerRole").as(CdsEnumType.class);

        Set<String> allowedRoles = enumCustomerRole.enumerals().keySet();
        Set<String> allowedStatus = enumCustomerStatus.enumerals().keySet();
        Set<String> allowedAccountTypes = enumAccountType.enumerals().keySet();

        // Extract ID from the update request
        Map<String, Object> keys = ctx.getCqn().entries().get(0);
        Object idValue = keys.get("ID");

        if (idValue == null) {
            throw new ServiceException(ErrorStatuses.BAD_REQUEST, "User ID is required for update");
        }

        String userId = idValue.toString();

        Customers existingUser = db.run(
                Select.from(Customers_.class).where(u -> u.ID().eq(userId))
        ).single(Customers.class);

        if (existingUser == null) {
            throw new ServiceException(ErrorStatuses.NOT_FOUND,
                    "User with ID '" + userId + "' does not exist");
        }
        for (Customers customer : customers) {

            if (customer.getName() != null && customer.getName().isBlank()) {
                throw new ServiceException(ErrorStatuses.BAD_REQUEST, "Name cannot be blank");
            }

            if (customer.getEmail() != null) {
                if (customer.getEmail().isBlank()) {
                    throw new ServiceException(ErrorStatuses.BAD_REQUEST, "Email cannot be blank");
                }
                if (!customer.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                    throw new ServiceException(ErrorStatuses.BAD_REQUEST, "Email format is invalid");
                }
            }
            if (customer.getPassword() != null) {
                if (customer.getPassword().isBlank()) {
                    throw new ServiceException(ErrorStatuses.BAD_REQUEST, "Password cannot be blank");
                }
                if (customer.getPassword().length() < 8) {
                    throw new ServiceException(ErrorStatuses.BAD_REQUEST,
                            "Password must be at least 8 characters");
                }
            }
            if (customer.getRole() != null && !allowedRoles.contains(customer.getRole())) {
                throw new ServiceException(ErrorStatuses.BAD_REQUEST,
                        "Invalid role '" + customer.getRole() + "', allowed: " + allowedRoles);
            }

            if (customer.getAddress() != null && customer.getAddress().isBlank()) {
                throw new ServiceException(ErrorStatuses.BAD_REQUEST, "Address cannot be blank");
            }
            if (customer.getStatus() != null && !allowedStatus.contains(customer.getStatus())) {
                throw new ServiceException(ErrorStatuses.BAD_REQUEST,
                        "Invalid status '" + customer.getStatus() + "', allowed: " + allowedStatus);
            }

            if (customer.getRegion() != null && customer.getRegion().length() > 50) {
                throw new ServiceException(ErrorStatuses.BAD_REQUEST, "Region must be max 50 characters");
            }

            if (customer.getCategory() != null && customer.getCategory().length() > 50) {
                throw new ServiceException(ErrorStatuses.BAD_REQUEST, "Category must be max 50 characters");
            }

            if (customer.getAccountType() != null && !allowedAccountTypes.contains(customer.getAccountType())) {
                throw new ServiceException(ErrorStatuses.BAD_REQUEST,
                        "Invalid account type '" + customer.getAccountType() + "', allowed: " + allowedAccountTypes);
            }
        }
    }


    @On(event = "login")
    public void onLogin(LoginContext ctx) {

        String email = ctx.getEmail();
        String password = ctx.getPassword();

        if (email == null || password == null) {
            throw badrequest("Email and password are required");
        }
        List<CustomerEntity> users = db.run(
                Select.from(CustomerEntity_.class)
                        .where(u -> u.email().eq(email))
        ).listOf(CustomerEntity.class);

        if (users.isEmpty()) {
            throw badrequest("Invalid credentials");
        }

        CustomerEntity user = users.get(0);

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw badrequest("Invalid credentials");
        }

        Map<String, Object> claims = Map.of(
                "email", user.getEmail(),
                "role", user.getRole()
        );
        String accessToken = jwtUtils.generateAccessToken(user.getId(), claims);
        String refreshToken = jwtUtils.generateRefreshToken(user.getId());

        LoginContext.ReturnType result = LoginContext.ReturnType.create();
        result.setAccessToken(accessToken);
        result.setRefreshToken(refreshToken);
        result.setTokenType("Bearer");

        ctx.setResult(result);
    }



    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    private ServiceException badrequest(String msg) {
        return new ServiceException(ErrorStatuses.BAD_REQUEST, msg);
    }

}



