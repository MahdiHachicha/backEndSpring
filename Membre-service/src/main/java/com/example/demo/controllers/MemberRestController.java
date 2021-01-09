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
import com.example.demo.services.IMemberService;

@RestController
public class MemberRestController {

	@Autowired
	IMemberService memberService;

	@RequestMapping(value = "/membres", method = RequestMethod.GET)
	public List<Member> findMembres() {
		return memberService.findAll();
	}

	@GetMapping(value = "/membre/{id}")
	public Member findOneMemberById(@PathVariable Long id) {
		return memberService.findMember(id);
	}
	
	@GetMapping(value = "/membres/event/{id}")
	public List<Member> findMemberByEventId(@PathVariable Long id) {
		return memberService.findorganisteurevenement(id);
	}

	@GetMapping(value = "/membre/search/cin/{cin}")
	public Member findOneMemberByCin(@PathVariable String cin) {
		return memberService.findByCin(cin);
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

	@GetMapping(value = "/membre/search/email")
	public Member findOneMemberByEmail(@RequestParam String email) {
		return memberService.findByEmail(email);
	}

	@PostMapping(value = "/membres/enseignant")

	public Member addMembre(@RequestBody EnseignantChercheur m)

	{
		return memberService.addMember(m);

	}

	@DeleteMapping(value = "/membres/{id}")

	public void deleteMembre(@PathVariable Long id)

	{

		memberService.deleteMember(id);

	}

	@PutMapping(value = "/membres/etudiant/{id}")

	public Member updatemembre(@PathVariable Long id, @RequestBody Etudiant p)

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

}
