package com.asigestudiantes.app.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="CAREERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Career {

	@Id
	@Column(name="ID_CAREER")
	private String id_career;
	
	@Column(name="CAREER_NAME")
	private String career_name;
	
	@Column(name="FACULTY_NAME")
	private String faculty_name;
}
