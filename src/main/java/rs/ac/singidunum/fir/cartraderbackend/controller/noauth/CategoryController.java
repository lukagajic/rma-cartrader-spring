package rs.ac.singidunum.fir.cartraderbackend.controller.noauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.singidunum.fir.cartraderbackend.dto.category.CategoryDTO;
import rs.ac.singidunum.fir.cartraderbackend.dto.equipmentfeature.EquipmentFeatureDTO;
import rs.ac.singidunum.fir.cartraderbackend.dto.securityfeature.SecurityFeatureDTO;
import rs.ac.singidunum.fir.cartraderbackend.service.CategoryService;
import rs.ac.singidunum.fir.cartraderbackend.service.EquipmentFeatureService;
import rs.ac.singidunum.fir.cartraderbackend.service.SecurityFeatureService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/public/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SecurityFeatureService securityFeatureService;

    @Autowired
    private EquipmentFeatureService equipmentFeatureService;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long categoryId) {
        return new ResponseEntity<>(categoryService.getCategoryDTOById(categoryId), HttpStatus.OK);
    }

    @GetMapping("/{categoryId}/securityFeatures")
    public ResponseEntity<Set<SecurityFeatureDTO>> getSecurityFeaturesForCategory(@PathVariable Long categoryId) {
        return new ResponseEntity<>(securityFeatureService.getSecurityFeatureDTOsForCategory(categoryId), HttpStatus.OK);
    }

    @GetMapping("/{categoryId}/equipmentFeatures")
    public ResponseEntity<Set<EquipmentFeatureDTO>> getEquipmentFeaturesForCategory(@PathVariable Long categoryId) {
        return new ResponseEntity<>(equipmentFeatureService.getEquipmentFeatureDTOsForCategory(categoryId), HttpStatus.OK);
    }
}
