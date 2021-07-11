package rs.ac.singidunum.fir.cartraderbackend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.fir.cartraderbackend.dto.category.CategoryDTO;
import rs.ac.singidunum.fir.cartraderbackend.entity.Category;
import rs.ac.singidunum.fir.cartraderbackend.exception.notfound.CategoryNotFoundException;
import rs.ac.singidunum.fir.cartraderbackend.repository.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private SecurityFeatureService securityFeatureService;
    @Autowired
    private EquipmentFeatureService equipmentFeatureService;

    public CategoryDTO mapToDto(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setParentCategoryId(category.getParentCategory() != null ? category.getParentCategory().getId() : 0);

        return categoryDTO;
    }

    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream().map(category -> mapToDto(category)).collect(Collectors.toList());
    }

    public CategoryDTO getCategoryDTOById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() ->
            new CategoryNotFoundException()
        );
        return mapToDto(category);
    }

    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(() ->
                new CategoryNotFoundException()
        );
    }

}
