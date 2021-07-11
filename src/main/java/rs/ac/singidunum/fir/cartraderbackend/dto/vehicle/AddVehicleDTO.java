package rs.ac.singidunum.fir.cartraderbackend.dto.vehicle;

import java.util.List;

public class AddVehicleDTO {
    private long modelId;
    private long fuelTypeId;
    private long categoryId;
    private long doorCountTypeId;
    private long colorTypeId;
    private long userId;
    private long gearboxTypeId;
    private int engineCapacity;
    private int enginePower;
    private int year;
    private int price;
    private String registrationExpiresAt;
    private boolean fromOwner;
    private String excerpt;
    private String description;
    private int mileage;

    private List<String> securityFeatures;
    private List<String> equipmentFeatures;

    public List<String> getSecurityFeatures() {
        return securityFeatures;
    }

    public void setSecurityFeatures(List<String> securityFeatures) {
        this.securityFeatures = securityFeatures;
    }

    public List<String> getEquipmentFeatures() {
        return equipmentFeatures;
    }

    public void setEquipmentFeatures(List<String> equipmentFeatures) {
        this.equipmentFeatures = equipmentFeatures;
    }

    public long getModelId() {
        return modelId;
    }

    public void setModelId(long modelId) {
        this.modelId = modelId;
    }

    public long getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(long fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public long getDoorCountTypeId() {
        return doorCountTypeId;
    }

    public void setDoorCountTypeId(long doorCountTypeId) {
        this.doorCountTypeId = doorCountTypeId;
    }

    public long getColorTypeId() {
        return colorTypeId;
    }

    public void setColorTypeId(long colorTypeId) {
        this.colorTypeId = colorTypeId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getGearboxTypeId() {
        return gearboxTypeId;
    }

    public void setGearboxTypeId(long gearboxTypeId) {
        this.gearboxTypeId = gearboxTypeId;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRegistrationExpiresAt() {
        return registrationExpiresAt;
    }

    public void setRegistrationExpiresAt(String registrationExpiresAt) {
        this.registrationExpiresAt = registrationExpiresAt;
    }

    public boolean isFromOwner() {
        return fromOwner;
    }

    public void setFromOwner(boolean fromOwner) {
        fromOwner = fromOwner;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
}
