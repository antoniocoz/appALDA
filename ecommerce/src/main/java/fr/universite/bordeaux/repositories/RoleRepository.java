package fr.universite.bordeaux.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.universite.bordeaux.entities.Role;

@Stateless
public class RoleRepository {
	private static final String JPQL_SELECT = "SELECT r FROM Role r";
	
	@PersistenceContext(unitName = "ecommercePersistenceUnit")
	private EntityManager entityManager;
	
	public void saveOrUpdate(Role role){
		entityManager.merge(role);
	}
	
	@SuppressWarnings("unchecked")
	public List<Role> getAll(){
        Query query=entityManager.createQuery(JPQL_SELECT);
        List<Role> roles=(List<Role>)query.getResultList();
        return roles;		
	}
	
	public Role getId(Long idRole){
		return entityManager.find(Role.class, idRole);
	}
	
	public void delete(long idRole){
		Role role = getId(idRole);
		entityManager.remove(role);
	}
}	
