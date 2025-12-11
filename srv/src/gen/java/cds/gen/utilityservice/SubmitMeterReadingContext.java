package cds.gen.utilityservice;

import com.sap.cds.services.EventContext;
import com.sap.cds.services.EventName;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;

@EventName("submitMeterReading")
@Generated("cds-maven-plugin")
public interface SubmitMeterReadingContext extends EventContext {
  String METER_ID = "meterId";

  String VALUE = "value";

  String SOURCE = "source";

  String CDS_NAME = "submitMeterReading";

  String getMeterId();

  void setMeterId(String meterId);

  BigDecimal getValue();

  void setValue(BigDecimal value);

  String getSource();

  void setSource(String source);

  @Override
  UtilityService getService();

  void setResult(MeterReadings result);

  MeterReadings getResult();

  static SubmitMeterReadingContext create() {
    return EventContext.create(SubmitMeterReadingContext.class, null);
  }
}
