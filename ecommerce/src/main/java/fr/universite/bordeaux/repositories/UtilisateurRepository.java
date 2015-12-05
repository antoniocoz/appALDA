package fr.universite.bordeaux.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.universite.bordeaux.entities.Utilisateur;

@Stateless
public class UtilisateurRepository {
	
	private static final String JPQL_SELECT = "SELECT u FROM Utilisateur u";
	private static final String JPQL_SELECT_PAR_EMAIL = "SELECT u FROM Utilisateur u WHERE u.email=:email";
	private static final String PARAM_EMAIL = "email";
	@PersistenceContext(unitName = "ecommercePersistenceUnit")
	private EntityManager entityManager;
	
	public void save(Utilisateur utilisateur){
		entityManager.persist(utilisateur);
	}

	@SuppressWarnings("unchecked")
	public List<Utilisateur> getALL(){
		Query query=entityManager.createQuery(JPQL_SELECT);
		List<Utilisateur> utilisateurs=(List<Utilisateur>)query.getResultList();
		return utilisateurs;
	}
	
	public Utilisateur getByEmail(String email){
		Query query=entityManager.createQuery(JPQL_SELECT_PAR_EMAIL);
		query.setParameter(PARAM_EMAIL, email);
		Utilisateur utilisateur=(Utilisateur)query.getSingleResult();
		return utilisateur;
	}
	
	public void update(Utilisateur utilisateur){
		entityManager.merge(utilisateur);
	}
	
	public Utilisateur getId(Long id){
		return entityManager.find(Utilisateur.class, id);
	}
	
}
