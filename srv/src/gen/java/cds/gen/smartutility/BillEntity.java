package cds.gen.smartutility;

import com.sap.cds.CdsData;
import com.sap.cds.Struct;
import com.sap.cds.ql.CdsName;
import java.lang.Object;
import java.lang.String;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@CdsName("smartUtility.BillEntity")
@Generated("cds-maven-plugin")
public interface BillEntity extends CdsData {
  String ID = "ID";

  String CREATED_AT = "createdAt";

  String CREATED_BY = "createdBy";

  String MODIFIED_AT = "modifiedAt";

  String MODIFIED_BY = "modifiedBy";

  String BILL_NUMBER = "bill_number";

  String CUSTOMER_ID = "customer_id";

  String METER_ID = "meter_id";

  String BILLING_PERIOD_START = "billing_period_start";

  String BILLING_PERIOD_END = "billing_period_end";

  String CONSUMPTION_UNITS = "consumption_units";

  String CONSUMPTION_CHARGES = "consumption_charges";

  String FIXED_CHARGES = "fixed_charges";

  String TAX = "tax";

  String SURCHARGE = "surcharge";

  String TOTAL_AMOUNT = "total_amount";

  String DUE_DATE = "due_date";

  String STATUS = "status";

  String ADJUSTMENT_AMOUNT = "adjustment_amount";

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

  @CdsName(BILL_NUMBER)
  String getBillNumber();

  @CdsName(BILL_NUMBER)
  void setBillNumber(String billNumber);

  @CdsName(CUSTOMER_ID)
  String getCustomerId();

  @CdsName(CUSTOMER_ID)
  void setCustomerId(String customerId);

  @CdsName(METER_ID)
  String getMeterId();

  @CdsName(METER_ID)
  void setMeterId(String meterId);

  @CdsName(BILLING_PERIOD_START)
  LocalDate getBillingPeriodStart();

  @CdsName(BILLING_PERIOD_START)
  void setBillingPeriodStart(LocalDate billingPeriodStart);

  @CdsName(BILLING_PERIOD_END)
  LocalDate getBillingPeriodEnd();

  @CdsName(BILLING_PERIOD_END)
  void setBillingPeriodEnd(LocalDate billingPeriodEnd);

  @CdsName(CONSUMPTION_UNITS)
  BigDecimal getConsumptionUnits();

  @CdsName(CONSUMPTION_UNITS)
  void setConsumptionUnits(BigDecimal consumptionUnits);

  @CdsName(CONSUMPTION_CHARGES)
  BigDecimal getConsumptionCharges();

  @CdsName(CONSUMPTION_CHARGES)
  void setConsumptionCharges(BigDecimal consumptionCharges);

  @CdsName(FIXED_CHARGES)
  BigDecimal getFixedCharges();

  @CdsName(FIXED_CHARGES)
  void setFixedCharges(BigDecimal fixedCharges);

  BigDecimal getTax();

  void setTax(BigDecimal tax);

  BigDecimal getSurcharge();

  void setSurcharge(BigDecimal surcharge);

  @CdsName(TOTAL_AMOUNT)
  BigDecimal getTotalAmount();

  @CdsName(TOTAL_AMOUNT)
  void setTotalAmount(BigDecimal totalAmount);

  @CdsName(DUE_DATE)
  LocalDate getDueDate();

  @CdsName(DUE_DATE)
  void setDueDate(LocalDate dueDate);

  String getStatus();

  void setStatus(String status);

  @CdsName(ADJUSTMENT_AMOUNT)
  BigDecimal getAdjustmentAmount();

  @CdsName(ADJUSTMENT_AMOUNT)
  void setAdjustmentAmount(BigDecimal adjustmentAmount);

  BillEntity_ ref();

  static BillEntity create() {
    return Struct.create(BillEntity.class);
  }

  static BillEntity of(Map<String, Object> map) {
    return Struct.access(map).as(BillEntity.class);
  }

  static BillEntity create(String id) {
    Map<String, Object> keys = new HashMap<>();
    keys.put(ID, id);
    return Struct.access(keys).as(BillEntity.class);
  }
}
