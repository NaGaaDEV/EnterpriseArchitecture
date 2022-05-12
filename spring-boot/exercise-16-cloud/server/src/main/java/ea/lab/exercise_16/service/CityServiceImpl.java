package ea.lab.exercise_16.service;

import ea.lab.exercise_16.domain.City;
import ea.lab.exercise_16.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class CityServiceImpl implements CityService{
    @Autowired
    CityRepository repository;

    @Override
    public Collection<City> getCities() {
        return repository.findAll();
    }

    @Override
    public City getCity(Integer id) {
        return repository.findById(id).get();
    }
}
