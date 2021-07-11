package rs.ac.singidunum.fir.cartraderbackend.controller.noauth;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.singidunum.fir.cartraderbackend.entity.FuelType;
import rs.ac.singidunum.fir.cartraderbackend.service.FuelTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/public/fuelTypes")
@AllArgsConstructor
public class FuelTypeController {
    private final FuelTypeService fuelTypeService;

    @GetMapping
    public List<FuelType> getAllFuelTypes() {
        return fuelTypeService.getAllFuelTypes();
    }

    @GetMapping("/{fuelTypeId}")
    public FuelType getFuelTypeById(@PathVariable Long fuelTypeId) {
        return fuelTypeService.getFuelTypeById(fuelTypeId);
    }
}
