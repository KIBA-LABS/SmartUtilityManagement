namespace smartUtility;
using { cuid, managed } from '@sap/cds/common';

type AccountType : String enum {
  RESIDENTIAL;
  COMMERCIAL;
  INDUSTRIAL;
}

type CustomerStatus : String enum {
  ACTIVE;
  INACTIVE;
  CLOSED;
}

type CustomerRole : String enum {
  CUSTOMER;
  METER_AGENT;
  BILLINGADMIN;
  PAYMENTADMIN;
  AUDITOR;
  SUPERADMIN;
}

type PaymentMethod : String enum {
  ONLINE;
  CHECK;
  CASH;
}

type BillStatus : String enum {
  GENERATED;
  SENT;
  PAID;
  OVERDUE;
  CANCELLED;
}

type ComplaintCategory : String enum {
  BILLING_DISPUTE;
  METER_FAULT;
  OUTAGE;
  OTHER;
}

type ComplaintStatus : String enum {
  REGISTERED;
  IN_PROGRESS;
  RESOLVED;
  CLOSED;
}

entity CustomerEntity : cuid, managed {
  name         : String(100);
  email        : String(100) @unique;
  password     : String(255) @assert.notNull;
  role         : CustomerRole default 'CUSTOMER';
  phone        : String(20);
  address      : String(200);
  account_type : AccountType default 'RESIDENTIAL';
  region       : String(50);
  category     : String(50);
  status       : CustomerStatus default 'ACTIVE';
}

entity MeterEntity: cuid, managed {
  meter_number         : String(50) @unique;
  customer_id          : UUID;
  meter_type           : String(20) enum { ANALOG; DIGITAL; SMART; } default 'DIGITAL';
  location             : String(200);
  installation_date    : Date;
  calibration_due_date : Date;
  status               : String(30) enum { ACTIVE; DECOMMISSIONED; REPLACED; } default 'ACTIVE';
}

entity MeterReadingEntity:  cuid, managed {
  meter_id            : UUID;
  reading_value       : Decimal(15,3);
  unit                : String(10) default 'kWh';
  reading_date        : DateTime;
  source              : String(20) enum { MANUAL; IOT; ESTIMATED; } default 'MANUAL';
  status              : String(30) enum { PENDING_VALIDATION; VALIDATED; DISPUTED; } default 'PENDING_VALIDATION';
  validation_errors   : String(1000);
}

entity BillEntity: cuid, managed {
  bill_number           : String(50) @unique;
  customer_id           : UUID;
  meter_id              : UUID;
  billing_period_start  : Date;
  billing_period_end    : Date;
  consumption_units     : Decimal(15,3);
  consumption_charges   : Decimal(15,2);
  fixed_charges         : Decimal(15,2) default 0.0;
  tax                   : Decimal(15,2) default 0.0;
  surcharge             : Decimal(15,2) default 0.0;
  total_amount          : Decimal(15,2);
  due_date              : Date;
  status                : BillStatus       default 'GENERATED';
  adjustment_amount     : Decimal(15,2) default 0.0;
}

entity PaymentEntity : cuid, managed{
  bill_id                 : UUID;
  customer_id             : UUID;
  amount                  : Decimal(15,2);
  payment_method          : PaymentMethod   default 'ONLINE';
  gateway_transaction_id  : String(100);
  payment_date            : DateTime;
  status                  : String(20) enum { PENDING; SUCCESS; FAILED; } default 'PENDING';
  receipt_number          : String(50);
}

entity ComplaintEntity: cuid, managed {
  customer_id         : UUID;
  category            : ComplaintCategory default 'OTHER';
  description         : String(1000);
  attachment_urls     : Array of String(500);
  assigned_to         : UUID;
  status              : ComplaintStatus   default 'REGISTERED';
  resolution_date     : DateTime;
  resolution_notes    : String(1000);
  sla_due_date        : DateTime;
}

entity AuditLogEntity: cuid, managed {
  user_id        : UUID;
  user_name      : String(100);
  action         : String(20);
  entity_type    : String(50);
  entity_id      : UUID;
  old_values     : String(2000);
  new_values     : String(2000);
  timestamp      : Timestamp default $now;
  reason_code    : String(50);
}


