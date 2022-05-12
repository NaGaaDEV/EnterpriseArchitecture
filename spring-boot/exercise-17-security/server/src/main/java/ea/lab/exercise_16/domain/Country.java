package ea.lab.exercise_16.domain;

import lombok.Data;
import org.springframework.data.annotation.Immutable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
public class Country {
    @Id
    @Column(name = "country_id")
    private Integer id;
    @Column(name = "country")
    private String name;
    @Column(name = "last_update")
    private LocalDate lastUpdated;
    @OneToMany
    @JoinColumn(name = "country_id")
    private Collection<City> cities = new ArrayList<>();
}
