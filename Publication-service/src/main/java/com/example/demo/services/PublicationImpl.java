package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PublicationRepository;
import com.example.demo.entities.Publication;

@Service
public class PublicationImpl implements IPublicationService{

	@Autowired
	 PublicationRepository publicationrepository;
	
	@Override
	public Publication addPublication(Publication m) {
		publicationrepository.save(m);
		return m;
	}

	@Override
	public void deletePublication(Long id) {
		publicationrepository.deleteById(id);
	}

	@Override
	public Publication updatePublication(Publication p) {
		
		return publicationrepository.saveAndFlush(p); 
	}

	@Override
	public Publication findPublication(Long id) {
		Publication p= publicationrepository.findById(id).get();
		return p;
	}

	@Override
	public List<Publication> findAll() {
		return publicationrepository.findAll();
	}

	@Override
	public List<Publication> findByType(String type) {
		return publicationrepository.findByType(type);
	}

	@Override
	public List<Publication> findByTitle(String title) {
		return publicationrepository.findByTitle(title);
	}

}
