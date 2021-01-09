package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Evenement;

public interface IEvenementService {

	public Evenement addEvenement(Evenement e);

	public void deleteEvenement(Long id);

	public Evenement updateEvenement(Evenement p);

	public Evenement findEvenement(Long id);

	public List<Evenement> findAll();

	public Evenement findByTitle(String t);

	public Evenement findByLieu(String l);
}
