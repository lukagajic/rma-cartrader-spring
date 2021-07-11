package rs.ac.singidunum.fir.cartraderbackend.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent__category_id")
    private Category parentCategory;

    @OneToMany
    @JoinColumn(name = "category_id")
    private Set<SecurityFeature> securityFeatures;

    @OneToMany
    @JoinColumn(name = "category_id")
    private Set<EquipmentFeature> equipmentFeatures;

    public Category() {
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

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Set<SecurityFeature> getSecurityFeatures() {
        return securityFeatures;
    }

    public void setSecurityFeatures(Set<SecurityFeature> securityFeatures) {
        this.securityFeatures = securityFeatures;
    }

    public Set<EquipmentFeature> getEquipmentFeatures() {
        return equipmentFeatures;
    }

    public void setEquipmentFeatures(Set<EquipmentFeature> equipmentFeatures) {
        this.equipmentFeatures = equipmentFeatures;
    }
}
