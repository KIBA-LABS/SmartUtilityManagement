package customer.smartutilitymanagement.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DbInfoLogger {

    @Autowired
    private javax.sql.DataSource dataSource;

    @jakarta.annotation.PostConstruct
    public void logDbUrl() throws Exception {
        try (var con = dataSource.getConnection()) {
            System.out.println("### JDBC URL = " + con.getMetaData().getURL());
        }
    }
}

