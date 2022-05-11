package ea.lab.exercise_15.service;

import ea.lab.exercise_15.domain.Country;
import ea.lab.exercise_15.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository repository;

    @Override
    public Collection<Country> getCountries() {
        return repository.findAll();
    }

    @Override
    public Country getCountry(Integer id) {
        return repository.findById(id).get();
    }
}
