package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

	Member findByCin(String cin);
	List<Member>findByNomStartingWith( String nom);
	Member findByEmail(String email);
}
