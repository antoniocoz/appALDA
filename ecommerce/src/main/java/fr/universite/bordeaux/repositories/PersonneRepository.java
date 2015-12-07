package fr.universite.bordeaux.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.universite.bordeaux.entities.Personne;


@Stateless
public class PersonneRepository {
	
	private static final String JPQL_SELECT = "SELECT p FROM Personne p";
	private static final String JPQL_SELECT_PAR_EMAIL = "SELECT p FROM Personne p WHERE p.mail=:mail";
	private static final String JPQL_SELECT_PAR_ID = "SELECT p FROM Personne p WHERE p.id=:id";
	private static final String PARAM_EMAIL = "mail";
	private static final String PARAM_ID = "id";
	@PersistenceContext(unitName = "ecommercePersistenceUnit")
	private EntityManager entityManager;
	
	public void save(Personne personne){
		entityManager.persist(personne);
	}
	
	@SuppressWarnings("unchecked")
	public List<Personne> getAll(){
		Query query=entityManager.createQuery(JPQL_SELECT);
		List<Personne> personnes=(List<Personne>)query.getResultList();
		return personnes;
	}
	
	public Personne getByEmail(String email){
		Query query=entityManager.createQuery(JPQL_SELECT_PAR_EMAIL);
		query.setParameter(PARAM_EMAIL, email);
		return (Personne) query.getSingleResult();
	}
	
	public void update(Personne personne){
		entityManager.merge(personne);
	}
	
	public Personne getId(Long id){
		return entityManager.find(Personne.class, id);
	}
	
	public void delete(long idPersone){
		Query query=entityManager.createQuery(JPQL_SELECT_PAR_ID);
		query.setParameter(PARAM_ID, idPersone);
		Personne personne=(Personne) query.getSingleResult();
		entityManager.remove(personne);
	}

}
