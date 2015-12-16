package fr.universite.bordeaux.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.universite.bordeaux.entities.Annonce;

@Stateless
public class AnnonceRepository {

	private static final String JPQL_SELECT = "SELECT a FROM Annonce a";
	private static final String JPQL_SELECT_PAR_PERSONNE = "SELECT a FROM Annonce a WHERE a.personne.id=:idPersonne";
	private static final String PARAM_PERSONNE = "idPersonne";
	@PersistenceContext(unitName = "ecommercePersistenceUnit")
	private EntityManager entityManager;
	
	public void saveOrUpdate(Annonce annonce){
		entityManager.merge(annonce);
	}
	
	@SuppressWarnings("unchecked")
	public List<Annonce> getALL(){
        Query query=entityManager.createQuery(JPQL_SELECT);
        List<Annonce> annonces=(List<Annonce>)query.getResultList();
        return annonces;		
	}
	
	public Annonce getByPersonne(long idPersonne){
		Query query=entityManager.createQuery(JPQL_SELECT_PAR_PERSONNE);
		query.setParameter(PARAM_PERSONNE, idPersonne);
        Annonce annonce=(Annonce)query.getSingleResult();
		return annonce;
	}
	
	public Annonce getId(long id){
		return entityManager.find(Annonce.class, id);
	}
	
	public void delete(long id){
		Annonce annonce=getId(id);
		entityManager.remove(annonce);
	}
}

