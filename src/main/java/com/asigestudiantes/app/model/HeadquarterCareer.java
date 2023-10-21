package com.asigestudiantes.app.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="HEADQUARTERS_CAREERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeadquarterCareer {

	@Id
	@Column(name="ID_HEADQUARTER_CAREER")
	private long id_headquarter_career;
	
	@Column(name="ID_HEADQUARTER")
	private long id_headquarter;
	
	@Column(name="ID_CAREER")
	private long id_career;
	
	@OneToMany(mappedBy = "headquartercareer")
	@JsonIgnore
	private List<Candidate> candidates;
	
}
