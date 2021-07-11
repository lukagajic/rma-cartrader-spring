package rs.ac.singidunum.fir.cartraderbackend.controller.noauth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.singidunum.fir.cartraderbackend.entity.ColorType;
import rs.ac.singidunum.fir.cartraderbackend.service.ColorTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/public/colorTypes")
public class ColorTypeController {
    @Autowired
    private ColorTypeService colorTypeService;

    @GetMapping
    public List<ColorType> getAllColorTypes() {
        return colorTypeService.getAllColorTypes();
    }

    @GetMapping("/{colorTypeId}")
    public ColorType getColorTypeById(@PathVariable Long colorTypeId) {
        return colorTypeService.getColorTypeById(colorTypeId);
    }
}
