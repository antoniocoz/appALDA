package fr.universite.bordeaux.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="utilisateur")
public class Utilisateur {
	
	@Id
	@Column(name="id_utilisateur")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUtilisateur;
	@Column(length=200,nullable=false)
	private String prenom;
	@Column(length=200,nullable=false)
	private String nom;
	@Column(length=200, nullable=false)
	private String adresse;
	@Column(length=200,nullable=false)
	private String telephone;
	@Column(length=200,nullable=false)
	private String email;
	@Column(name="user_name",nullable=false)
	private String userName;
	@Column(nullable=false)
	private String password;
	@Temporal(TemporalType.DATE)
	@Column(name="date_naissance")
	private Date dateNaissance;
	@Temporal(TemporalType.DATE)
	@Column(name="date_inscription")
	private Date dateInscription;
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public Date getDateInscription() {
		return dateInscription;
	}
	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
