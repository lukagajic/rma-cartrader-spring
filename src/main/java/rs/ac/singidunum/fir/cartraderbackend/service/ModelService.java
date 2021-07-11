package rs.ac.singidunum.fir.cartraderbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.fir.cartraderbackend.entity.Manufacturer;
import rs.ac.singidunum.fir.cartraderbackend.entity.Model;
import rs.ac.singidunum.fir.cartraderbackend.entity.Vehicle;
import rs.ac.singidunum.fir.cartraderbackend.exception.notfound.ModelNotFoundException;
import rs.ac.singidunum.fir.cartraderbackend.repository.ModelRepository;
import rs.ac.singidunum.fir.cartraderbackend.repository.VehicleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ModelService {
    @Autowired
    private ModelRepository modelRepository;

    public List<Model> getAllModels() {
        return modelRepository.findAll();
    }

    public Model getModelById(Long modelId) {
        return modelRepository.findById(modelId).orElseThrow(() -> new ModelNotFoundException());
    }

    public List<Model> getAllModelsByManufacturer(Manufacturer manufacturer) {
        return modelRepository.findByManufacturer(manufacturer);
    }

}
