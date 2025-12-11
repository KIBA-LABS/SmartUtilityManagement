package cds.gen.utilityservice;

import com.sap.cds.ql.CdsName;
import com.sap.cds.services.cds.ApplicationService;
import com.sap.cds.services.cds.CqnService;
import com.sap.cds.services.cds.RemoteService;
import java.lang.String;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

@Generated("cds-maven-plugin")
@CdsName(UtilityService_.CDS_NAME)
public interface UtilityService extends CqnService {
  @CdsName(SubmitMeterReadingContext.CDS_NAME)
  MeterReadings submitMeterReading(@CdsName(SubmitMeterReadingContext.METER_ID) String meterId,
      @CdsName(SubmitMeterReadingContext.VALUE) BigDecimal value,
      @CdsName(SubmitMeterReadingContext.SOURCE) String source);

  @CdsName(RefreshTokenContext.CDS_NAME)
  RefreshTokenContext.ReturnType refreshToken(
      @CdsName(RefreshTokenContext.REFRESH_TOKEN) String refreshToken);

  @CdsName(RecordPaymentContext.CDS_NAME)
  Payments recordPayment(@CdsName(RecordPaymentContext.BILL_ID) String billId,
      @CdsName(RecordPaymentContext.AMOUNT) BigDecimal amount,
      @CdsName(RecordPaymentContext.METHOD) String method);

  @CdsName(ComputeBillContext.CDS_NAME)
  Bills computeBill(@CdsName(ComputeBillContext.CUSTOMER_ID) String customerId,
      @CdsName(ComputeBillContext.METER_ID) String meterId,
      @CdsName(ComputeBillContext.PERIOD_START) LocalDate periodStart,
      @CdsName(ComputeBillContext.PERIOD_END) LocalDate periodEnd);

  @CdsName(LoginContext.CDS_NAME)
  LoginContext.ReturnType login(@CdsName(LoginContext.EMAIL) String email,
      @CdsName(LoginContext.PASSWORD) String password);

  @CdsName(RegisterComplaintContext.CDS_NAME)
  Complaints registerComplaint(@CdsName(RegisterComplaintContext.CUSTOMER_ID) String customerId,
      @CdsName(RegisterComplaintContext.CATEGORY) String category,
      @CdsName(RegisterComplaintContext.DESCRIPTION) String description);

  interface Application extends ApplicationService, UtilityService {
  }

  interface Remote extends RemoteService, UtilityService {
  }
}
