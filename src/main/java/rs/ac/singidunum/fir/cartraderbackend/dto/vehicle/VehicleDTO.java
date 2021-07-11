package rs.ac.singidunum.fir.cartraderbackend.dto.vehicle;

import com.fasterxml.jackson.annotation.JsonFormat;
import rs.ac.singidunum.fir.cartraderbackend.dto.user.UserDTO;

import java.util.Date;
import java.util.Set;

public class VehicleDTO {
    private long id;
    private String manufacturer;
    private String model;
    private String fullModelName;
    private String gearboxType;
    private String category;
    private String fuelType;
    private String colorType;
    private String doorCountType;
    private String excerpt;
    private String description;
    private int engineCapacity;
    private int enginePower;
    private int mileage;
    private int price;
    private int year;
    private boolean isFromOwner;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = "Europe/Paris")
    private Date registrationExpiresAt;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = "Europe/Paris")
    private Date createdAt;
    private Set<String> photos;
    private Set<String> securityFeatures;
    private Set<String> equipmentFeatures;
    private UserDTO user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullModelName() {
        return fullModelName;
    }

    public void setFullModelName(String fullModelName) {
        this.fullModelName = fullModelName;
    }

    public String getGearboxType() {
        return gearboxType;
    }

    public void setGearboxType(String gearboxType) {
        this.gearboxType = gearboxType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getColorType() {
        return colorType;
    }

    public void setColorType(String colorType) {
        this.colorType = colorType;
    }

    public String getDoorCountType() {
        return doorCountType;
    }

    public void setDoorCountType(String doorCountType) {
        this.doorCountType = doorCountType;
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

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isFromOwner() {
        return isFromOwner;
    }

    public void setFromOwner(boolean fromOwner) {
        isFromOwner = fromOwner;
    }

    public Date getRegistrationExpiresAt() {
        return registrationExpiresAt;
    }

    public void setRegistrationExpiresAt(Date registrationExpiresAt) {
        this.registrationExpiresAt = registrationExpiresAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Set<String> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<String> photos) {
        this.photos = photos;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Set<String> getSecurityFeatures() {
        return securityFeatures;
    }

    public void setSecurityFeatures(Set<String> securityFeatures) {
        this.securityFeatures = securityFeatures;
    }

    public Set<String> getEquipmentFeatures() {
        return equipmentFeatures;
    }

    public void setEquipmentFeatures(Set<String> equipmentFeatures) {
        this.equipmentFeatures = equipmentFeatures;
    }
}
