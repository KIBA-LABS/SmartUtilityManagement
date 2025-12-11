package cds.gen.smartutility;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.LinkedStructuredType;
import java.lang.String;
import java.time.Instant;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

@CdsName("smartUtility.MeterEntity")
@Generated("cds-maven-plugin")
public interface MeterEntity_ extends LinkedStructuredType<MeterEntity, MeterEntity_> {
  String ID = "ID";

  String METER_NUMBER = "meter_number";

  String CUSTOMER_ID = "customer_id";

  String METER_TYPE = "meter_type";

  String INSTALLATION_DATE = "installation_date";

  String CALIBRATION_DUE_DATE = "calibration_due_date";

  String CDS_NAME = "smartUtility.MeterEntity";

  @CdsName(ID)
  ElementRef<String> ID();

  ElementRef<Instant> createdAt();

  ElementRef<String> createdBy();

  ElementRef<Instant> modifiedAt();

  ElementRef<String> modifiedBy();

  @CdsName(METER_NUMBER)
  ElementRef<String> meter_number();

  @CdsName(CUSTOMER_ID)
  ElementRef<String> customer_id();

  @CdsName(METER_TYPE)
  ElementRef<String> meter_type();

  ElementRef<String> location();

  @CdsName(INSTALLATION_DATE)
  ElementRef<LocalDate> installation_date();

  @CdsName(CALIBRATION_DUE_DATE)
  ElementRef<LocalDate> calibration_due_date();

  ElementRef<String> status();
}
