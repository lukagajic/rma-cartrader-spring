package rs.ac.singidunum.fir.cartraderbackend.controller.noauth;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.singidunum.fir.cartraderbackend.entity.Manufacturer;
import rs.ac.singidunum.fir.cartraderbackend.entity.Model;
import rs.ac.singidunum.fir.cartraderbackend.service.ManufacturerService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/public/manufacturers")
public class ManufacturerController {
    private final ManufacturerService manufacturerService;

    @GetMapping
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerService.getAllManufacturers();
    }

    @GetMapping("/{manufacturerId}/models")
    public List<Model> getAllModelsByManufacturerId(@PathVariable Long manufacturerId) {
        List<Model> models = new ArrayList<>();

        if (manufacturerId != 0) {
            models = new ArrayList<>(manufacturerService.getManufacturerById(manufacturerId)
                    .get()
                    .getModels());
        }

        return models;
    }
}
