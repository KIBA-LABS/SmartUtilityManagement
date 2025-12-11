package cds.gen.smartutility;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.LinkedStructuredType;
import java.lang.String;
import java.time.Instant;
import java.util.Collection;
import javax.annotation.processing.Generated;

@CdsName("smartUtility.ComplaintEntity")
@Generated("cds-maven-plugin")
public interface ComplaintEntity_ extends LinkedStructuredType<ComplaintEntity, ComplaintEntity_> {
  String ID = "ID";

  String CUSTOMER_ID = "customer_id";

  String ATTACHMENT_URLS = "attachment_urls";

  String ASSIGNED_TO = "assigned_to";

  String RESOLUTION_DATE = "resolution_date";

  String RESOLUTION_NOTES = "resolution_notes";

  String SLA_DUE_DATE = "sla_due_date";

  String CDS_NAME = "smartUtility.ComplaintEntity";

  @CdsName(ID)
  ElementRef<String> ID();

  ElementRef<Instant> createdAt();

  ElementRef<String> createdBy();

  ElementRef<Instant> modifiedAt();

  ElementRef<String> modifiedBy();

  @CdsName(CUSTOMER_ID)
  ElementRef<String> customer_id();

  ElementRef<String> category();

  ElementRef<String> description();

  @CdsName(ATTACHMENT_URLS)
  ElementRef<Collection<String>> attachment_urls();

  @CdsName(ASSIGNED_TO)
  ElementRef<String> assigned_to();

  ElementRef<String> status();

  @CdsName(RESOLUTION_DATE)
  ElementRef<Instant> resolution_date();

  @CdsName(RESOLUTION_NOTES)
  ElementRef<String> resolution_notes();

  @CdsName(SLA_DUE_DATE)
  ElementRef<Instant> sla_due_date();
}
