package com.example.demo.services;

import java.util.List;



import com.example.demo.entities.Publication;

public interface IPublicationService {

	public Publication addPublication(Publication m);

	public void deletePublication(Long id);

	public Publication updatePublication(Publication p);

	public Publication findPublication(Long id);

	public List<Publication> findAll();

	public List<Publication> findByType(String type);

	public List<Publication> findByTitle(String title);
}
