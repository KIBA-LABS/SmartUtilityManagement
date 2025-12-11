using smartUtility as db from '../db/schema';

service UtilityService {
  entity Customers     as projection on db.CustomerEntity;
  entity Meters        as projection on db.MeterEntity;
  entity MeterReadings as projection on db.MeterReadingEntity;
  entity Bills         as projection on db.BillEntity;
  entity Payments      as projection on db.PaymentEntity;
  entity Complaints    as projection on db.ComplaintEntity;

  @readonly entity AuditLogs as projection on db.AuditLogEntity excluding { old_values, new_values };

  action login(email: String, password: String)
    returns {
      accessToken  : String;
      refreshToken : String;
      tokenType    : String;
    };

  action refreshToken(refreshToken: String)
    returns {
      accessToken  : String;
      refreshToken : String;
      tokenType    : String;
    };
  action computeBill(customerId: UUID, meterId: UUID, periodStart: Date, periodEnd: Date) returns Bills;
  action recordPayment(billId: UUID, amount: Decimal, method: String) returns Payments;
  action submitMeterReading(meterId: UUID, value: Decimal, source: String) returns MeterReadings;
  action registerComplaint(customerId: UUID, category: String, description: String) returns Complaints;
}

