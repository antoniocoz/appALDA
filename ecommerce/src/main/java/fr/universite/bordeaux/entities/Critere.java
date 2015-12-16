package fr.universite.bordeaux.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class Critere implements Serializable{

	private static final long serialVersionUID = -7929191409183993054L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="idPersonne", referencedColumnName="id")
	private Personne personne;
	@Column(length=50)
	private String type;
	@Column(length=50)
	private String ville;
	private double prix_min;
	private double prix_max;
	private int surface_min;
	private int surface_max;
	
	public Critere() {
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
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getVille() {
		return ville;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public double getPrix_min() {
		return prix_min;
	}
	
	public void setPrix_min(double prix_min) {
		this.prix_min = prix_min;
	}
	
	public double getPrix_max() {
		return prix_max;
	}
	
	public void setPrix_max(double prix_max) {
		this.prix_max = prix_max;
	}
	
	public int getSurface_min() {
		return surface_min;
	}
	
	public void setSurface_min(int surface_min) {
		this.surface_min = surface_min;
	}
	
	public int getSurface_max() {
		return surface_max;
	}
	
	public void setSurface_max(int surface_max) {
		this.surface_max = surface_max;
	}
	
}
