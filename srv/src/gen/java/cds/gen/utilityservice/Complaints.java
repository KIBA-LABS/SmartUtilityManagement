package cds.gen.utilityservice;

import com.sap.cds.CdsData;
import com.sap.cds.Struct;
import com.sap.cds.ql.CdsName;
import java.lang.Object;
import java.lang.String;
import java.time.Instant;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@CdsName("UtilityService.Complaints")
@Generated("cds-maven-plugin")
public interface Complaints extends CdsData {
  String ID = "ID";

  String CREATED_AT = "createdAt";

  String CREATED_BY = "createdBy";

  String MODIFIED_AT = "modifiedAt";

  String MODIFIED_BY = "modifiedBy";

  String CUSTOMER_ID = "customer_id";

  String CATEGORY = "category";

  String DESCRIPTION = "description";

  String ATTACHMENT_URLS = "attachment_urls";

  String ASSIGNED_TO = "assigned_to";

  String STATUS = "status";

  String RESOLUTION_DATE = "resolution_date";

  String RESOLUTION_NOTES = "resolution_notes";

  String SLA_DUE_DATE = "sla_due_date";

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

  @CdsName(CUSTOMER_ID)
  String getCustomerId();

  @CdsName(CUSTOMER_ID)
  void setCustomerId(String customerId);

  String getCategory();

  void setCategory(String category);

  String getDescription();

  void setDescription(String description);

  @CdsName(ATTACHMENT_URLS)
  Collection<String> getAttachmentUrls();

  @CdsName(ATTACHMENT_URLS)
  void setAttachmentUrls(Collection<String> attachmentUrls);

  @CdsName(ASSIGNED_TO)
  String getAssignedTo();

  @CdsName(ASSIGNED_TO)
  void setAssignedTo(String assignedTo);

  String getStatus();

  void setStatus(String status);

  @CdsName(RESOLUTION_DATE)
  Instant getResolutionDate();

  @CdsName(RESOLUTION_DATE)
  void setResolutionDate(Instant resolutionDate);

  @CdsName(RESOLUTION_NOTES)
  String getResolutionNotes();

  @CdsName(RESOLUTION_NOTES)
  void setResolutionNotes(String resolutionNotes);

  @CdsName(SLA_DUE_DATE)
  Instant getSlaDueDate();

  @CdsName(SLA_DUE_DATE)
  void setSlaDueDate(Instant slaDueDate);

  Complaints_ ref();

  static Complaints create() {
    return Struct.create(Complaints.class);
  }

  static Complaints of(Map<String, Object> map) {
    return Struct.access(map).as(Complaints.class);
  }

  static Complaints create(String id) {
    Map<String, Object> keys = new HashMap<>();
    keys.put(ID, id);
    return Struct.access(keys).as(Complaints.class);
  }
}
