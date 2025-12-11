package cds.gen.utilityservice;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.LinkedStructuredType;
import java.lang.String;
import java.time.Instant;
import javax.annotation.processing.Generated;

@CdsName("UtilityService.AuditLogs")
@Generated("cds-maven-plugin")
public interface AuditLogs_ extends LinkedStructuredType<AuditLogs, AuditLogs_> {
  String ID = "ID";

  String USER_ID = "user_id";

  String USER_NAME = "user_name";

  String ENTITY_TYPE = "entity_type";

  String ENTITY_ID = "entity_id";

  String REASON_CODE = "reason_code";

  String CDS_NAME = "UtilityService.AuditLogs";

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

  ElementRef<Instant> timestamp();

  @CdsName(REASON_CODE)
  ElementRef<String> reason_code();
}
