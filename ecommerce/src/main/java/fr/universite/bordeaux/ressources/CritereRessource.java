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

import fr.universite.bordeaux.entities.Critere;
import fr.universite.bordeaux.repositories.CritereRepository;

@Path("/criteres")
public class CritereRessource {
	
	@EJB
	private CritereRepository critereRepository;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Critere> getCriteres(){
		return critereRepository.getAll();
	}
	
	@POST
	@Path("/create")
	@Consumes("application/json")
	public void addCritere(Critere critere){
		critereRepository.saveOrUpdate(critere);
	}
	
	@PUT
	@Path("/update")
	@Consumes("application/json")
	public void updateCritere(Critere critere){
		critereRepository.saveOrUpdate(critere);
	}
	
	@DELETE
	@Path("/delete/{idCritere}")
	public void deleteCritere(@PathParam("idCritere") long idCritere){
		critereRepository.delete(idCritere);
	}
}
