package com.asigestudiantes.app.educationType.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asigestudiantes.app.educationType.repository.EducationTypeRepository;
import com.asigestudiantes.app.model.Education_type;

@Service
public class EducationTypeServiceImpl implements EducationTypeService{

	@Autowired
	private EducationTypeRepository etRepository;
	
	@Override
	public Iterable<Education_type> findAll() {
		return etRepository.findAll();
	}

	@Override
	public Iterable<String> findAllNames() {
		return etRepository.listDistinctNames();
	}

}
