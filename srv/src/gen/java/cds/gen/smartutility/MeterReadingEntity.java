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

@CdsName("smartUtility.MeterReadingEntity")
@Generated("cds-maven-plugin")
public interface MeterReadingEntity extends CdsData {
  String ID = "ID";

  String CREATED_AT = "createdAt";

  String CREATED_BY = "createdBy";

  String MODIFIED_AT = "modifiedAt";

  String MODIFIED_BY = "modifiedBy";

  String METER_ID = "meter_id";

  String READING_VALUE = "reading_value";

  String UNIT = "unit";

  String READING_DATE = "reading_date";

  String SOURCE = "source";

  String STATUS = "status";

  String VALIDATION_ERRORS = "validation_errors";

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

  @CdsName(METER_ID)
  String getMeterId();

  @CdsName(METER_ID)
  void setMeterId(String meterId);

  @CdsName(READING_VALUE)
  BigDecimal getReadingValue();

  @CdsName(READING_VALUE)
  void setReadingValue(BigDecimal readingValue);

  String getUnit();

  void setUnit(String unit);

  @CdsName(READING_DATE)
  Instant getReadingDate();

  @CdsName(READING_DATE)
  void setReadingDate(Instant readingDate);

  String getSource();

  void setSource(String source);

  String getStatus();

  void setStatus(String status);

  @CdsName(VALIDATION_ERRORS)
  String getValidationErrors();

  @CdsName(VALIDATION_ERRORS)
  void setValidationErrors(String validationErrors);

  MeterReadingEntity_ ref();

  static MeterReadingEntity create() {
    return Struct.create(MeterReadingEntity.class);
  }

  static MeterReadingEntity of(Map<String, Object> map) {
    return Struct.access(map).as(MeterReadingEntity.class);
  }

  static MeterReadingEntity create(String id) {
    Map<String, Object> keys = new HashMap<>();
    keys.put(ID, id);
    return Struct.access(keys).as(MeterReadingEntity.class);
  }
}
