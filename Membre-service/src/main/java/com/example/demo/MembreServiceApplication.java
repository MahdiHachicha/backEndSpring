package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.example.demo.beans.EvenementBean;
import com.example.demo.beans.OutilBean;
import com.example.demo.beans.PublicationBean;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Member;
import com.example.demo.proxies.EvenementProxy;
import com.example.demo.proxies.OutilProxy;
import com.example.demo.proxies.PublicationProxy;
import com.example.demo.services.IMemberService;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MembreServiceApplication implements CommandLineRunner{
	
	@Autowired
	private IMemberService memberService;
	//private MemberRepository memberRepository;
	@Autowired
	PublicationProxy publicationproxy;
	@Autowired
	EvenementProxy evenementproxy;
	@Autowired
	OutilProxy outilproxy;
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(MembreServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {	
		
		Date date1=new Date();
		String photo = null;
		// Creation
		Member etd1 = new Etudiant(null, "rebai", "yassin", "1111", date1, photo, "cv", "email", "123456789", date1,
				"diplôme",null);
		Member etd2 = new Etudiant(null, "rebai", "yassmine", "2222", date1, photo, "cv", "email", "123456789", date1,
				"diplôme",null);

		Member eus1 = new EnseignantChercheur(null, "rebai", "salah", "3333", date1, photo, "cv", "email", "123456789",
				"grade", "etablissement");
		Member eus2 = new EnseignantChercheur(null, "rebai", "mohamed", "4444", date1, photo, "cv", "email",
				"123456789", "grade", "etablissement");		 
		/*memberRepository.save(e1);
		memberRepository.save(e2);
		memberRepository.save(chercheur1);
		memberRepository.save(chercheur2);*/
		 
		memberService.addMember(etd1);
		memberService.addMember(etd2);
		memberService.addMember(eus1);
		memberService.addMember(eus2);
		
		/*memberRepository.findAll().forEach(p->{
			System.out.println(p.getNom());
		});
		Member member1=memberRepository.findById((long) 1).get();
		memberRepository.delete(member1);*/
		Member member2= memberService.findMember((long) 1);
		member2.setCv("new cv");
		memberService.affecterencadrant((long) 1,(long) 3);
		
		PublicationBean publication=publicationproxy.findPublicationById(1L).getContent();
		EvenementBean evenement=evenementproxy.findEvenementById(1L).getContent();
		OutilBean outil=outilproxy.findOutilById(1L).getContent();
		
		memberService.affecterOrganisateurToEvenement(1L, 1L);
		memberService.affecterAuteurToPublication(1L, 1L);
		memberService.affecterUtilisateurToOutil(1L, 1L);
		System.out.println(publication);
	}

}
