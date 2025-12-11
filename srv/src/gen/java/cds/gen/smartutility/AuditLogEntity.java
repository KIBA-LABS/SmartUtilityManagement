package cds.gen.smartutility;

import com.sap.cds.CdsData;
import com.sap.cds.Struct;
import com.sap.cds.ql.CdsName;
import java.lang.Object;
import java.lang.String;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@CdsName("smartUtility.AuditLogEntity")
@Generated("cds-maven-plugin")
public interface AuditLogEntity extends CdsData {
  String ID = "ID";

  String CREATED_AT = "createdAt";

  String CREATED_BY = "createdBy";

  String MODIFIED_AT = "modifiedAt";

  String MODIFIED_BY = "modifiedBy";

  String USER_ID = "user_id";

  String USER_NAME = "user_name";

  String ACTION = "action";

  String ENTITY_TYPE = "entity_type";

  String ENTITY_ID = "entity_id";

  String OLD_VALUES = "old_values";

  String NEW_VALUES = "new_values";

  String TIMESTAMP = "timestamp";

  String REASON_CODE = "reason_code";

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

  @CdsName(USER_ID)
  String getUserId();

  @CdsName(USER_ID)
  void setUserId(String userId);

  @CdsName(USER_NAME)
  String getUserName();

  @CdsName(USER_NAME)
  void setUserName(String userName);

  String getAction();

  void setAction(String action);

  @CdsName(ENTITY_TYPE)
  String getEntityType();

  @CdsName(ENTITY_TYPE)
  void setEntityType(String entityType);

  @CdsName(ENTITY_ID)
  String getEntityId();

  @CdsName(ENTITY_ID)
  void setEntityId(String entityId);

  @CdsName(OLD_VALUES)
  String getOldValues();

  @CdsName(OLD_VALUES)
  void setOldValues(String oldValues);

  @CdsName(NEW_VALUES)
  String getNewValues();

  @CdsName(NEW_VALUES)
  void setNewValues(String newValues);

  Instant getTimestamp();

  void setTimestamp(Instant timestamp);

  @CdsName(REASON_CODE)
  String getReasonCode();

  @CdsName(REASON_CODE)
  void setReasonCode(String reasonCode);

  AuditLogEntity_ ref();

  static AuditLogEntity create() {
    return Struct.create(AuditLogEntity.class);
  }

  static AuditLogEntity of(Map<String, Object> map) {
    return Struct.access(map).as(AuditLogEntity.class);
  }

  static AuditLogEntity create(String id) {
    Map<String, Object> keys = new HashMap<>();
    keys.put(ID, id);
    return Struct.access(keys).as(AuditLogEntity.class);
  }
}
