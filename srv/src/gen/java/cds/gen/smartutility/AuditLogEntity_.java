package cds.gen.smartutility;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.LinkedStructuredType;
import java.lang.String;
import java.time.Instant;
import javax.annotation.processing.Generated;

@CdsName("smartUtility.AuditLogEntity")
@Generated("cds-maven-plugin")
public interface AuditLogEntity_ extends LinkedStructuredType<AuditLogEntity, AuditLogEntity_> {
  String ID = "ID";

  String USER_ID = "user_id";

  String USER_NAME = "user_name";

  String ENTITY_TYPE = "entity_type";

  String ENTITY_ID = "entity_id";

  String OLD_VALUES = "old_values";

  String NEW_VALUES = "new_values";

  String REASON_CODE = "reason_code";

  String CDS_NAME = "smartUtility.AuditLogEntity";

  @CdsName(ID)
  ElementRef<String> ID();

  ElementRef<Instant> createdAt();

  ElementRef<String> createdBy();

  ElementRef<Instant> modifiedAt();

  ElementRef<String> modifiedBy();

  @CdsName(USER_ID)
  ElementRef<String> user_id();

  @CdsName(USER_NAME)
  ElementRef<String> user_name();

  ElementRef<String> action();

  @CdsName(ENTITY_TYPE)
  ElementRef<String> entity_type();

  @CdsName(ENTITY_ID)
  ElementRef<String> entity_id();

  @CdsName(OLD_VALUES)
  ElementRef<String> old_values();

  @CdsName(NEW_VALUES)
  ElementRef<String> new_values();

  ElementRef<Instant> timestamp();

  @CdsName(REASON_CODE)
  ElementRef<String> reason_code();
}
