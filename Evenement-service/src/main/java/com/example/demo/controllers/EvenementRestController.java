package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.Evenement;
import com.example.demo.services.IEvenementService;

@RestController
public class EvenementRestController {

	@Autowired
	IEvenementService evenementservice;
	
	@RequestMapping(value = "/evenements", method = RequestMethod.GET)
	public List<Evenement> findEvenements(){
		return evenementservice.findAll();
	}
	@GetMapping(value = "/evenement/{id}")
	public Evenement findOneEvenementById(@PathVariable Long id) {
		return evenementservice.findEvenement(id);
	}
	@GetMapping(value = "/evenement/search/title")
	public Evenement findEvenementByTitle(@RequestParam String t){
		return evenementservice.findByTitle(t);
	}
	
	@DeleteMapping(value = "/evenements/{id}")
	public void deletEvenement(@PathVariable Long id) {
		evenementservice.deleteEvenement(id);
	}
	
	@PostMapping(value="/evenement/add")
	public Evenement addEvenement(@RequestBody Evenement e) {
		return evenementservice.addEvenement(e);
	}
	
	@PutMapping(value = "/evenements/{id}")
	public Evenement updateEvenement(@PathVariable Long id, @RequestBody Evenement e) {
		e.setId(id);
		return evenementservice.updateEvenement(e);
	}
}
