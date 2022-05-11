package ea.lab.exercise_15.Controller;

import ea.lab.exercise_15.domain.Country;
import ea.lab.exercise_15.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
