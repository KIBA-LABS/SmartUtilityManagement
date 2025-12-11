package cds.gen.utilityservice;

import com.sap.cds.CdsData;
import com.sap.cds.Struct;
import com.sap.cds.ql.CdsName;
import java.lang.Object;
import java.lang.String;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@CdsName("UtilityService.Customers")
@Generated("cds-maven-plugin")
public interface Customers extends CdsData {
  String ID = "ID";

  String CREATED_AT = "createdAt";

  String CREATED_BY = "createdBy";

  String MODIFIED_AT = "modifiedAt";

  String MODIFIED_BY = "modifiedBy";

  String NAME = "name";

  String EMAIL = "email";

  String PASSWORD = "password";

  String ROLE = "role";

  String PHONE = "phone";

  String ADDRESS = "address";

  String ACCOUNT_TYPE = "account_type";

  String REGION = "region";

  String CATEGORY = "category";

  String STATUS = "status";

  @CdsName(ID)
  String getId();

  @CdsName(ID)
  void setId(String id);

  Instant getCreatedAt();

  void setCreatedAt(Instant createdAt);

  String getCreatedBy();

  void setCreatedBy(String createdBy);

  Instant getModifiedAt();

  void setModifiedAt(Instant modifiedAt);

  String getModifiedBy();

  void setModifiedBy(String modifiedBy);

  String getName();

  void setName(String name);

  String getEmail();

  void setEmail(String email);

  String getPassword();

  void setPassword(String password);

  String getRole();

  void setRole(String role);

  String getPhone();

  void setPhone(String phone);

  String getAddress();

  void setAddress(String address);

  @CdsName(ACCOUNT_TYPE)
  String getAccountType();

  @CdsName(ACCOUNT_TYPE)
  void setAccountType(String accountType);

  String getRegion();

  void setRegion(String region);

  String getCategory();

  void setCategory(String category);

  String getStatus();

  void setStatus(String status);

  Customers_ ref();

  static Customers create() {
    return Struct.create(Customers.class);
  }

  static Customers of(Map<String, Object> map) {
    return Struct.access(map).as(Customers.class);
  }

  static Customers create(String id) {
    Map<String, Object> keys = new HashMap<>();
    keys.put(ID, id);
    return Struct.access(keys).as(Customers.class);
  }
}
