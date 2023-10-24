package com.asigestudiantes.app.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="CRITERION")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Criterion {

	@Id
	@Column(name="ID_CRITERION")
	private String id_criterion;
	
	@Column(name="CATEGORY")
	private String category;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="COLUMN_NAME")
	private String column_name;
	
	@Column(name="TABLE_NAME")
	private String table_name;
	
	@Column(name="STATISTIC_TYPE")
	private String statistic_type;
	
	@Column(name="VALUE")
	private String value;
	
	@Column(name="MANDATORY")
	private String mandatory;
	
}
