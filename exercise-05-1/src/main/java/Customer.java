import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    Collection<Order> orders;

    public Customer(String fn, String ln) {
        this.firstname = fn;
        this.lastname = ln;
    }
}
