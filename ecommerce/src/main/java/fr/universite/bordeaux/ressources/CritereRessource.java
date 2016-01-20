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

	@GET
	@Path("/byPersonne")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Critere> getCriteres(@QueryParam("idPersonne") long idPersonne){
		return critereRepository.getByPersonne(idPersonne);
	}	
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Critere getCritere(@PathParam("id") long idCritere){
		return critereRepository.getId(idCritere);
	}	
	
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public void addCritere(Critere critere){
		critereRepository.saveOrUpdate(critere);
	}
	
	@PUT
	@Path("/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	public void updateCritere(Critere critere){
		critereRepository.saveOrUpdate(critere);
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteCritere(@PathParam("id") long idCritere){
		critereRepository.delete(idCritere);
	}
}
