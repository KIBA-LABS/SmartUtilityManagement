package cds.gen.smartutility;

import com.sap.cds.CdsData;
import com.sap.cds.Struct;
import com.sap.cds.ql.CdsName;
import java.lang.Object;
import java.lang.String;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@CdsName("smartUtility.PaymentEntity")
@Generated("cds-maven-plugin")
public interface PaymentEntity extends CdsData {
  String ID = "ID";

  String CREATED_AT = "createdAt";

  String CREATED_BY = "createdBy";

  String MODIFIED_AT = "modifiedAt";

  String MODIFIED_BY = "modifiedBy";

  String BILL_ID = "bill_id";

  String CUSTOMER_ID = "customer_id";

  String AMOUNT = "amount";

  String PAYMENT_METHOD = "payment_method";

  String GATEWAY_TRANSACTION_ID = "gateway_transaction_id";

  String PAYMENT_DATE = "payment_date";

  String STATUS = "status";

  String RECEIPT_NUMBER = "receipt_number";

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

  @CdsName(BILL_ID)
  String getBillId();

  @CdsName(BILL_ID)
  void setBillId(String billId);

  @CdsName(CUSTOMER_ID)
  String getCustomerId();

  @CdsName(CUSTOMER_ID)
  void setCustomerId(String customerId);

  BigDecimal getAmount();

  void setAmount(BigDecimal amount);

  @CdsName(PAYMENT_METHOD)
  String getPaymentMethod();

  @CdsName(PAYMENT_METHOD)
  void setPaymentMethod(String paymentMethod);

  @CdsName(GATEWAY_TRANSACTION_ID)
  String getGatewayTransactionId();

  @CdsName(GATEWAY_TRANSACTION_ID)
  void setGatewayTransactionId(String gatewayTransactionId);

  @CdsName(PAYMENT_DATE)
  Instant getPaymentDate();

  @CdsName(PAYMENT_DATE)
  void setPaymentDate(Instant paymentDate);

  String getStatus();

  void setStatus(String status);

  @CdsName(RECEIPT_NUMBER)
  String getReceiptNumber();

  @CdsName(RECEIPT_NUMBER)
  void setReceiptNumber(String receiptNumber);

  PaymentEntity_ ref();

  static PaymentEntity create() {
    return Struct.create(PaymentEntity.class);
  }

  static PaymentEntity of(Map<String, Object> map) {
    return Struct.access(map).as(PaymentEntity.class);
  }

  static PaymentEntity create(String id) {
    Map<String, Object> keys = new HashMap<>();
    keys.put(ID, id);
    return Struct.access(keys).as(PaymentEntity.class);
  }
}
