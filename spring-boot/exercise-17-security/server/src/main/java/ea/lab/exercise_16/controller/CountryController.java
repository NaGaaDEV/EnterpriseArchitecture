package ea.lab.exercise_16.controller;

import ea.lab.exercise_16.domain.Country;
import ea.lab.exercise_16.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class CountryController {

    @Autowired
    private CountryService service;

    @GetMapping("/countries")
    public Collection<Country> getCountries() {
        return service.getCountries();
    }

    @GetMapping("/countries/{id}")
    public Country getCountry(@PathVariable("id") Integer id) {
        return service.getCountry(id);
    }

    @PutMapping("/countries/{id}")
    public Country replaceCountry(@PathVariable("id") Integer id, @RequestBody Country country) {
        return service.replaceCountry(country);
    }
}
