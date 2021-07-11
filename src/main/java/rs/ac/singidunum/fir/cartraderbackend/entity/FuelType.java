package rs.ac.singidunum.fir.cartraderbackend.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "fuel_type")
public class FuelType extends Type {
    public FuelType() {
    }

    public FuelType(Long id, String name) {
        super(id, name);
    }


}
