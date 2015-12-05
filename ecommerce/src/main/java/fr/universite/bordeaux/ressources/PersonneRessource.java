package fr.universite.bordeaux.ressources;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
		return personneRepository.getAll();
	}
}
