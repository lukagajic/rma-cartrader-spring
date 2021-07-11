package rs.ac.singidunum.fir.cartraderbackend.controller.noauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.singidunum.fir.cartraderbackend.entity.DoorCountType;
import rs.ac.singidunum.fir.cartraderbackend.service.DoorCountTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/public/doorCountTypes")
public class DoorCountTypeController {
    @Autowired
    private DoorCountTypeService doorCountTypeService;

    @GetMapping
    public List<DoorCountType> getAllDoorCountTypes() {
        return doorCountTypeService.getAllDoorCountTypes();
    }

    @GetMapping("/{doorCountTypeId}")
    public DoorCountType getDoorCountTypeById(@PathVariable Long doorCountTypeId) {
        return doorCountTypeService.getDoorCountTypeById(doorCountTypeId);
    }
}
