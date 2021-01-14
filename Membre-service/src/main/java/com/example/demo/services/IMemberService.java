package com.example.demo.services;

import java.util.List;

import com.example.demo.beans.EvenementBean;
import com.example.demo.beans.OutilBean;
import com.example.demo.beans.PublicationBean;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Member;
import com.example.demo.entities.Membre_Event_Ids;
import com.example.demo.entities.Membre_Outil_Ids;
import com.example.demo.entities.Membre_Pub_Ids;

public interface IMemberService {
	// Crud sur les membres
	public Member addMember(Member m);

	public void deleteMember(Long id);

	public Member updateMember(Member p);

	public Member findMember(Long id);

	public List<Member> findAll();

	public Member affecterencadrant(Long idet, Long idens);

	public Member findByCin(String cin);

	public Member findByEmail(String email);

	public void affecterAuteurToPublication(Long idauteur, Long idpublication);
	
	public List<PublicationBean>findPublicationparauteur (Long idauteur);
	
	public void affecterOrganisateurToEvenement(Long idorganisateur, Long idevenement);
	
	public void removeOrganisateurfromEvenement(Membre_Event_Ids membre_event);
	
	public List<EvenementBean>findEvenementparorganisateur (Long idorganisateur);
	
	public void affecterUtilisateurToOutil(Long idutilisateur, Long idoutil);
	
	public List<OutilBean>findOutilparutilisateur (Long idutilisateur);

	public List<Member> findorganisteurevenement(Long idevenement);
	
	public void removeAuteurfromOutil(Membre_Outil_Ids membre_outil);
	
	public List<Member> findauteuroutil(Long idoutil);
	
	public List<EnseignantChercheur> findAllTeachers();
	
	public List<Etudiant> findAllStudents();
	
	public List <Etudiant> findStudentsByEncadrant (EnseignantChercheur enseignant);
	
	public List<Member> findauteurParpublication(Long idPublication);
	
	public void removeAuteurfromPublication(Membre_Pub_Ids membre_publication);
	
}
