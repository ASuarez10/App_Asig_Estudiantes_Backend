package com.asigestudiantes.app.headquarter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asigestudiantes.app.headquarter.repository.HeadquarterRepository;
import com.asigestudiantes.app.model.Headquarter;

@Service
public class HeadquarterServiceImpl implements HeadquarterService{
	
	@Autowired
	private HeadquarterRepository headquarterRepository;

	@Override
	public Iterable<Headquarter> findAll() {
		return headquarterRepository.findAll();
	}

	@Override
	public Iterable<String> findAllNames() {
		return headquarterRepository.listDistinctNames();
	}

}
