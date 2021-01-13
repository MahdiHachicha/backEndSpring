package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Member;
import com.example.demo.entities.Membre_Event_Ids;
import com.example.demo.entities.Membre_Outil_Ids;
import com.example.demo.services.IMemberService;

@RestController
public class MemberRestController {

	@Autowired
	IMemberService memberService;

	@RequestMapping(value = "/membres", method = RequestMethod.GET)
	public List<Member> findMembres() {
		return memberService.findAll();
	}
	
	@RequestMapping(value = "/etudiants", method = RequestMethod.GET)
	public List<Etudiant> findEtudiants() {
		return memberService.findAllStudents();
	}
	@RequestMapping(value = "/enseignants", method = RequestMethod.GET)
	public List<EnseignantChercheur> findEnseignats() {
		return memberService.findAllTeachers();
	}

	@GetMapping(value = "/membre/{id}")
	public Member findOneMemberById(@PathVariable Long id) {
		return memberService.findMember(id);
	}
	
	
	@GetMapping(value = "/membre/search/cin/{cin}")
	public Member findOneMemberByCin(@PathVariable String cin) {
		return memberService.findByCin(cin);
	}
	
	//Get,Add & remove member to event
	
	@GetMapping(value = "/membres/event/{id}")
	public List<Member> findMemberByEventId(@PathVariable Long id) {
		return memberService.findorganisteurevenement(id);
	}
	
	@PostMapping(value = "/membres/event/addParticipant")

	public void addParticipant(@RequestBody Membre_Event_Ids membre_event)

	{
		 memberService.affecterOrganisateurToEvenement(membre_event.getOrganisateur_id(), membre_event.getEvenement_id());

	}
	
	@PostMapping(value = "/membres/event/removeParticipant")

	public void removeParticipant(@RequestBody Membre_Event_Ids membre_event)

	{
		 memberService.removeOrganisateurfromEvenement(membre_event);

	}
	
	//Get,Add & remove member to tool
	
	@GetMapping(value = "/membres/outil/{id}")
	public List<Member> findMemberByOutilId(@PathVariable Long id) {
		return memberService.findauteuroutil(id);
	}

	
	@PostMapping(value = "/membres/outil/addAuteur")

	public void addAuteur(@RequestBody Membre_Outil_Ids membre_outil)

	{
		 memberService.affecterUtilisateurToOutil(membre_outil.getUtilisateur_id(), membre_outil.getOutil_id());

	}
	
	
	@PostMapping(value = "/membres/outil/removeAuteur")

	public void removeAuteur(@RequestBody Membre_Outil_Ids membre_outil)

	{
		 memberService.removeAuteurfromOutil(membre_outil);

	}

	@GetMapping(value = "/membre/search/email")
	public Member findOneMemberByEmail(@RequestParam String email) {
		return memberService.findByEmail(email);
	}

	@PostMapping(value = "/membres/enseignant")

	public Member addEnseignant(@RequestBody EnseignantChercheur m)

	{
		return memberService.addMember(m);

	}
	@PostMapping(value = "/membres/etudiant")

	public Member addEtudiant(@RequestBody Etudiant m)

	{
		return memberService.addMember(m);

	}

	@DeleteMapping(value = "/membres/{id}")

	public void deleteMembre(@PathVariable Long id)

	{

		memberService.deleteMember(id);

	}

	@PutMapping(value = "/membres/etudiant/{id}")

	public Member updateStudent(@PathVariable Long id, @RequestBody Etudiant p)

	{

		p.setId(id);
		return memberService.updateMember(p);

	}
	
	@PutMapping(value = "/membres/enseignant/{id}")

	public Member updateTeacher(@PathVariable Long id, @RequestBody EnseignantChercheur p)

	{

		p.setId(id);
		return memberService.updateMember(p);

	}

	@PutMapping(value = "/memberes/etudiant")
	public Member affecter(@RequestParam Long idetd, @RequestParam Long idens) {
		return memberService.affecterencadrant(idetd, idens);
	}

	@GetMapping(value = "/fullmember/{id}")
	public Member findAFullMember(@PathVariable(name = "id") Long id)

	{
		Member mbr = memberService.findMember(id);
		mbr.setPubs(memberService.findPublicationparauteur(id));
		mbr.setEvents(memberService.findEvenementparorganisateur(id));
		mbr.setOutils(memberService.findOutilparutilisateur(id));
		return mbr;

	}
	
	@PostMapping(value = "/students/enseignant")
	public List<Etudiant> findStudentsByEncadrant(@RequestBody EnseignantChercheur enseignant)

	{
		return memberService.findStudentsByEncadrant(enseignant);
	}

}
