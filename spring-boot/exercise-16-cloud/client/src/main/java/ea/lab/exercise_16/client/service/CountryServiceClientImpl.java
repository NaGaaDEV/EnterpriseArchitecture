package ea.lab.exercise_16.client.service;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import ea.lab.exercise_16.client.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CountryServiceClientImpl implements CountryServiceClient {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${spring-boot-server.name}")
    private String serverName;

    @Override
    public List<Country> getCountries() {
        String url = getBaseServiceUrl() + "/countries";
        return Arrays.asList(restTemplate.getForObject(url, Country[].class));
    }

    @Override
    public Country getCountry(Integer id) {
        String url = getBaseServiceUrl() + "/countries/" + id;
        return restTemplate.getForObject(url, Country.class);
    }

    private String getBaseServiceUrl() {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serverName);
        serviceInstances.forEach(System.out::println);
        return serviceInstances.get(0).getUri().toString();
    }
}
