package rs.ac.singidunum.fir.cartraderbackend.controller.noauth;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.singidunum.fir.cartraderbackend.entity.GearboxType;
import rs.ac.singidunum.fir.cartraderbackend.service.GearboxTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/public/gearboxTypes")
@AllArgsConstructor
public class GearboxTypeController {
    private final GearboxTypeService gearboxTypeService;

    @GetMapping
    public List<GearboxType> getAllGearboxTypes() {
        return gearboxTypeService.getAllGearboxTypes();
    }

    @GetMapping("/{gearboxTypeId}")
    public GearboxType getGearboxTypeById(@PathVariable Long gearboxTypeId) {
        return gearboxTypeService.getGearboxTypeById(gearboxTypeId);
    }
}
