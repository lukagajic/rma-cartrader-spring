package rs.ac.singidunum.fir.cartraderbackend.dto.securityfeature;

import rs.ac.singidunum.fir.cartraderbackend.dto.category.CategoryDTO;

public class SecurityFeatureDTO {
    private long id;
    private String name;
    private CategoryDTO category;

    public SecurityFeatureDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }
}
