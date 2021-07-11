package rs.ac.singidunum.fir.cartraderbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.fir.cartraderbackend.entity.FuelType;
import rs.ac.singidunum.fir.cartraderbackend.exception.notfound.FuelTypeNotFoundException;
import rs.ac.singidunum.fir.cartraderbackend.repository.FuelTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FuelTypeService {
    @Autowired
    private FuelTypeRepository fuelTypeRepository;

    public List<FuelType> getAllFuelTypes() {
        return fuelTypeRepository.findAll();
    }

    public FuelType getFuelTypeById(Long fuelTypeId) {
        return fuelTypeRepository.findById(fuelTypeId).orElseThrow(() ->  new FuelTypeNotFoundException());
    }
}
