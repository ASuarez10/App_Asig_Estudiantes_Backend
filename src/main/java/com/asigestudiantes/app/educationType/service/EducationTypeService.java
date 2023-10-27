package com.asigestudiantes.app.educationType.service;

import com.asigestudiantes.app.model.Education_type;

public interface EducationTypeService {

	public Iterable<Education_type> findAll();
	
	public Iterable<String> findAllNames();
	
}
