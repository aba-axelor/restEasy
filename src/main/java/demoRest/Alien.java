package demoRest;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement                                                 // we want Alien as the root element
@Entity
public class Alien {                       
	
	@Id
	private int id;                                       //ID
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	private String name;                                 //NAME
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	private int points;                                 //POINTS
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	
	@Override
	public String toString() {
		return "Alien [id=" + id + ", name=" + name + ", points=" + points + "]";
	}
}
