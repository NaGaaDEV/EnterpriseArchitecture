package ea.lab.exercise_16.service;

import ea.lab.exercise_16.domain.Country;

import java.util.Collection;

public interface CountryService {
    Collection<Country> getCountries();
    Country getCountry(Integer id);
    Country replaceCountry(Country country);
}
