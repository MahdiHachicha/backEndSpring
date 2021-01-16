package com.example.demo.entities;



import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.example.demo.beans.EvenementBean;
import com.example.demo.beans.OutilBean;
import com.example.demo.beans.PublicationBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_mbr",discriminatorType = DiscriminatorType.STRING,length =3)


public abstract class Member  {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	protected String cin;
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	private java.util.Date date;
	@Lob
	private String photo;
	private String cv;
	private String email;
	private String password;
	@Transient
	private Collection<PublicationBean> pubs;
	
	@Transient
	private Collection<EvenementBean> events;
	
	@Transient
	private Collection<OutilBean> outils;
	
	
	
	public Member(Long id ,String nom, String prenom, String cin, Date date, String photo, String cv, String email,String password) {
        super();
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.date = date;
        this.photo = photo;
        this.cv = cv;
        this.email = email;
        this.password = password;
    }
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public java.util.Date getDate() {
		return date;
	}


	public void setDate(java.util.Date date) {
		this.date = date;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public String getCv() {
		return cv;
	}


	public void setCv(String cv) {
		this.cv = cv;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Collection<PublicationBean> getPubs() {
		return pubs;
	}


	public void setPubs(Collection<PublicationBean> pubs) {
		this.pubs = pubs;
	}
	public Collection<EvenementBean> getEvents() {
		return events;
	}
	public void setEvents(Collection<EvenementBean> events) {
		this.events = events;
	}
	
	public Collection<OutilBean> getOutils() {
		return outils;
	}
	public void setOutils(Collection<OutilBean> outils) {
		this.outils = outils;
	}
	
	public Member() {
		super();
	}
}
