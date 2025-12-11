package cds.gen.utilityservice;

import com.sap.cds.services.EventContext;
import com.sap.cds.services.EventName;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;

@EventName("recordPayment")
@Generated("cds-maven-plugin")
public interface RecordPaymentContext extends EventContext {
  String BILL_ID = "billId";

  String AMOUNT = "amount";

  String METHOD = "method";

  String CDS_NAME = "recordPayment";

  String getBillId();

  void setBillId(String billId);

  BigDecimal getAmount();

  void setAmount(BigDecimal amount);

  String getMethod();

  void setMethod(String method);

  @Override
  UtilityService getService();

  void setResult(Payments result);

  Payments getResult();

  static RecordPaymentContext create() {
    return EventContext.create(RecordPaymentContext.class, null);
  }
}
