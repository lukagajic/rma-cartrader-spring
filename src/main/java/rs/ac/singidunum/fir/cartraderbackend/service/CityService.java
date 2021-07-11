package rs.ac.singidunum.fir.cartraderbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.fir.cartraderbackend.entity.City;
import rs.ac.singidunum.fir.cartraderbackend.exception.notfound.CityNotFoundException;
import rs.ac.singidunum.fir.cartraderbackend.repository.CityRepository;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City getCityById(Long cityId) {
        return cityRepository.findById(cityId).orElseThrow(() -> new CityNotFoundException());
    }

}
