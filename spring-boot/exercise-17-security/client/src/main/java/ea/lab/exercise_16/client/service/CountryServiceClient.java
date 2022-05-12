package ea.lab.exercise_16.client.service;

import ea.lab.exercise_16.client.model.Country;

import java.util.Collection;

public interface CountryServiceClient {
    Collection<Country> getCountries();
    Country getCountry(Integer id);
//    Country replaceCountry(Country country);
}
