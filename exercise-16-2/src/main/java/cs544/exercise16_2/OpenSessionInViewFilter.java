package cs544.exercise16_2;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Servlet Filter implementation class OpenSessionInViewFilter
 */
public class OpenSessionInViewFilter implements Filter {
	SessionFactory sessionFactory = null;

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO implement actual session in view filter code
		Transaction tx = null;
		try {
			tx = sessionFactory.getCurrentSession().beginTransaction();
			// pass the request along the filter chain
			System.out.println("receiving request");
			chain.doFilter(request, response);
			System.out.println("sending response");			
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	public void destroy() {
	}

	public void init(FilterConfig arg0) throws ServletException {
		sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Student student = new Student(11334, "FrankDB", "BrownDB");
		Course course1 = new Course(1101, "Java", "A");
		Course course2 = new Course(1102, "Math", "B-");
		student.addCourse(course1);
		student.addCourse(course2);
		session.persist(student);
		tx.commit();
	}
}
