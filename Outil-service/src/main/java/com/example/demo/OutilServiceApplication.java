package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.OutilRepository;
import com.example.demo.entities.Outil;


@SpringBootApplication
@EnableDiscoveryClient
public class OutilServiceApplication implements CommandLineRunner{

	@Autowired
	private OutilRepository outilrepository;
	
	public static void main(String[] args) {
		SpringApplication.run(OutilServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Date d=new Date();
		outilrepository.save(new Outil(null,d,"source1"));
	}

}
