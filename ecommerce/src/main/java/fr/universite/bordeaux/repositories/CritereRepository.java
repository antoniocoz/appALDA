package fr.universite.bordeaux.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.universite.bordeaux.entities.Critere;

@Stateless
public class CritereRepository {

	private static final String JPQL_SELECT = "SELECT c FROM Critere c";
	private static final String JPQL_SELECT_PAR_PERSONNE = "SELECT c FROM Critere c WHERE c.personne.id=:idPersonne";
	private static final String PARAM_PERSONNE = "idPersonne";
	@PersistenceContext(unitName = "ecommercePersistenceUnit")
	private EntityManager entityManager;
	
	public void saveOrUpdate(Critere critere){
		entityManager.merge(critere);
	}
	
	@SuppressWarnings("unchecked")
	public List<Critere> getAll(){
        Query query=entityManager.createQuery(JPQL_SELECT);
        List<Critere> criteres=(List<Critere>)query.getResultList();
        return criteres;		
	}
	
	public Critere getByPersonne(long idPersonne){
		Query query=entityManager.createQuery(JPQL_SELECT_PAR_PERSONNE);
		query.setParameter(PARAM_PERSONNE, idPersonne);
		Critere critere = (Critere)query.getSingleResult();
		return critere;
	}
	
	public Critere getId(long id){
		return entityManager.find(Critere.class, id);
	}
	
	public void delete(long id){
		Critere critere = getId(id);
		entityManager.remove(critere);
	}
}
