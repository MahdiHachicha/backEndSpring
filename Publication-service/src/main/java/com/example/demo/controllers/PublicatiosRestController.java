package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Publication;
import com.example.demo.services.IPublicationService;

@RestController
public class PublicatiosRestController {
	@Autowired
	IPublicationService publicationservice;
	
	@RequestMapping(value = "/publications",method = RequestMethod.GET)
	public List<Publication>findPublications(){
		return publicationservice.findAll();
	}
	@GetMapping(value = "/publications/{id}")
	public Publication findOnePublicationtById(@PathVariable Long id) {
		return publicationservice.findPublication(id);
	}
	@PostMapping(value = "/publication")

	public Publication addPublication(@RequestBody Publication m)

	{
		return publicationservice.addPublication(m);

	}
	
	@DeleteMapping(value = "/publications/{id}")

	public void deletePublication(@PathVariable Long id)

	{

		publicationservice.deletePublication(id);;

	}

}
