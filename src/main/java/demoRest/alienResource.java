package demoRest;


import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("aliens")                         // whenever i call for alien i call for this resource
public class alienResource {
	
	alienRepo repo = new alienRepo();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})                           // content negotiation
	public List<Alien> getAliens() {
		return repo.getAliens();
	}
	
	
	@GET
	@Path("alien/{id}")                                                                      // {} is just a place holder here
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})                      // content negotiation
	public Alien getAlien(@PathParam("id") int id) {                                       // PathParam will assign value to id
		return repo.getAlien(id);
	}
	
	
    @POST                                                                             // for post we are using postman here
	@Path("alien")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})               // taking both XML and JSON 
	public Alien createAlien(Alien a1) {
		System.out.println(a1);
		repo.create(a1);
		return a1; 
	}
	
    
    @PUT
	@Path("alien")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Alien updateAlien(Alien a1)
	{
		
		System.out.println(a1);
		if(repo.getAlien(a1.getId()).getId()==0)
		{
			System.out.println("Creating a new Alien");
			repo.create(a1);
		}
		else
		{
			System.out.println("Updating the Alien");
			repo.update(a1);
		}
		
		return a1;
	}
	
	
	@DELETE                                                 
	@Path("alien/{id}")
	public Alien killAlien(@PathParam("id") int id) {
		Alien a = repo.getAlien(id);
		if(a.getId() == 0) {
			System.out.println("Alien not found");
		}
		else
		{
			repo.delete(id);
		}
		return a; 
	}
	
	@GET
	@Path("s")
	public void listAliens()
	{
		repo.listAliens();
	}
}


