package com.asigestudiantes.app.model;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="HEADQUARTERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Headquarter {

	@Id
	@Column(name="ID_HEADQUARTER")
	private long id_headquarter;
	
	@Column(name="HEADQUARTER_CITY")
	private String headquarter_city;
	
	@Column(name="HEADQUARTER_ESTATE")
	private String headquarter_estate;
	
}
