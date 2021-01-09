package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Evenement;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Long> {

	Evenement findByTitle(String title);
	Evenement findByLieu(String lieu);
}
