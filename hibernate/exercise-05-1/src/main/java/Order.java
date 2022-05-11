import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CustomerOrder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String orderId;
    private LocalDate date;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id")
    Customer customer;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "orderLine_id")
    List<OrderLine> orderLines = new ArrayList<>();

    public Order(LocalDate date, List<OrderLine> orderLines) {
        this.date = date;
        this.orderLines = orderLines;
    }
}
