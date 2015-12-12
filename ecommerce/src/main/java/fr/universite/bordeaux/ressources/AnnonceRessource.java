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

import fr.universite.bordeaux.entities.Annonce;
import fr.universite.bordeaux.repositories.AnnonceRepository;

@Path("/annonces")
public class AnnonceRessource {

	@EJB
	private AnnonceRepository annonceRepository;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Annonce> getAnnonces(){
		return annonceRepository.getALL();
	}
	
	@POST
	@Path("/create")
	@Consumes("application/json")
	public void addAnnonce(Annonce annonce){
		annonceRepository.save(annonce);
	}
	
	@PUT
	@Path("/update")
	@Consumes("application/json")
	public void updateAnnonce(Annonce annonce){
		annonceRepository.update(annonce);
	}
	
	@DELETE
	@Path("/delete/{id}")
	public void delete(@PathParam("id") long id){
		annonceRepository.delete(id);
	}
}
