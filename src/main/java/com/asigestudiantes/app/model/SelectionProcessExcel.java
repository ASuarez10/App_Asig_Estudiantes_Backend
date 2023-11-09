package com.asigestudiantes.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectionProcessExcel{
	//Fields from selection process
	private long id_process;
	private String process_date;
	
	//Fields from candidate
	private String id_candidate;
	private String candidate_name;
	private String candidate_lastname;
	private String candidate_id_type;
	private String candidate_sex;
	private String candidate_city;
	private String candidate_estate;
	private double candidate_icfes_general;
	private int candidate_age;
	
	//Fields from headquarter
	private String headquarter_city;
	
	//Fields from career
	private String career_name;
	
	//Field from education type
	private String education_type_name;
	
	//Fields from selection
	private int percentage;
	private int priority;

}
