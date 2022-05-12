package ea.lab.exercise_16.client.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class City {
    private Integer id;
    private String name;
    private LocalDate lastUpdated;
}
