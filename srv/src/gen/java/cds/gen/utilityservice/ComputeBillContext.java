package cds.gen.utilityservice;

import com.sap.cds.services.EventContext;
import com.sap.cds.services.EventName;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

@EventName("computeBill")
@Generated("cds-maven-plugin")
public interface ComputeBillContext extends EventContext {
  String CUSTOMER_ID = "customerId";

  String METER_ID = "meterId";

  String PERIOD_START = "periodStart";

  String PERIOD_END = "periodEnd";

  String CDS_NAME = "computeBill";

  String getCustomerId();

  void setCustomerId(String customerId);

  String getMeterId();

  void setMeterId(String meterId);

  LocalDate getPeriodStart();

  void setPeriodStart(LocalDate periodStart);

  LocalDate getPeriodEnd();

  void setPeriodEnd(LocalDate periodEnd);

  @Override
  UtilityService getService();

  void setResult(Bills result);

  Bills getResult();

  static ComputeBillContext create() {
    return EventContext.create(ComputeBillContext.class, null);
  }
}
