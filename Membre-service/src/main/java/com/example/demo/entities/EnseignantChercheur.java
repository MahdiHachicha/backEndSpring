package com.example.demo.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @DiscriminatorValue("ens")


@ToString(callSuper = true)
public class EnseignantChercheur extends Member  {
	private String grade;
	private String etablissement;

	public EnseignantChercheur(Long id, String cin, String nom, String prenom, Date date, byte[] photo, String cv,
			String email, String password, String grade, String etablissement) {
		super(id, cin, nom, prenom, date, photo, cv, email, password);
		this.grade = grade;
		this.etablissement = etablissement;
		
	}
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}

	public EnseignantChercheur(Long id, String nom, String prenom, String cin, Date date, byte[] photo, String cv,
			String email, String password) {
		super(id, nom, prenom, cin, date, photo, cv, email, password);
	}
	public EnseignantChercheur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
}
