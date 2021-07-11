package rs.ac.singidunum.fir.cartraderbackend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.fir.cartraderbackend.entity.Manufacturer;
import rs.ac.singidunum.fir.cartraderbackend.entity.Model;
import rs.ac.singidunum.fir.cartraderbackend.repository.ManufacturerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class ManufacturerService {
    @Autowired
    private ManufacturerRepository manufacturerRepository;
    @Autowired
    private ModelService modelService;

    public List<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAll();
    }

    public Optional<Manufacturer> getManufacturerById(Long manufacturerId) {
        return manufacturerRepository.findById(manufacturerId);
    }

    public List<Model> getAllModelsForManufacturer(Long manufacturerId) {
        Optional<Manufacturer> manufacturer = getManufacturerById(manufacturerId);

        List<Model> models = new ArrayList<>();

        if (manufacturer.isPresent()) {
            models = modelService.getAllModelsByManufacturer(manufacturer.get());
        }
        return models;
    }
}
