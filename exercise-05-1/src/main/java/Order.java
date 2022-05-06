import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity()
@Table(name = "Order_List")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private LocalDate date;

    @ManyToOne
    Customer customer;

    public Order() {
        this.date = LocalDate.now();
    }
}
