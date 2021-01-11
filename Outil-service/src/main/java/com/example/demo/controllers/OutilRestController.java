package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.demo.entities.Outil;
import com.example.demo.services.IOutilService;

@RestController
public class OutilRestController {
	@Autowired
	IOutilService outilservice;
	
	@RequestMapping(value = "/outils", method = RequestMethod.GET)
	public List<Outil> findOutils() {
		return outilservice.findAll();
	}

	@GetMapping(value = "/outil/{id}")
	public Outil findOneOutil(@PathVariable Long id) {
		return outilservice.findOutil(id);
	}
	@PostMapping(value = "/outil/add")

	public Outil addOutil(@RequestBody Outil e)

	{
		return outilservice.addOutil(e);

	}
	
	@PutMapping(value = "/outils/{id}")
	public Outil updateOutil(@PathVariable Long id, @RequestBody Outil o) {
		o.setId(id);
		return outilservice.updateOutil(o);
	}
	
	@DeleteMapping(value = "/outils/{id}")
	public void deletOutil(@PathVariable Long id) {
		outilservice.deleteOutil(id);
	}


}
