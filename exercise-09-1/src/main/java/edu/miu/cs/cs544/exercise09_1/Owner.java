package edu.miu.cs.cs544.exercise09_1;

import org.hibernate.annotations.FetchMode;

import java.util.List;

import javax.persistence.*;

@Entity
public class Owner {
	@Id  
    @GeneratedValue
    private int id;
    private String name;
    @OneToMany (cascade={CascadeType.PERSIST})
	// eager and join
//	@OneToMany (fetch = FetchType.EAGER, cascade={CascadeType.PERSIST})
    @JoinColumn (name="clientid")
	//sub-select
//	@org.hibernate.annotations.Fetch(
//			FetchMode.SUBSELECT
//	)
    private List<Pet> pets;
    
	public Owner() {
	}
	public Owner(String name) {
		super();
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Pet> getPets() {
		return pets;
	}
	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
    
	
    
}
