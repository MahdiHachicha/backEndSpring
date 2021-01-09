package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OutilRepository;
import com.example.demo.entities.Outil;

@Service
public class OutilImpl implements IOutilService{

	@Autowired
	OutilRepository outilrepository;
	@Override
	public Outil addOutil(Outil m) {
		outilrepository.save(m);
		return m;
	}

	@Override
	public void deleteOutil(Long id) {
		outilrepository.deleteById(id);
		
	}

	@Override
	public Outil updateOutil(Outil p) {
		return outilrepository.saveAndFlush(p);
	}

	@Override
	public Outil findOutil(Long id) {
		Outil m = outilrepository.findById(id).get();
		return m;
	}

	@Override
	public List<Outil> findAll() {
		return outilrepository.findAll();
	}

}
