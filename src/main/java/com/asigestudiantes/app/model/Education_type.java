package com.asigestudiantes.app.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="EDUCATION_TYPES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Education_type {

	@Id
	@Column(name="ID_EDUCATION_TYPE")
	private String id_education_type;
	
	@Column(name="EDUCATION_TYPE_NAME")
	private String education_type_name;
	
}
