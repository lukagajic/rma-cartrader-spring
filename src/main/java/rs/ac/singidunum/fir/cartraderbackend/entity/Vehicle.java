package rs.ac.singidunum.fir.cartraderbackend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @Column
    private String excerpt;

    @ManyToOne(targetEntity = FuelType.class)
    @JoinColumn(name = "fuel_type_id")
    private FuelType fuelType;

    @ManyToOne(targetEntity = ColorType.class)
    @JoinColumn(name = "color_type_id")
    private ColorType colorType;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "door_count_type_id")
    private DoorCountType doorCountType;

    @ManyToOne
    @JoinColumn(name = "gearbox_type_id")
    private GearboxType gearboxType;

    @Column(name = "engine_capacity")
    private Integer engineCapacity;

    @Column
    private Integer mileage;

    @Column
    private Integer price;

    @Column
    private Integer year;

    @Column
    private Integer enginePower;

    @Column
    private String description;

    @Column(name = "is_from_owner")
    private boolean isFromOwner;

    @Column(name = "registration_expires_at")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = "Europe/Paris")
    private Date registrationExpiresAt;

    @Column(name = "created_at")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", shape = JsonFormat.Shape.STRING, timezone = "Europe/Paris")
    private Date createdAt;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Photo> photos;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VehicleSecurityFeature> vehicleSecurityFeatures;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VehicleEquipmentFeature> vehicleEquipmentFeatures;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public ColorType getColorType() {
        return colorType;
    }

    public void setColorType(ColorType colorType) {
        this.colorType = colorType;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public DoorCountType getDoorCountType() {
        return doorCountType;
    }

    public void setDoorCountType(DoorCountType doorCountType) {
        this.doorCountType = doorCountType;
    }

    public GearboxType getGearboxType() {
        return gearboxType;
    }

    public void setGearboxType(GearboxType gearboxType) {
        this.gearboxType = gearboxType;
    }

    public Integer getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Integer engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(Integer enginePower) {
        this.enginePower = enginePower;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Set<Photo> getPhotos() {
        return photos;
    }
    public void setPhotos(Set<Photo> photos) {
        this.photos = photos;
    }

    public Set<VehicleSecurityFeature> getVehicleSecurityFeatures() {
        return vehicleSecurityFeatures;
    }

    public void setVehicleSecurityFeatures(Set<VehicleSecurityFeature> vehicleSecurityFeatures) {
        this.vehicleSecurityFeatures = vehicleSecurityFeatures;
    }

    public Set<VehicleEquipmentFeature> getVehicleEquipmentFeatures() {
        return vehicleEquipmentFeatures;
    }

    public void setVehicleEquipmentFeatures(Set<VehicleEquipmentFeature> vehicleEquipmentFeatures) {
        this.vehicleEquipmentFeatures = vehicleEquipmentFeatures;
    }
}
