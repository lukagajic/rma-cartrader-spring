package rs.ac.singidunum.fir.cartraderbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.fir.cartraderbackend.dto.securityfeature.SecurityFeatureDTO;
import rs.ac.singidunum.fir.cartraderbackend.entity.Category;
import rs.ac.singidunum.fir.cartraderbackend.entity.SecurityFeature;
import rs.ac.singidunum.fir.cartraderbackend.exception.notfound.CategoryNotFoundException;
import rs.ac.singidunum.fir.cartraderbackend.repository.CategoryRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SecurityFeatureService {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    public SecurityFeatureDTO mapToDto(SecurityFeature securityFeature) {
        SecurityFeatureDTO securityFeatureDTO = new SecurityFeatureDTO();

        securityFeatureDTO.setId(securityFeature.getId());
        securityFeatureDTO.setName(securityFeature.getName());
        securityFeatureDTO.setCategory(categoryService.mapToDto(securityFeature.getCategory()));

        return securityFeatureDTO;
    }

    public Set<SecurityFeatureDTO> getSecurityFeatureDTOsForCategory(Long categoryId) {
        Category foundCategory = categoryRepository.findById(categoryId).orElseThrow(
                () -> new CategoryNotFoundException()
        );
        return foundCategory.getParentCategory().getSecurityFeatures().stream()
                .map(securityFeature -> this.mapToDto(securityFeature)).collect(Collectors.toSet());
    }
}
