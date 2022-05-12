package ea.lab.exercise_16.service;

import ea.lab.exercise_16.domain.City;

import java.util.Collection;

public interface CityService {
    Collection<City> getCities();
    City getCity(Integer id);
}
