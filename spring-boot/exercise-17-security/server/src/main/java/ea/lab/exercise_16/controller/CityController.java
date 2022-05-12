package ea.lab.exercise_16.controller;

import ea.lab.exercise_16.domain.City;
import ea.lab.exercise_16.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CityController {
    @Autowired
    private CityService service;

    @GetMapping("/cities")
    public Collection<City> getCities() {
        return service.getCities();
    }

    @GetMapping("/cities/{id}")
    public City getCity(@PathVariable("id") Integer id) {
        return service.getCity(id);
    }
}
