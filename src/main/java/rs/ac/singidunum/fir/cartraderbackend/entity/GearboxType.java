package rs.ac.singidunum.fir.cartraderbackend.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "gearbox_type")
public class GearboxType extends Type {
    public GearboxType(Long id, String name) {
        super(id, name);
    }

    public GearboxType() {

    }
}
