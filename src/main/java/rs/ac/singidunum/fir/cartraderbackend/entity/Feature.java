package rs.ac.singidunum.fir.cartraderbackend.entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class Feature {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String name;

    public Feature() {
    }

    public Feature(Long id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
