package com.example.demo.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Membre_Outil {

	@EmbeddedId 
	private Membre_Outil_Ids id;
	
	@ManyToOne @MapsId("utilisateur_id")
	private Member utilisateur;
}
