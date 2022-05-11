package ea.lab.exercise_15.service;

import ea.lab.exercise_15.domain.City;

import java.util.Collection;

public interface CityService {
    public Collection<City> getCities();
    public City getCity(Integer id);
}
