package demoRest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class alienRepo {
	
//	List<Alien> aliens;
	
	Connection con = null;
	
	public alienRepo() {
		
		String url = "";
		String username = "root";
		String password = "0000";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}

//		aliens = new ArrayList<>();
//		
//		Alien a1 = new Alien();
//		a1.setId(101);
//		a1.setName("Arun");
//		a1.setPoints(60);
//		
//		Alien a2 = new Alien();
//		a2.setId(102);
//		a2.setName("Varun");
//		a2.setPoints(50);
//		
//		aliens.add(a1);
//		aliens.add(a2);
	}
	
	public List<Alien> getAliens(){
		List<Alien> aliens = new ArrayList<>();
		String sql = "select * from alien";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Alien a = new Alien();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				
				aliens.add(a);
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return aliens;
	}
	
	public Alien getAlien(int id) {
		
		String sql = "select * from alien where id = "+id;
		Alien a = new Alien();                                    // creating object
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				
				aliens.add(a);
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return a;
		
//		for(Alien a : aliens) {
//			if(a.getId() == id) 
//				return a;
//		}
//		
//		return null;
	}
	
	public void create(Alien a1) {
		String sql = "insert into alien values (?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, a1.getId());
			st.setString(2,a1.getName());
			st.setInt(3, a1.getPoints());
			st.executeUpdate();
			}
		catch(Exception e) {
			System.out.println(e);
		}
		
//		aliens.add(a1);
	}
	
	public void update(Alien a1) {
		String sql = "update alien set name=?, points=?, where id = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1,a1.getName());
			st.setInt(2, a1.getPoints());
			st.setInt(3, a1.getId());
			st.executeUpdate();
			}
		catch(Exception e) {
			System.out.println(e);
		}
		
//		aliens.add(a1);
	}
	
	public void delete(int id) {
		
		String sql = "delete from alien where id = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, id);
			st.executeUpdate();
			}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
