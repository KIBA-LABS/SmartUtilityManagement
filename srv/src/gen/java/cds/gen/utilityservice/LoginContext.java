package cds.gen.utilityservice;

import com.sap.cds.CdsData;
import com.sap.cds.Struct;
import com.sap.cds.services.EventContext;
import com.sap.cds.services.EventName;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Map;
import javax.annotation.processing.Generated;

@EventName("login")
@Generated("cds-maven-plugin")
public interface LoginContext extends EventContext {
  String EMAIL = "email";

  String PASSWORD = "password";

  String CDS_NAME = "login";

  String getEmail();

  void setEmail(String email);

  String getPassword();

  void setPassword(String password);

  @Override
  UtilityService getService();

  void setResult(ReturnType result);

  ReturnType getResult();

  static LoginContext create() {
    return EventContext.create(LoginContext.class, null);
  }

  interface ReturnType extends CdsData {
    String ACCESS_TOKEN = "accessToken";

    String REFRESH_TOKEN = "refreshToken";

    String TOKEN_TYPE = "tokenType";

    String getAccessToken();

    void setAccessToken(String accessToken);

    String getRefreshToken();

    void setRefreshToken(String refreshToken);

    String getTokenType();

    void setTokenType(String tokenType);

    static ReturnType create() {
      return Struct.create(ReturnType.class);
    }

    static ReturnType of(Map<String, Object> map) {
      return Struct.access(map).as(ReturnType.class);
    }
  }
}
