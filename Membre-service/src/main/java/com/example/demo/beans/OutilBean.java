package com.example.demo.beans;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
public class OutilBean {
	
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String source;

}
