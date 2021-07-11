package rs.ac.singidunum.fir.cartraderbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.fir.cartraderbackend.entity.DoorCountType;
import rs.ac.singidunum.fir.cartraderbackend.exception.notfound.DoorCountTypeNotFoundException;
import rs.ac.singidunum.fir.cartraderbackend.repository.DoorCountTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DoorCountTypeService {
    @Autowired
    private DoorCountTypeRepository doorCountTypeRepository;

    public List<DoorCountType> getAllDoorCountTypes() {
        return doorCountTypeRepository.findAll();
    }

    public DoorCountType getDoorCountTypeById(Long doorCountTypeId) {
        return doorCountTypeRepository.findById(doorCountTypeId).orElseThrow(
            () -> new DoorCountTypeNotFoundException());
    }
}
