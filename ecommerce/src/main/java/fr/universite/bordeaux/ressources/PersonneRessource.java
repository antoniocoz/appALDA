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
import javax.ws.rs.core.MediaType;

import fr.universite.bordeaux.entities.Personne;
import fr.universite.bordeaux.repositories.PersonneRepository;

@Path("/personnes")
public class PersonneRessource {

	@EJB
	private PersonneRepository personneRepository;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Personne> getPersonnes(){
		List<Personne> personnes=personneRepository.getAll();
		return personnes;
	}
	
	@GET
	@Path("/{idPersonne}")
	@Produces({MediaType.APPLICATION_JSON})
	public Personne getPersonne(@PathParam("idPersonne") long idPersonne){
		Personne personne=personneRepository.getId(idPersonne);
		return personne;
	}
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addPersonne(Personne personne){
		personneRepository.saveOrUpdate(personne);
	}
	
	@PUT
	@Path("/update")
	@Consumes("application/json")
	public void updatePersonne(Personne personne){
		personneRepository.saveOrUpdate(personne);
	}
	
	@DELETE
	@Path("/delete/{idPersonne}")
	public void deletePersonne(@PathParam("idPersonne") long idPersonne){
		personneRepository.delete(idPersonne);
	}
}
