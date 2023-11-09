package com.asigestudiantes.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="SELECTIONS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Selection {
	@Id
	@Column(name="ID_SELECTION")
	private long id_selection;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_CANDIDATE")
	@JsonProperty(access = Access.READ_WRITE)
	private Candidate candidate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_SELECTION_PROCESS")
	@JsonProperty(access = Access.READ_WRITE)
	@JsonIgnore
	private SelectionProcess selectionProcess;
	
	@Column(name="PERCENTAGE")
	private int percentage;
	
	@Column(name="PRIORITY")
	private int priority;
}
