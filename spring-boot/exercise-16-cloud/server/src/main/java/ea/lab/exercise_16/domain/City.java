package ea.lab.exercise_16.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class City {
    @Id
    @Column(name = "city_id")
    private Integer id;
    @Column(name = "city")
    private String name;
    @Column(name = "last_update")
    private LocalDate lastUpdated;
}
