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
@Table(name="SELECTION_PROCESSES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectionProcess {

	@Id
	@Column(name="ID_PROCESS")
	private long id_process;
	
	@Column(name="PROCESS_DATE")
	private String process_date;
	
	@OneToMany(mappedBy = "selectionProcess")
	private List<Selection> selection;
	
}
