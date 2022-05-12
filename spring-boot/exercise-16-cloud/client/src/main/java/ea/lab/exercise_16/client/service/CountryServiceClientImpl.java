package ea.lab.exercise_16.client.service;

import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import ea.lab.exercise_16.client.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CountryServiceClientImpl implements CountryServiceClient {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @Value("${spring-boot-server.name}")
    private String serverName;

    @Override
    public List<Country> getCountries() {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitBreaker");
        return circuitBreaker.run(
                () -> Arrays.asList(restTemplate.getForObject(getBaseServiceUrl() + "/countries", Country[].class)),
                throwable -> getCountriesFallBack()
        );
    }

    @Override
    public Country getCountry(Integer id) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitBreaker");
        return circuitBreaker.run(
                () -> restTemplate.getForObject(getBaseServiceUrl() + "/countries/" + id, Country.class),
                throwable -> getCountryFallBack()
        );
    }

    private List<Country> getCountriesFallBack() {
        System.out.println("Inside getCountries fallback!");
        return new ArrayList<>();
    }

    private Country getCountryFallBack() {
        System.out.println("Inside getCountry fallback!");
        return null;
    }

    private String getBaseServiceUrl() {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serverName);
        serviceInstances.forEach(System.out::println);
        return serviceInstances.get(0).getUri().toString();
    }
}
