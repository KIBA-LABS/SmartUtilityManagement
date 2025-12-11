package cds.gen.smartutility;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.LinkedStructuredType;
import java.lang.String;
import java.math.BigDecimal;
import java.time.Instant;
import javax.annotation.processing.Generated;

@CdsName("smartUtility.PaymentEntity")
@Generated("cds-maven-plugin")
public interface PaymentEntity_ extends LinkedStructuredType<PaymentEntity, PaymentEntity_> {
  String ID = "ID";

  String BILL_ID = "bill_id";

  String CUSTOMER_ID = "customer_id";

  String PAYMENT_METHOD = "payment_method";

  String GATEWAY_TRANSACTION_ID = "gateway_transaction_id";

  String PAYMENT_DATE = "payment_date";

  String RECEIPT_NUMBER = "receipt_number";

  String CDS_NAME = "smartUtility.PaymentEntity";

  @CdsName(ID)
  ElementRef<String> ID();

  ElementRef<Instant> createdAt();

  ElementRef<String> createdBy();

  ElementRef<Instant> modifiedAt();

  ElementRef<String> modifiedBy();

  @CdsName(BILL_ID)
  ElementRef<String> bill_id();

  @CdsName(CUSTOMER_ID)
  ElementRef<String> customer_id();

  ElementRef<BigDecimal> amount();

  @CdsName(PAYMENT_METHOD)
  ElementRef<String> payment_method();

  @CdsName(GATEWAY_TRANSACTION_ID)
  ElementRef<String> gateway_transaction_id();

  @CdsName(PAYMENT_DATE)
  ElementRef<Instant> payment_date();

  ElementRef<String> status();

  @CdsName(RECEIPT_NUMBER)
  ElementRef<String> receipt_number();
}
