package fr.universite.bordeaux.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope = Annonce.class)
public class Annonce implements Serializable{

	private static final long serialVersionUID = 3816437476066957474L;

	@Id
	private long id;
	
	@Column(length=300)
	private String photo;
	private double prix;
	private long surface;
	@Column(length=100)
	private String adresse;
	@Column(length=50)
	private String ville;
	@Column(length=65535)
	private String description;
	@Column
	private String observers;
	@Column
	private Integer vendu;
	
	@ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
	@JoinColumn(name="idPersonne", referencedColumnName="id")
	private Personne personne;
	
	public Annonce(){
		this.vendu=0;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public long getSurface() {
		return surface;
	}
	public void setSurface(long surface) {
		this.surface = surface;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setObservers(String observers) {
		this.observers = observers;
	}

	public Integer getVendu() {
		return vendu;
	}

	public void setVendu(Integer vendu) {
		this.vendu = vendu;
	}

}
