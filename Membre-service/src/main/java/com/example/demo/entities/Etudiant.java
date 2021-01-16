package com.example.demo.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity 
@DiscriminatorValue("etd")
@ToString(callSuper = true) //getters and setters
public class Etudiant extends Member  {
	@Temporal(TemporalType.DATE)
	private Date dateInscription;
	private String diplome;
	@ManyToOne
	private EnseignantChercheur encadrant;
	@Builder
	public Etudiant(Long id, String cin, String nom, String prenom, Date date, String photo, String cv, String email,
			String password, Date dateInscription, String diplome, EnseignantChercheur encadrant) {
		super(id, cin, nom, prenom, date, photo, cv, email, password);
		this.dateInscription = dateInscription;
		this.diplome = diplome;
		this.encadrant = encadrant;
	}
	public Date getDateInscription() {
		return dateInscription;
	}
	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}
	public String getDiplome() {
		return diplome;
	}
	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	public EnseignantChercheur getEncadrant() {
		return encadrant;
	}
	public void setEncadrant(EnseignantChercheur encadrant) {
		this.encadrant = encadrant;
	}
	public Etudiant(Long id, String nom, String prenom, String cin, Date date, String photo, String cv, String email,
			String password) {
		super(id, nom, prenom, cin, date, photo, cv, email, password);
	}
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
