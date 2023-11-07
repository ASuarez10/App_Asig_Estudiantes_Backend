package com.asigestudiantes.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="CRITERIA_CONFIGURATION")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CriteriaConfiguration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_CONF")
	private long id_conf;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_CRITERION")
	@JsonProperty(access = Access.READ_WRITE)
	private Criterion criterion;
	
	@Column(name="VALUE")
	private String value;
	
	@Column(name="PRIORITY")
	private String priority;
	
	@Column(name="PERCENTAGE")
	private long percentage;
	
	@Column(name="COMPARATOR")
	private String comparator;
	
	@Column(name="AUTOMATIZED")
	private int automatized;

}
