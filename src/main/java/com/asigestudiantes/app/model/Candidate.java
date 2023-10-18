package com.asigestudiantes.app.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="CANDIDATES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {

	@Id
	@Column(name="ID_CANDIDATE")
	private String id_candidate;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="LASTNAME")
	private String lastname;
	
	@Column(name="ID_TYPE")
	private String id_type;
	
	@Column(name="SEX")
	private String sex;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="ESTATE")
	private String estate;
	
	@Column(name="ICFES_GENERAL")
	private double icfes_general;
	
	@Column(name="AGE")
	private int age;
	
}
