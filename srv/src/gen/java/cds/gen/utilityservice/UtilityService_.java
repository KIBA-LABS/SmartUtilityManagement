package cds.gen.utilityservice;

import com.sap.cds.ql.CdsName;
import java.lang.Class;
import java.lang.String;
import javax.annotation.processing.Generated;

@Generated("cds-maven-plugin")
@CdsName("UtilityService")
public interface UtilityService_ {
  String CDS_NAME = "UtilityService";

  Class<Customers_> CUSTOMERS = Customers_.class;

  Class<Complaints_> COMPLAINTS = Complaints_.class;

  Class<MeterReadings_> METER_READINGS = MeterReadings_.class;

  Class<Bills_> BILLS = Bills_.class;

  Class<Payments_> PAYMENTS = Payments_.class;

  Class<AuditLogs_> AUDIT_LOGS = AuditLogs_.class;

  Class<Meters_> METERS = Meters_.class;
}
