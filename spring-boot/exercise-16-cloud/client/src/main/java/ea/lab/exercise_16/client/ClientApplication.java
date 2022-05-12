package ea.lab.exercise_16.client;

import ea.lab.exercise_16.client.model.Country;
import ea.lab.exercise_16.client.service.CountryServiceClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ClientApplication.class, args);

        CountryServiceClient client = context.getBean(CountryServiceClient.class);
        Country country = client.getCountry(1);
        System.out.println("=== One country ===");
        System.out.println(country);
        Collection<Country> countries = client.getCountries();
        System.out.println("=== All countries ===");
        countries.forEach(System.out::println);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
