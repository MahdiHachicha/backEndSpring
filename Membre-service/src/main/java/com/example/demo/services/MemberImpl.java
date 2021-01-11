package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.EvenementBean;
import com.example.demo.beans.OutilBean;
import com.example.demo.beans.PublicationBean;
import com.example.demo.dao.MemberRepository;
import com.example.demo.dao.MembreEvenRepository;
import com.example.demo.dao.MembreOutilRepository;
import com.example.demo.dao.MembrePubRepository;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Member;
import com.example.demo.entities.Membre_Evenement;
import com.example.demo.entities.Membre_Event_Ids;
import com.example.demo.entities.Membre_Outil;
import com.example.demo.entities.Membre_Outil_Ids;
import com.example.demo.entities.Membre_Pub_Ids;
import com.example.demo.entities.Membre_Publication;
import com.example.demo.proxies.EvenementProxy;
import com.example.demo.proxies.OutilProxy;
import com.example.demo.proxies.PublicationProxy;
import com.netflix.discovery.converters.Auto;

@Service
public class MemberImpl implements IMemberService {

	@Autowired
	MemberRepository memberRepository;
	@Autowired
	MembrePubRepository membrepubrepository;
	@Autowired
	MembreEvenRepository membreevenrepository;
	@Autowired
	MembreOutilRepository membreoutilrepository;
	@Autowired
	PublicationProxy publicationproxy;
	@Autowired
	EvenementProxy evenementproxy;
	@Autowired
	OutilProxy outilproxy;

	public Member addMember(Member m) {
		memberRepository.save(m);
		return m;
	}

	public void deleteMember(Long id) {
		memberRepository.deleteById(id);
	}

	public Member updateMember(Member m) {
		return memberRepository.saveAndFlush(m);
	}

	public Member findMember(Long id) {
		Member m = (Member) memberRepository.findById(id).get();
		return m;
	}

	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	public Member affecterencadrant(Long idetd, Long idens) {
		Etudiant e = (Etudiant) memberRepository.findById(idetd).get();
		EnseignantChercheur ens = (EnseignantChercheur) memberRepository.findById(idens).get();
		e.setEncadrant(ens);
		memberRepository.save(e);
		return e;

	}

	public Member findByCin(String cin) {
		return memberRepository.findByCin(cin);
	}

	public Member findByEmail(String email) {
		return memberRepository.findByEmail(email);
	}

	public void affecterAuteurToPublication(Long idauteur, Long idpublication) {
		Member mbr = memberRepository.findById(idauteur).get();
		Membre_Publication mbs = new Membre_Publication();
		mbs.setAuteur(mbr);
		mbs.setId(new Membre_Pub_Ids(idpublication, idauteur));
		membrepubrepository.save(mbs);
		
	}

	public List<PublicationBean> findPublicationparauteur(Long idauteur) {
		List<PublicationBean> pubs = new ArrayList<PublicationBean>();

		List<Membre_Publication> idpubs= membrepubrepository.findpubId(idauteur);

		idpubs.forEach(s -> {
			System.out.println(s);

			pubs.add(publicationproxy.findPublicationById(

					s.getId().getPublication_id()).getContent());
		});
		return pubs;

	}

	@Override
	public void affecterOrganisateurToEvenement(Long idorganisateur, Long idevenement) {
		System.out.println(idorganisateur);
		Member mbr =memberRepository.findById(idorganisateur).get();
		Membre_Evenement mbs = new Membre_Evenement();
		mbs.setOrganisateur(mbr);
		mbs.setId(new Membre_Event_Ids(idevenement, idorganisateur));
		membreevenrepository.save(mbs);
		
	}
	
	
	@Override
	public void removeOrganisateurfromEvenement(Membre_Event_Ids membre_event) {
		Membre_Evenement mbs = membreevenrepository.findById(membre_event).get();
		membreevenrepository.delete(mbs);;
		}
	
	
	@Override
	public void removeAuteurfromOutil(Membre_Outil_Ids membre_outil) {
		Membre_Outil mbs = membreoutilrepository.findById(membre_outil).get();
		membreoutilrepository.delete(mbs);;
		}

	@Override
	public List<EvenementBean> findEvenementparorganisateur(Long idorganisateur) {
		List<EvenementBean> events= new ArrayList<EvenementBean>();
		List<Membre_Evenement> idevents = membreevenrepository.findeventId(idorganisateur);
		idevents.forEach(s-> {
			System.out.println(s);
			events.add(evenementproxy.findEvenementById(
					s.getId().getEvenement_id()).getContent());
		});
		
		return events;
	}

	@Override
	public List<Member> findorganisteurevenement(Long idevenement) {
		List<Member> members= new ArrayList<Member>();
		List<Membre_Evenement> idmembers = membreevenrepository.findmemberId(idevenement);
		idmembers.forEach(s-> {
			System.out.println(s);
			members.add(memberRepository.findById(
					s.getId().getOrganisateur_id()).get());
		});
		
		return members;
	}
	
	
	@Override
	public List<Member> findauteuroutil(Long idoutil) {
		List<Member> members= new ArrayList<Member>();
		List<Membre_Outil> idmembers = membreoutilrepository.findmemberId(idoutil);
		idmembers.forEach(s-> {
			System.out.println(s);
			members.add(memberRepository.findById(
					s.getId().getUtilisateur_id()).get());
		});
		
		return members;
	}

	@Override
	public void affecterUtilisateurToOutil(Long idutilisateur, Long idoutil) {
		Member mbr=memberRepository.findById(idutilisateur).get();
		Membre_Outil mbs = new Membre_Outil();
		mbs.setUtilisateur(mbr);
		mbs.setId(new Membre_Outil_Ids(idoutil, idutilisateur));
		membreoutilrepository.save(mbs);		
	}

	@Override
	public List<OutilBean> findOutilparutilisateur(Long idutilisateur) {
		List<OutilBean> outils=new ArrayList<OutilBean>();
		List<Membre_Outil> idoutils=membreoutilrepository.findoutilId(idutilisateur);
		idoutils.forEach(s->{
			System.out.println(s);
			outils.add(outilproxy.findOutilById(
					s.getId().getOutil_id()).getContent());
		});
		return outils;
	}

}
