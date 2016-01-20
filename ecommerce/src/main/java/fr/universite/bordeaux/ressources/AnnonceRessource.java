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
import fr.universite.bordeaux.entities.Email;
import fr.universite.bordeaux.repositories.AnnonceRepository;
import fr.universite.bordeaux.service.SendEmail;

@Path("/annonces")
public class AnnonceRessource {

	@EJB
	private AnnonceRepository annonceRepository;
	
	private SendEmail sendEmail=new SendEmail();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Annonce> getAnnonces(){
		return annonceRepository.getALL();
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Annonce getAnnonce(@PathParam("id") long idCritere){
		return annonceRepository.getId(idCritere);
	}
		
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public void addAnnonce(Annonce annonce){
		annonceRepository.saveOrUpdate(annonce);
	}
	
	@PUT
	@Path("/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	public void updateAnnonce(Annonce annonce){
		annonceRepository.saveOrUpdate(annonce);
	}
	
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") long id){
		annonceRepository.delete(id);
	}
	
	@POST
	@Path("/envoyerEmail")
	@Consumes({MediaType.APPLICATION_JSON})
	public void addAnnonce(Email email){
		sendEmail.envoyerEmail(email.getFromEmail(), email.getToEmail(), email.getTitle(), email.getMessage());
	}
}
