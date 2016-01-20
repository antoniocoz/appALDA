package fr.universite.bordeaux.ressources;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import fr.universite.bordeaux.entities.Email;
import fr.universite.bordeaux.repositories.EmailRepository;

@Path("/emails")
public class EmailRessource {

	@EJB
	private EmailRepository emailRepository;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Email> getCriteres(){
		return emailRepository.getAll();
	}

	@GET
	@Path("/byEmail")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Email> getCriteres(@QueryParam("email") String email){
		return emailRepository.getByEmail(email);
	}	
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Email getCritere(@PathParam("id") long idCritere){
		return emailRepository.getId(idCritere);
	}	
	
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public void addCritere(Email email){
		emailRepository.saveOrUpdate(email);
	}
	
	@PUT
	@Path("/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	public void updateCritere(Email email){
		emailRepository.saveOrUpdate(email);
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteCritere(@PathParam("id") long idEmail){
		emailRepository.delete(idEmail);
	}
}
