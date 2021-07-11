package rs.ac.singidunum.fir.cartraderbackend.entity;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_equipment_feature")
public class VehicleEquipmentFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "equipment_feature_id")
    private EquipmentFeature equipmentFeature;

    public VehicleEquipmentFeature() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public EquipmentFeature getEquipmentFeature() {
        return equipmentFeature;
    }

    public void setEquipmentFeature(EquipmentFeature equipmentFeature) {
        this.equipmentFeature = equipmentFeature;
    }
}
