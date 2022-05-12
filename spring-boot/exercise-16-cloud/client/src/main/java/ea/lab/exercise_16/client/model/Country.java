package ea.lab.exercise_16.client.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Data
public class Country {
    private Integer id;
    private String name;
    private LocalDate lastUpdated;
    private Collection<City> cities = new ArrayList<>();
}
