package ea.lab.exercise_16.client.service;

import ea.lab.exercise_16.client.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CountryServiceClientImpl implements CountryServiceClient {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${base-service-url}")
    private String baseUrl;

    @Override
    public List<Country> getCountries() {
        String url = baseUrl + "/countries";
        return Arrays.asList(restTemplate.getForObject(url, Country[].class));
    }

    @Override
    public Country getCountry(Integer id) {
        String url = baseUrl + "/countries/" + id;
        return restTemplate.getForObject(url, Country.class);
    }

//    @Override
//    public Country replaceCountry(Country country) {
//        return repository.save(country);
//    }
}
