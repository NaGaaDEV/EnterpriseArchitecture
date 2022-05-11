package cs544.exercise17_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
	@Autowired
	private StudentDAO studentdao;

	public StudentService() {
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void init() {
		this.studentdao.init();
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)

	public Student getStudent(long studentid) {
		return studentdao.load(studentid);
	}
}
