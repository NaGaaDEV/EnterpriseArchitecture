package ea.lab.exercise_15.domain;

import lombok.Data;
import org.springframework.data.annotation.Immutable;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Immutable
public class City {
    @Id
    @Column(name = "city_id")
    private Integer id;
    @Column(name = "city")
    private String name;
    @Column(name = "last_update")
    private LocalDate lastUpdated;
}
