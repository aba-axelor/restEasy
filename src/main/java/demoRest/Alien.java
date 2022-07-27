package demoRest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement                                                 // we want Alien as the root element
@Entity
public class Alien {                       
	
	@Id
	@GeneratedValue(generator = "alien_sequence", strategy = GenerationType.AUTO)
	private int id; 
	private String name; 
	private int points; 
	
	public Alien() {}

	public Alien( String name, int points) {
		super();
		this.name = name;
		this.points = points;
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
	
                         
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
}
