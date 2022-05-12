package ea.lab.exercise_16.client.service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import ea.lab.exercise_16.client.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CountryServiceClientImpl implements CountryServiceClient {
    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private DiscoveryClient discoveryClient;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @Value("${spring-boot-server.name}")
    private String serverName;

    @Value("${server-service.username}")
    private String username;

    @Value("${server-service.password}")
    private String password;

    @Override
    public List<Country> getCountries() {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitBreaker");
        return circuitBreaker.run(
                () -> Arrays.asList(restTemplate.exchange(getBaseServiceUrl() + "/countries", HttpMethod.GET, createHttpEntity(), Country[].class).getBody()),
                throwable -> getCountriesFallBack()
        );
    }

    @Override
    public Country getCountry(Integer id) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitBreaker");
        return circuitBreaker.run(
                () -> restTemplate.exchange(getBaseServiceUrl() + "/countries/" + id, HttpMethod.GET, createHttpEntity(), Country.class).getBody(),
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
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka(serverName, false);
        return instanceInfo.getHomePageUrl();
//        List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serverName);
//        serviceInstances.forEach(System.out::println);
//        return serviceInstances.get(0).getUri().toString();
    }

    private HttpEntity<Object> createHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setBasicAuth(username, password);

        return new HttpEntity<>(headers);
    }
}
