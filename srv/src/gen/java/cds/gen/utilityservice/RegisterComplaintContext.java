package cds.gen.utilityservice;

import com.sap.cds.services.EventContext;
import com.sap.cds.services.EventName;
import java.lang.Override;
import java.lang.String;
import javax.annotation.processing.Generated;

@EventName("registerComplaint")
@Generated("cds-maven-plugin")
public interface RegisterComplaintContext extends EventContext {
  String CUSTOMER_ID = "customerId";

  String CATEGORY = "category";

  String DESCRIPTION = "description";

  String CDS_NAME = "registerComplaint";

  String getCustomerId();

  void setCustomerId(String customerId);

  String getCategory();

  void setCategory(String category);

  String getDescription();

  void setDescription(String description);

  @Override
  UtilityService getService();

  void setResult(Complaints result);

  Complaints getResult();

  static RegisterComplaintContext create() {
    return EventContext.create(RegisterComplaintContext.class, null);
  }
}
