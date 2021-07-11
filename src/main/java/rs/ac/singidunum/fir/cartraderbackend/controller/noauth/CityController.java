package rs.ac.singidunum.fir.cartraderbackend.controller.noauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.singidunum.fir.cartraderbackend.entity.City;
import rs.ac.singidunum.fir.cartraderbackend.service.CityService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/public/cities")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/{cityId}")
    public City getCityById(@PathVariable Long cityId) {
        return cityService.getCityById(cityId);
    }
}
