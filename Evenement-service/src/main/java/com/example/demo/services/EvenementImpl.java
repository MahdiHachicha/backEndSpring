package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EvenementRepository;
import com.example.demo.entities.Evenement;

@Service
public class EvenementImpl implements IEvenementService {

	@Autowired
	EvenementRepository evenementrepository;

	@Override
	public Evenement addEvenement(Evenement e) {
		evenementrepository.save(e);
		return e;
	}

	@Override
	public void deleteEvenement(Long id) {

		evenementrepository.deleteById(id);
	}

	@Override
	public Evenement updateEvenement(Evenement p) {
		return evenementrepository.saveAndFlush(p);
	}

	@Override
	public Evenement findEvenement(Long id) {
		Evenement e = (Evenement) evenementrepository.findById(id).get();
		return e;
	}

	@Override
	public List<Evenement> findAll() {

		return evenementrepository.findAll();
	}

	@Override
	public Evenement findByTitle(String t) {
		return evenementrepository.findByTitle(t);
	}

	@Override
	public Evenement findByLieu(String l) {
		return evenementrepository.findByLieu(l);
	}

}
