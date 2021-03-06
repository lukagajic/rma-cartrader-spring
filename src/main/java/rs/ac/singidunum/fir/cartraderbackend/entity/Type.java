package rs.ac.singidunum.fir.cartraderbackend.entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class Type {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String name;

    public Type() {
    }

    public Type(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
