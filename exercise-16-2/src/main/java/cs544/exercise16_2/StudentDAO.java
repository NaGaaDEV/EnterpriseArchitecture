package cs544.exercise16_2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class StudentDAO {

	private SessionFactory sf = HibernateUtils.getSessionFactory();

	public StudentDAO() { }

	public Student load(long studentid) {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Student student = session.createQuery("from Student where id = :id",Student.class).setParameter("id", studentid).uniqueResult();	
		tx.commit();
		
		return student;
	}
}
