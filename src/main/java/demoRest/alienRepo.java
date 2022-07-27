package demoRest;

import java.util.List;

public interface alienRepo {

	public void createAlien(Alien a);

	public List<Alien> getAlien();

	public void updateAlien(int id, String name, int points);

	public void deleteAlien(int id);

	public Alien getAlienById(int id);

	public List<Alien> getAlienByName(String name);
	
}
	
	
	














//	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
//	EntityManager em = emf.createEntityManager();
//	
//	List<Alien> aliens;
//
//	public alienRepo() {
//
////		aliens = new ArrayList<>();
////		
////		Alien a1 = new Alien();
////		a1.setId(101);
////		a1.setName("Arun");
////		a1.setPoints(60);
////		
////		Alien a2 = new Alien();
////		a2.setId(102);
////		a2.setName("Varun");
////		a2.setPoints(50);
////		
////		aliens.add(a1);
////		aliens.add(a2);
//	}
//	
//	public List<Alien> getAliens(){
//		
//		aliens = (List<Alien>)em.createQuery("from Alien").getResultList();
//		return aliens;
//			
//	//		List<Alien> aliens = new ArrayList<>();
//	//		String sql = "select * from alien";
//	//		try {
//	//			Statement st = con.createStatement();
//	//			ResultSet rs = st.executeQuery(sql);
//	//			while(rs.next()) {
//	//				Alien a = new Alien();
//	//				a.setId(rs.getInt(1));
//	//				a.setName(rs.getString(2));
//	//				a.setPoints(rs.getInt(3));
//	//				
//	//				aliens.add(a);
//	//			}
//	//			
//	//		}
//	//		catch(Exception e) {
//	//			System.out.println(e);
//	//		}
//
//	}
//	
//	public Alien getAlien(int id) {
//		
//		Alien a=em.find(Alien.class, id);
//		if(a!=null)
//		{
//			return a;
//		}
//		else
//		{
//			return new Alien();
//		}
//		
////		String sql = "select * from alien where id = "+id;
////		Alien a = new Alien();                                    // creating object
////		try {
////			Statement st = con.createStatement();
////			ResultSet rs = st.executeQuery(sql);
////			if(rs.next()) {
////				
////				a.setId(rs.getInt(1));
////				a.setName(rs.getString(2));
////				a.setPoints(rs.getInt(3));
////				
////				aliens.add(a);
////			}
////			
////		}
////		catch(Exception e) {
////			System.out.println(e);
////		}
////		
////		return a;
////		
////		for(Alien a : aliens) {
////			if(a.getId() == id) 
////				return a;
////		}
////		
////		return null;
//	}
//	
//	
//	public void create(Alien a1) {
//		em.getTransaction().begin();
//		em.persist(a1);
//		em.getTransaction().commit();
//		
////		String sql = "insert into alien values (?,?,?)";
////		try {
////			PreparedStatement st = con.prepareStatement(sql);
////			st.setInt(1, a1.getId());
////			st.setString(2,a1.getName());
////			st.setInt(3, a1.getPoints());
////			st.executeUpdate();
////			}
////		catch(Exception e) {
////			System.out.println(e);
////		}
////		aliens.add(a1);
//	}
//	
//	
//	public void update(Alien a1) {
//		
//		Alien a=em.find(Alien.class, a1.getId());
//		a.setName(a1.getName());
//		em.getTransaction().begin();
//		em.persist(a);
//		em.getTransaction().commit();
//		
////		String sql = "update alien set name=?, points=?, where id = ?";
////		try {
////			PreparedStatement st = con.prepareStatement(sql);
////			
////			st.setString(1,a1.getName());
////			st.setInt(2, a1.getPoints());
////			st.setInt(3, a1.getId());
////			st.executeUpdate();
////			}
////		catch(Exception e) {
////			System.out.println(e);
////		}
////		aliens.add(a1);
//	}
//	
//	
//	public void delete(int id) {
//		
//		Alien a = em.find(Alien.class, id);
//		em.getTransaction().begin();
//		em.remove(a);
//		em.getTransaction().commit();
//		
////		String sql = "delete from alien where id = ?";
////		try {
////			PreparedStatement st = con.prepareStatement(sql);
////			
////			st.setInt(1, id);
////			st.executeUpdate();
////			}
////		catch(Exception e) {
////			System.out.println(e);
////		}
//		
//	}
//	
//	public void listAliens()
//	{
//		for(Alien a: aliens)
//		{
//			System.out.println(a);
//		}
//	}
	
//}
