package cds.gen.smartutility;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.LinkedStructuredType;
import java.lang.String;
import java.math.BigDecimal;
import java.time.Instant;
import javax.annotation.processing.Generated;

@CdsName("smartUtility.MeterReadingEntity")
@Generated("cds-maven-plugin")
public interface MeterReadingEntity_ extends LinkedStructuredType<MeterReadingEntity, MeterReadingEntity_> {
  String ID = "ID";

  String METER_ID = "meter_id";

  String READING_VALUE = "reading_value";

  String READING_DATE = "reading_date";

  String VALIDATION_ERRORS = "validation_errors";

  String CDS_NAME = "smartUtility.MeterReadingEntity";

  @CdsName(ID)
  ElementRef<String> ID();

  ElementRef<Instant> createdAt();

  ElementRef<String> createdBy();

  ElementRef<Instant> modifiedAt();

  ElementRef<String> modifiedBy();

  @CdsName(METER_ID)
  ElementRef<String> meter_id();

  @CdsName(READING_VALUE)
  ElementRef<BigDecimal> reading_value();

  ElementRef<String> unit();

  @CdsName(READING_DATE)
  ElementRef<Instant> reading_date();

  ElementRef<String> source();

  ElementRef<String> status();

  @CdsName(VALIDATION_ERRORS)
  ElementRef<String> validation_errors();
}
