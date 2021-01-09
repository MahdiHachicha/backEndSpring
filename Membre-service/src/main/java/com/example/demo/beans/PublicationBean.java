package com.example.demo.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
public class PublicationBean {

	
	private Long id;
	private String type;
	private String title;
	private String lien;
	private Date date;
	private String sourcePdf;
}
