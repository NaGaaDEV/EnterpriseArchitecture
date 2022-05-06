package cs544.exercise16_2;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.Data;

@Data
@Entity
public class Student {
	private long studentid;
	private String firstname;
	private String lastname;
	@OneToMany
	@JoinColumn(name = "student_id")
	@Cascade(CascadeType.ALL)
	private Collection<Course> courselist = new ArrayList<Course>();

	public Student() {
		this.courselist = new ArrayList<Course>();
	}
	
	public Student(long studentid, String firstname, String lastname) {
		this.studentid = studentid;
		this.firstname = firstname;
		this.lastname = lastname;
		courselist = new ArrayList<Course>();
	}
	
	public void addCourse(Course course) {
		this.courselist.add(course);
	}

}
