package rs.ac.singidunum.fir.cartraderbackend.dto.equipmentfeature;

import rs.ac.singidunum.fir.cartraderbackend.dto.category.CategoryDTO;

public class EquipmentFeatureDTO {
    private long id;
    private String name;
    private CategoryDTO categoryDTO;

    public long getId() {
        return id;
    }

    public void setEquipmentFeatureId(long equipmentFeatureId) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }
}
