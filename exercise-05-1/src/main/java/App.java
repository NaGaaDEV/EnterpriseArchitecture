import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.Arrays;

public class App {
    private static final SessionFactory sf;
    static {
        sf = HibernateUtils.getSessionFactory(Arrays.asList(Customer.class, Order.class, OrderLine.class, Product.class));
    }

    public static void main(String[] args) {
        Session session = null;
        Transaction tx = null;

//        Product product1 = new Product("Apple MacBook Air", "M1, 512Gb, 16GB RAM");
//        Product product2 = new Product("HP Legion 7i", "i9, 512Gb, 16GB RAM");
//
//        OrderLine orderLine1 = new OrderLine();
//        orderLine1.setProduct(product1);
//        orderLine1.setQuantity(1);
//        OrderLine orderLine2 = new OrderLine();
//        orderLine2.setProduct(product2);
//        orderLine2.setQuantity(1);
//        session.persist(orderLine2);
//        OrderLine orderLine3 = new OrderLine();
//        orderLine3.setProduct(product2);
//        orderLine3.setQuantity(3);
//
//        Order order1 = new Order("1-100", LocalDate.now().minusDays(1), Arrays.asList(orderLine1, orderLine2));
//        Order order2 = new Order("1-200", LocalDate.now().minusDays(2), Arrays.asList(orderLine3));
//
//        Customer customer1 = new Customer("Joe", "Gato", Arrays.asList(order1, order2));
//        session.persist(customer1);

        tx.commit();

        try {
            session = sf.openSession();
            tx = session.beginTransaction();
//            session.persist(order1);
//            session.persist(order2);
//            session.persist(customer);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
