package rs.ac.singidunum.fir.cartraderbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.fir.cartraderbackend.dto.equipmentfeature.EquipmentFeatureDTO;
import rs.ac.singidunum.fir.cartraderbackend.entity.Category;
import rs.ac.singidunum.fir.cartraderbackend.entity.EquipmentFeature;
import rs.ac.singidunum.fir.cartraderbackend.exception.notfound.CategoryNotFoundException;
import rs.ac.singidunum.fir.cartraderbackend.repository.CategoryRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EquipmentFeatureService {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    public EquipmentFeatureDTO mapToDto(EquipmentFeature equipmentFeature) {
        EquipmentFeatureDTO equipmentFeatureDTO = new EquipmentFeatureDTO();

        equipmentFeatureDTO.setEquipmentFeatureId(equipmentFeature.getId());
        equipmentFeatureDTO.setName(equipmentFeature.getName());
        equipmentFeatureDTO.setCategoryDTO(categoryService.mapToDto(equipmentFeature.getCategory()));

        return equipmentFeatureDTO;
    }

    public Set<EquipmentFeatureDTO> getEquipmentFeatureDTOsForCategory(Long categoryId) {
        Category foundCategory = categoryRepository.findById(categoryId).orElseThrow(
                () -> new CategoryNotFoundException()
        );
        return foundCategory.getParentCategory().getEquipmentFeatures().stream()
                .map(equipmentFeature -> this.mapToDto(equipmentFeature)).collect(Collectors.toSet());
    }
}
