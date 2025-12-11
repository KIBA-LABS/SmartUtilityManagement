package cds.gen.smartutility;

import com.sap.cds.CdsData;
import com.sap.cds.Struct;
import com.sap.cds.ql.CdsName;
import java.lang.Object;
import java.lang.String;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@CdsName("smartUtility.MeterEntity")
@Generated("cds-maven-plugin")
public interface MeterEntity extends CdsData {
  String ID = "ID";

  String CREATED_AT = "createdAt";

  String CREATED_BY = "createdBy";

  String MODIFIED_AT = "modifiedAt";

  String MODIFIED_BY = "modifiedBy";

  String METER_NUMBER = "meter_number";

  String CUSTOMER_ID = "customer_id";

  String METER_TYPE = "meter_type";

  String LOCATION = "location";

  String INSTALLATION_DATE = "installation_date";

  String CALIBRATION_DUE_DATE = "calibration_due_date";

  String STATUS = "status";

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

  @CdsName(METER_NUMBER)
  String getMeterNumber();

  @CdsName(METER_NUMBER)
  void setMeterNumber(String meterNumber);

  @CdsName(CUSTOMER_ID)
  String getCustomerId();

  @CdsName(CUSTOMER_ID)
  void setCustomerId(String customerId);

  @CdsName(METER_TYPE)
  String getMeterType();

  @CdsName(METER_TYPE)
  void setMeterType(String meterType);

  String getLocation();

  void setLocation(String location);

  @CdsName(INSTALLATION_DATE)
  LocalDate getInstallationDate();

  @CdsName(INSTALLATION_DATE)
  void setInstallationDate(LocalDate installationDate);

  @CdsName(CALIBRATION_DUE_DATE)
  LocalDate getCalibrationDueDate();

  @CdsName(CALIBRATION_DUE_DATE)
  void setCalibrationDueDate(LocalDate calibrationDueDate);

  String getStatus();

  void setStatus(String status);

  MeterEntity_ ref();

  static MeterEntity create() {
    return Struct.create(MeterEntity.class);
  }

  static MeterEntity of(Map<String, Object> map) {
    return Struct.access(map).as(MeterEntity.class);
  }

  static MeterEntity create(String id) {
    Map<String, Object> keys = new HashMap<>();
    keys.put(ID, id);
    return Struct.access(keys).as(MeterEntity.class);
  }
}
