package rs.ac.singidunum.fir.cartraderbackend.entity;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_security_feature")
public class VehicleSecurityFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "security_feature_id")
    private SecurityFeature securityFeature;

    public VehicleSecurityFeature() {
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

    public SecurityFeature getSecurityFeature() {
        return securityFeature;
    }

    public void setSecurityFeature(SecurityFeature securityFeature) {
        this.securityFeature = securityFeature;
    }
}
