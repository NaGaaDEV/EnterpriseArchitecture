package ea.lab.exercise_15.service;

import ea.lab.exercise_15.domain.Country;

import java.util.Collection;

public interface CountryService {
    public Collection<Country> getCountries();
    public Country getCountry(Integer id);
}
