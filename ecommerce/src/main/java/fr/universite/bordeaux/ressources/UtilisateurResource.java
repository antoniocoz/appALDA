package fr.universite.bordeaux.ressources;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.universite.bordeaux.entities.Utilisateur;
import fr.universite.bordeaux.repositories.UtilisateurRepository;

@Path("/utilisateurs")
public class UtilisateurResource {
	
	@EJB
	UtilisateurRepository utilisateurRepository;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Utilisateur> getALLUtilisateurs(){
		return utilisateurRepository.getALL();
	}

}
