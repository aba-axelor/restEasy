package demoRest;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import org.jboss.resteasy.plugins.providers.html.View;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import demoRest.Alien;
import com.google.inject.Inject;


@Path("/")                                                    // whenever i call for alien i call for this resource
public class alienResource {
	
	@Inject
	alienRepo alienrepo;
	
	@GET
	public View getAll(@Context HttpServletRequest req, @Context HttpServletResponse res) {
		List<Alien> list = alienrepo.getAlien();
		return new View("/index.jsp", list, "aliens");
	}
	
	@POST
	@Path("update/{cid}")
	public void update(@FormParam("cid") String id, @FormParam("name") String name,
			@FormParam("points") String points, @Context HttpServletRequest req,
			@Context HttpServletResponse res) {
		alienrepo.updateAlien(Integer.parseInt(id), name, Integer.parseInt(points));
		try {
			res.sendRedirect("/restEasy/");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@POST
	@Path("insert")
	public void insert(@FormParam("name") String name, @FormParam("points") String points, @Context HttpServletRequest req, @Context HttpServletResponse res) {
		alienrepo.createAlien(new Alien(name, Integer.parseInt(points)));
		try {
			res.sendRedirect("/restEasy/");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@GET
	@Produces("application/json")
	@Path("updateAlien/{gid}")
	public Response getById(@PathParam("gid") Integer id, @Context HttpServletRequest req,
			@Context HttpServletResponse res) {
		Alien alien = alienrepo.getAlienById(id);
		req.setAttribute("id", alien.getId());
		req.setAttribute("name", alien.getName());
        req.setAttribute("points", alien.getPoints());
		try {
			req.getRequestDispatcher("/update.jsp").forward(req, res);
			return Response.status(200).entity(res).build();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GET
	@Path("delete/{id}")
	public Response delete(@PathParam("id") Integer id, @Context HttpServletRequest req,
			@Context HttpServletResponse res) {
		alienrepo.deleteAlien(id);
		try {
			res.sendRedirect("/restEazy/");
			return Response.status(200).entity(res).build();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GET
	@Path("search")
	public Response search(@QueryParam("name") String name, @Context HttpServletRequest req,
			@Context HttpServletResponse res) {
		req.setAttribute("aliens", alienrepo.getAlienByName(name));
		try {
			req.getRequestDispatcher("/search.jsp").forward(req, res);
			return Response.status(200).entity(res).build();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GET
	@Produces("application/json")
	@Path("getData")
	public List<Alien> getData() {
		List<Alien> list = alienrepo.getAlien();
		return list;
	}
	
	@PUT
	@Produces("application/json")
	@Path("putData")
	public void insertData(Alien alien) {
		alienrepo.createAlien(alien);
	}
	
	@DELETE
	@Path("deleteData/{id}")
	public Response deleteData(@PathParam("id") Integer id, @Context HttpServletRequest req,
			@Context HttpServletResponse res) {
		alienrepo.deleteAlien(id);
		req.setAttribute("aliens", alienrepo.getAlien());
		try {
			req.getRequestDispatcher("/index.jsp").forward(req, res);
			return Response.status(200).entity(res).build();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}























//	alienRepo repo = new alienRepo();
//	
//	@GET
//	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})                           // content negotiation
//	public List<Alien> getAliens() {
//		return repo.getAliens();
//	}
//	
//	
//	@GET
//	@Path("alien/{id}")                                                                      // {} is just a place holder here
//	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})                      // content negotiation
//	public Alien getAlien(@PathParam("id") int id) {                                       // PathParam will assign value to id
//		return repo.getAlien(id);
//	}
//	
//	
//    @POST                                                                             // for post we are using postman here
//	@Path("alien")
//	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})               // taking both XML and JSON 
//	public Alien createAlien(Alien a1) {
//		System.out.println(a1);
//		repo.create(a1);
//		return a1; 
//	}
//	
//    
//    @PUT
//	@Path("alien")
//	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
//	public Alien updateAlien(Alien a1)
//	{
//		
//		System.out.println(a1);
//		if(repo.getAlien(a1.getId()).getId()==0)
//		{
//			System.out.println("Creating a new Alien");
//			repo.create(a1);
//		}
//		else
//		{
//			System.out.println("Updating the Alien");
//			repo.update(a1);
//		}
//		
//		return a1;
//	}
//	
//	
//	@DELETE                                                 
//	@Path("alien/{id}")
//	public Alien killAlien(@PathParam("id") int id) {
//		Alien a = repo.getAlien(id);
//		if(a.getId() == 0) {
//			System.out.println("Alien not found");
//		}
//		else
//		{
//			repo.delete(id);
//		}
//		return a; 
//	}
//	
//	@GET
//	@Path("s")
//	public void listAliens()
//	{
//		repo.listAliens();
//	}



