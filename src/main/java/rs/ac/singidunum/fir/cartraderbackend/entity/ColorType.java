package rs.ac.singidunum.fir.cartraderbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "color_type")
public class ColorType extends Type {
    public ColorType() {
    }

    public ColorType(Long id, String name) {
        super(id, name);
    }
}
