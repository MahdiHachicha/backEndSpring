package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Outil;


public interface IOutilService {
	public Outil addOutil(Outil m);

	public void deleteOutil(Long id);

	public Outil updateOutil(Outil p);

	public Outil findOutil(Long id);

	public List<Outil> findAll();



}
