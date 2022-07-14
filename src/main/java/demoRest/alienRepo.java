package demoRest;

import java.util.ArrayList;
import java.util.List;

public class alienRepo {
	
	List<Alien> aliens;
	
	public alienRepo() {
		
		aliens = new ArrayList<>();
		
		Alien a1 = new Alien();
		a1.setId(101);
		a1.setName("Arun");
		a1.setPoints(60);
		
		Alien a2 = new Alien();
		a2.setId(102);
		a2.setName("Varun");
		a2.setPoints(50);
		
		aliens.add(a1);
		aliens.add(a2);
	}
	
	public List<Alien> getAliens(){
		
		return aliens;
	}
	
	public Alien getAlien(int id) {
		
		for(Alien a : aliens) {
			if(a.getId() == id) 
				return a;
		}
		
		return null;
	}
	
	public void create(Alien a1) {
		aliens.add(a1);
	}

}
