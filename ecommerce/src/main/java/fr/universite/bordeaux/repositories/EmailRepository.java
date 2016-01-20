package fr.universite.bordeaux.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.universite.bordeaux.entities.Email;

@Stateless
public class EmailRepository {

	private static final String JPQL_SELECT = "SELECT e FROM Email e";
	private static final String JPQL_SELECT_PAR_PERSONNE = "SELECT e FROM Email e WHERE e.fromEmail=:fromEmail";
	private static final String PARAM_EMAIL = "fromEmail";
	@PersistenceContext(unitName = "ecommercePersistenceUnit")
	private EntityManager entityManager;
	
	public void saveOrUpdate(Email email){
		entityManager.merge(email);
	}
	
	@SuppressWarnings("unchecked")
	public List<Email> getAll(){
        Query query=entityManager.createQuery(JPQL_SELECT);
        List<Email> emails=(List<Email>)query.getResultList();
        return emails;		
	}
	
	public List<Email> getByEmail(String email){
		Query query=entityManager.createQuery(JPQL_SELECT_PAR_PERSONNE);
		query.setParameter(PARAM_EMAIL, email);
		List<Email> emails = (List<Email>)query.getResultList();
		return emails;
	}
	
	public Email getId(long id){
		return entityManager.find(Email.class, id);
	}
	
	public void delete(long id){
		Email email = getId(id);
		entityManager.remove(email);
	}
	
	
}
