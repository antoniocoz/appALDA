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

import fr.universite.bordeaux.entities.Role;
import fr.universite.bordeaux.repositories.RoleRepository;


@Path("/roles")
public class RoleRessource {
	
	@EJB
	private RoleRepository roleRepository;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Role> getPersonnes(){
		return roleRepository.getAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Role getPersonne(@PathParam("id") long idRole){
		return roleRepository.getId(idRole);
	}
	
	@POST
	@Consumes("application/json")
	public void addPersonne(Role role){
		roleRepository.saveOrUpdate(role);
	}
	
	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	public void updatePersonne(Role role){
		roleRepository.saveOrUpdate(role);
	}
	
	@DELETE
	@Path("/{idRole}")
	public void deleteRole(@PathParam("idRole") long idRole){
		roleRepository.delete(idRole);
	}
}
