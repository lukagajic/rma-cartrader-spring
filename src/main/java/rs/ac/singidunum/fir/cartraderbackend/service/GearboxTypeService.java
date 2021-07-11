package rs.ac.singidunum.fir.cartraderbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.fir.cartraderbackend.entity.GearboxType;
import rs.ac.singidunum.fir.cartraderbackend.exception.notfound.GearboxTypeNotFoundException;
import rs.ac.singidunum.fir.cartraderbackend.repository.GearboxTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GearboxTypeService {
    @Autowired
    private GearboxTypeRepository gearboxTypeRepository;

    public List<GearboxType> getAllGearboxTypes() {
        return gearboxTypeRepository.findAll();
    }

    public GearboxType getGearboxTypeById(Long gearboxTypeId) {
        return gearboxTypeRepository.findById(gearboxTypeId).orElseThrow(
            () -> new GearboxTypeNotFoundException()
        );
    }
}
