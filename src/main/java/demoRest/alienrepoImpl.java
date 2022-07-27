package demoRest;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;


public class alienrepoImpl implements alienRepo{
	
	@Inject
	Provider<EntityManager> emp;
	
	@Transactional
	@Override
	public void createAlien(Alien a) {
		EntityManager em = emp.get();
		em.persist(a);
	}


	
	@Transactional
	@Override
	public List<Alien> getAlien() {
		EntityManager em = emp.get();
		List<Alien> results = em.createQuery("FROM Alien ORDER BY id ").getResultList();
		return results;
	}

	@Transactional
	@Override
	public void updateAlien(int id, String name, int points) {
		EntityManager em = emp.get();
		Alien alien = em.find(Alien.class, id);
		alien.setName(name);
		alien.setPoints(points);
		em.persist(alien);
	}

	@Transactional
	@Override
	public void deleteAlien(int id) {
		EntityManager em = emp.get();
		Alien alien = em.find(Alien.class, id);
		em.remove(alien);

	}

	@Transactional
	@Override
	public Alien getAlienById(int id) {
		EntityManager em = emp.get();
		Alien alien = em.find(Alien.class, id);
		return alien;
	}

	@Transactional
	@Override
	public List<Alien> getAlienByName(String name) {
		EntityManager em = emp.get();
		List<Alien> results = em.createQuery("FROM Contact WHERE name='" + name + "'").getResultList();
		return results;
	}

}
