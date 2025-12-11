
DROP VIEW IF EXISTS UtilityService_AuditLogs;
DROP VIEW IF EXISTS UtilityService_Complaints;
DROP VIEW IF EXISTS UtilityService_Payments;
DROP VIEW IF EXISTS UtilityService_Bills;
DROP VIEW IF EXISTS UtilityService_MeterReadings;
DROP VIEW IF EXISTS UtilityService_Meters;
DROP VIEW IF EXISTS UtilityService_Customers;
DROP TABLE IF EXISTS cds_outbox_Messages;
DROP TABLE IF EXISTS smartUtility_AuditLogEntity;
DROP TABLE IF EXISTS smartUtility_ComplaintEntity;
DROP TABLE IF EXISTS smartUtility_PaymentEntity;
DROP TABLE IF EXISTS smartUtility_BillEntity;
DROP TABLE IF EXISTS smartUtility_MeterReadingEntity;
DROP TABLE IF EXISTS smartUtility_MeterEntity;
DROP TABLE IF EXISTS smartUtility_CustomerEntity;

CREATE TABLE smartUtility_CustomerEntity (
  ID NVARCHAR(36) NOT NULL,
  createdAt TIMESTAMP(7),
  createdBy NVARCHAR(255),
  modifiedAt TIMESTAMP(7),
  modifiedBy NVARCHAR(255),
  name NVARCHAR(100),
  email NVARCHAR(100),
  password NVARCHAR(255),
  role NVARCHAR(255) DEFAULT 'CUSTOMER',
  phone NVARCHAR(20),
  address NVARCHAR(200),
  account_type NVARCHAR(255) DEFAULT 'RESIDENTIAL',
  region NVARCHAR(50),
  category NVARCHAR(50),
  status NVARCHAR(255) DEFAULT 'ACTIVE',
  PRIMARY KEY(ID)
);

CREATE TABLE smartUtility_MeterEntity (
  ID NVARCHAR(36) NOT NULL,
  createdAt TIMESTAMP(7),
  createdBy NVARCHAR(255),
  modifiedAt TIMESTAMP(7),
  modifiedBy NVARCHAR(255),
  meter_number NVARCHAR(50),
  customer_id NVARCHAR(36),
  meter_type NVARCHAR(20) DEFAULT 'DIGITAL',
  location NVARCHAR(200),
  installation_date DATE,
  calibration_due_date DATE,
  status NVARCHAR(30) DEFAULT 'ACTIVE',
  PRIMARY KEY(ID)
);

CREATE TABLE smartUtility_MeterReadingEntity (
  ID NVARCHAR(36) NOT NULL,
  createdAt TIMESTAMP(7),
  createdBy NVARCHAR(255),
  modifiedAt TIMESTAMP(7),
  modifiedBy NVARCHAR(255),
  meter_id NVARCHAR(36),
  reading_value DECIMAL(15, 3),
  unit NVARCHAR(10) DEFAULT 'kWh',
  reading_date TIMESTAMP(0),
  source NVARCHAR(20) DEFAULT 'MANUAL',
  status NVARCHAR(30) DEFAULT 'PENDING_VALIDATION',
  validation_errors NVARCHAR(1000),
  PRIMARY KEY(ID)
);

CREATE TABLE smartUtility_BillEntity (
  ID NVARCHAR(36) NOT NULL,
  createdAt TIMESTAMP(7),
  createdBy NVARCHAR(255),
  modifiedAt TIMESTAMP(7),
  modifiedBy NVARCHAR(255),
  bill_number NVARCHAR(50),
  customer_id NVARCHAR(36),
  meter_id NVARCHAR(36),
  billing_period_start DATE,
  billing_period_end DATE,
  consumption_units DECIMAL(15, 3),
  consumption_charges DECIMAL(15, 2),
  fixed_charges DECIMAL(15, 2) DEFAULT 0.0,
  tax DECIMAL(15, 2) DEFAULT 0.0,
  surcharge DECIMAL(15, 2) DEFAULT 0.0,
  total_amount DECIMAL(15, 2),
  due_date DATE,
  status NVARCHAR(255) DEFAULT 'GENERATED',
  adjustment_amount DECIMAL(15, 2) DEFAULT 0.0,
  PRIMARY KEY(ID)
);

CREATE TABLE smartUtility_PaymentEntity (
  ID NVARCHAR(36) NOT NULL,
  createdAt TIMESTAMP(7),
  createdBy NVARCHAR(255),
  modifiedAt TIMESTAMP(7),
  modifiedBy NVARCHAR(255),
  bill_id NVARCHAR(36),
  customer_id NVARCHAR(36),
  amount DECIMAL(15, 2),
  payment_method NVARCHAR(255) DEFAULT 'ONLINE',
  gateway_transaction_id NVARCHAR(100),
  payment_date TIMESTAMP(0),
  status NVARCHAR(20) DEFAULT 'PENDING',
  receipt_number NVARCHAR(50),
  PRIMARY KEY(ID)
);

CREATE TABLE smartUtility_ComplaintEntity (
  ID NVARCHAR(36) NOT NULL,
  createdAt TIMESTAMP(7),
  createdBy NVARCHAR(255),
  modifiedAt TIMESTAMP(7),
  modifiedBy NVARCHAR(255),
  customer_id NVARCHAR(36),
  category NVARCHAR(255) DEFAULT 'OTHER',
  description NVARCHAR(1000),
  attachment_urls NCLOB,
  assigned_to NVARCHAR(36),
  status NVARCHAR(255) DEFAULT 'REGISTERED',
  resolution_date TIMESTAMP(0),
  resolution_notes NVARCHAR(1000),
  sla_due_date TIMESTAMP(0),
  PRIMARY KEY(ID)
);

CREATE TABLE smartUtility_AuditLogEntity (
  ID NVARCHAR(36) NOT NULL,
  createdAt TIMESTAMP(7),
  createdBy NVARCHAR(255),
  modifiedAt TIMESTAMP(7),
  modifiedBy NVARCHAR(255),
  user_id NVARCHAR(36),
  user_name NVARCHAR(100),
  action NVARCHAR(20),
  entity_type NVARCHAR(50),
  entity_id NVARCHAR(36),
  old_values NVARCHAR(2000),
  new_values NVARCHAR(2000),
  timestamp TIMESTAMP(7) DEFAULT current_timestamp,
  reason_code NVARCHAR(50),
  PRIMARY KEY(ID)
);

CREATE TABLE cds_outbox_Messages (
  ID NVARCHAR(36) NOT NULL,
  timestamp TIMESTAMP(7),
  target NVARCHAR(255),
  msg NCLOB,
  attempts INTEGER DEFAULT 0,
  "PARTITION" INTEGER DEFAULT 0,
  lastError NCLOB,
  lastAttemptTimestamp TIMESTAMP(7),
  status NVARCHAR(23),
  PRIMARY KEY(ID)
);

CREATE VIEW UtilityService_Customers AS SELECT
  CustomerEntity_0.ID,
  CustomerEntity_0.createdAt,
  CustomerEntity_0.createdBy,
  CustomerEntity_0.modifiedAt,
  CustomerEntity_0.modifiedBy,
  CustomerEntity_0.name,
  CustomerEntity_0.email,
  CustomerEntity_0.password,
  CustomerEntity_0.role,
  CustomerEntity_0.phone,
  CustomerEntity_0.address,
  CustomerEntity_0.account_type,
  CustomerEntity_0.region,
  CustomerEntity_0.category,
  CustomerEntity_0.status
FROM smartUtility_CustomerEntity AS CustomerEntity_0;

CREATE VIEW UtilityService_Meters AS SELECT
  MeterEntity_0.ID,
  MeterEntity_0.createdAt,
  MeterEntity_0.createdBy,
  MeterEntity_0.modifiedAt,
  MeterEntity_0.modifiedBy,
  MeterEntity_0.meter_number,
  MeterEntity_0.customer_id,
  MeterEntity_0.meter_type,
  MeterEntity_0.location,
  MeterEntity_0.installation_date,
  MeterEntity_0.calibration_due_date,
  MeterEntity_0.status
FROM smartUtility_MeterEntity AS MeterEntity_0;

CREATE VIEW UtilityService_MeterReadings AS SELECT
  MeterReadingEntity_0.ID,
  MeterReadingEntity_0.createdAt,
  MeterReadingEntity_0.createdBy,
  MeterReadingEntity_0.modifiedAt,
  MeterReadingEntity_0.modifiedBy,
  MeterReadingEntity_0.meter_id,
  MeterReadingEntity_0.reading_value,
  MeterReadingEntity_0.unit,
  MeterReadingEntity_0.reading_date,
  MeterReadingEntity_0.source,
  MeterReadingEntity_0.status,
  MeterReadingEntity_0.validation_errors
FROM smartUtility_MeterReadingEntity AS MeterReadingEntity_0;

CREATE VIEW UtilityService_Bills AS SELECT
  BillEntity_0.ID,
  BillEntity_0.createdAt,
  BillEntity_0.createdBy,
  BillEntity_0.modifiedAt,
  BillEntity_0.modifiedBy,
  BillEntity_0.bill_number,
  BillEntity_0.customer_id,
  BillEntity_0.meter_id,
  BillEntity_0.billing_period_start,
  BillEntity_0.billing_period_end,
  BillEntity_0.consumption_units,
  BillEntity_0.consumption_charges,
  BillEntity_0.fixed_charges,
  BillEntity_0.tax,
  BillEntity_0.surcharge,
  BillEntity_0.total_amount,
  BillEntity_0.due_date,
  BillEntity_0.status,
  BillEntity_0.adjustment_amount
FROM smartUtility_BillEntity AS BillEntity_0;

CREATE VIEW UtilityService_Payments AS SELECT
  PaymentEntity_0.ID,
  PaymentEntity_0.createdAt,
  PaymentEntity_0.createdBy,
  PaymentEntity_0.modifiedAt,
  PaymentEntity_0.modifiedBy,
  PaymentEntity_0.bill_id,
  PaymentEntity_0.customer_id,
  PaymentEntity_0.amount,
  PaymentEntity_0.payment_method,
  PaymentEntity_0.gateway_transaction_id,
  PaymentEntity_0.payment_date,
  PaymentEntity_0.status,
  PaymentEntity_0.receipt_number
FROM smartUtility_PaymentEntity AS PaymentEntity_0;

CREATE VIEW UtilityService_Complaints AS SELECT
  ComplaintEntity_0.ID,
  ComplaintEntity_0.createdAt,
  ComplaintEntity_0.createdBy,
  ComplaintEntity_0.modifiedAt,
  ComplaintEntity_0.modifiedBy,
  ComplaintEntity_0.customer_id,
  ComplaintEntity_0.category,
  ComplaintEntity_0.description,
  ComplaintEntity_0.attachment_urls,
  ComplaintEntity_0.assigned_to,
  ComplaintEntity_0.status,
  ComplaintEntity_0.resolution_date,
  ComplaintEntity_0.resolution_notes,
  ComplaintEntity_0.sla_due_date
FROM smartUtility_ComplaintEntity AS ComplaintEntity_0;

CREATE VIEW UtilityService_AuditLogs AS SELECT
  AuditLogEntity_0.ID,
  AuditLogEntity_0.createdAt,
  AuditLogEntity_0.createdBy,
  AuditLogEntity_0.modifiedAt,
  AuditLogEntity_0.modifiedBy,
  AuditLogEntity_0.user_id,
  AuditLogEntity_0.user_name,
  AuditLogEntity_0.action,
  AuditLogEntity_0.entity_type,
  AuditLogEntity_0.entity_id,
  AuditLogEntity_0.timestamp,
  AuditLogEntity_0.reason_code
FROM smartUtility_AuditLogEntity AS AuditLogEntity_0;
