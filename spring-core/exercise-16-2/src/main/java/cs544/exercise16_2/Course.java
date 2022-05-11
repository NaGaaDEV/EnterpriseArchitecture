package cs544.exercise16_2;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Course {
	private long coursenumber;
	private String name;
	private String grade;

	public Course(long coursenumber, String name, String grade) {
		this.coursenumber = coursenumber;
		this.name = name;
		this.grade = grade;
	}
}
