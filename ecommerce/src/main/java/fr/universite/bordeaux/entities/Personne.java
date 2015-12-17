package fr.universite.bordeaux.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope = Personne.class)
public class Personne implements Serializable{
	
	private static final long serialVersionUID = 8897117888817851683L;
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(length=50)
	private String prenom;
	@Column(length=50)
	private String nom;
	@Column(length=100)
	private String adresse;
	@Column(length=50)
	private String ville;
	@Column(length=10)
	private String tel;
	@Column(length=50)
	private String mail;
	@Column(length=100)
	private String pass;
	
	@JsonIgnore
	@OneToMany(mappedBy="personne")
	private Set<Annonce> annonces;
	
	@JsonIgnore
	@OneToMany(mappedBy="personne")
	private Set<Critere> criteres;
	
	@ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
	@JoinColumn(name="idRole", referencedColumnName="id")
	private Role role;

	public Personne(){
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public Set<Annonce> getAnnonces() {
		return annonces;
	}

	public void setAnnonces(Set<Annonce> annonces) {
		this.annonces = annonces;
	}

	public Role getRole() {
		return role;
	}

	public void setRoles(Role role) {
		this.role = role;
	}

	public Set<Critere> getCriteres() {
		return criteres;
	}

	public void setCriteres(Set<Critere> criteres) {
		this.criteres = criteres;
	}
	
}
