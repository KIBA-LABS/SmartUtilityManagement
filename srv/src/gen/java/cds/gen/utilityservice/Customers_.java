package cds.gen.utilityservice;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.LinkedStructuredType;
import java.lang.String;
import java.time.Instant;
import javax.annotation.processing.Generated;

@CdsName("UtilityService.Customers")
@Generated("cds-maven-plugin")
public interface Customers_ extends LinkedStructuredType<Customers, Customers_> {
  String ID = "ID";

  String ACCOUNT_TYPE = "account_type";

  String CDS_NAME = "UtilityService.Customers";

  @CdsName(ID)
  ElementRef<String> ID();

  ElementRef<Instant> createdAt();

  ElementRef<String> createdBy();

  ElementRef<Instant> modifiedAt();

  ElementRef<String> modifiedBy();

  ElementRef<String> name();

  ElementRef<String> email();

  ElementRef<String> password();

  ElementRef<String> role();

  ElementRef<String> phone();

  ElementRef<String> address();

  @CdsName(ACCOUNT_TYPE)
  ElementRef<String> account_type();

  ElementRef<String> region();

  ElementRef<String> category();

  ElementRef<String> status();
}
