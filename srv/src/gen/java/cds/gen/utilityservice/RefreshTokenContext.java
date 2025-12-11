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

@EventName("refreshToken")
@Generated("cds-maven-plugin")
public interface RefreshTokenContext extends EventContext {
  String REFRESH_TOKEN = "refreshToken";

  String CDS_NAME = "refreshToken";

  String getRefreshToken();

  void setRefreshToken(String refreshToken);

  @Override
  UtilityService getService();

  void setResult(ReturnType result);

  ReturnType getResult();

  static RefreshTokenContext create() {
    return EventContext.create(RefreshTokenContext.class, null);
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
