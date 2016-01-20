package fr.universite.bordeaux.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id",scope = Email.class)
public class Email implements Serializable{

	private static final long serialVersionUID = -3246618384753087348L;
	@Id
	private long id;
	@Column(length=100)
	private String fromEmail;
	@Column(length=100)
	private String toEmail;
	@Column(length=100)
	private String title;
	@Column(length=5000)
	private String message;
	
	public Email(){
		
	}
	
	public Email(String fromEmail,String toEmail,String title,String message){
		this.title=title;
		this.message=message;
		this.fromEmail=fromEmail;
		this.toEmail=toEmail;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getFromEmail() {
		return fromEmail;
	}
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}
	public String getToEmail() {
		return toEmail;
	}
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
