package cds.gen.utilityservice;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.LinkedStructuredType;
import java.lang.String;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

@CdsName("UtilityService.Bills")
@Generated("cds-maven-plugin")
public interface Bills_ extends LinkedStructuredType<Bills, Bills_> {
  String ID = "ID";

  String BILL_NUMBER = "bill_number";

  String CUSTOMER_ID = "customer_id";

  String METER_ID = "meter_id";

  String BILLING_PERIOD_START = "billing_period_start";

  String BILLING_PERIOD_END = "billing_period_end";

  String CONSUMPTION_UNITS = "consumption_units";

  String CONSUMPTION_CHARGES = "consumption_charges";

  String FIXED_CHARGES = "fixed_charges";

  String TOTAL_AMOUNT = "total_amount";

  String DUE_DATE = "due_date";

  String ADJUSTMENT_AMOUNT = "adjustment_amount";

  String CDS_NAME = "UtilityService.Bills";

  @CdsName(ID)
  ElementRef<String> ID();

  ElementRef<Instant> createdAt();

  ElementRef<String> createdBy();

  ElementRef<Instant> modifiedAt();

  ElementRef<String> modifiedBy();

  @CdsName(BILL_NUMBER)
  ElementRef<String> bill_number();

  @CdsName(CUSTOMER_ID)
  ElementRef<String> customer_id();

  @CdsName(METER_ID)
  ElementRef<String> meter_id();

  @CdsName(BILLING_PERIOD_START)
  ElementRef<LocalDate> billing_period_start();

  @CdsName(BILLING_PERIOD_END)
  ElementRef<LocalDate> billing_period_end();

  @CdsName(CONSUMPTION_UNITS)
  ElementRef<BigDecimal> consumption_units();

  @CdsName(CONSUMPTION_CHARGES)
  ElementRef<BigDecimal> consumption_charges();

  @CdsName(FIXED_CHARGES)
  ElementRef<BigDecimal> fixed_charges();

  ElementRef<BigDecimal> tax();

  ElementRef<BigDecimal> surcharge();

  @CdsName(TOTAL_AMOUNT)
  ElementRef<BigDecimal> total_amount();

  @CdsName(DUE_DATE)
  ElementRef<LocalDate> due_date();

  ElementRef<String> status();

  @CdsName(ADJUSTMENT_AMOUNT)
  ElementRef<BigDecimal> adjustment_amount();
}
