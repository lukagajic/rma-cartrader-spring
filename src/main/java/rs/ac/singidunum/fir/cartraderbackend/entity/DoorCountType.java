package rs.ac.singidunum.fir.cartraderbackend.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "door_count_type")
public class DoorCountType extends Type {
    public DoorCountType() {
    }

    public DoorCountType(Long id, String name) {
        super(id, name);
    }
}
