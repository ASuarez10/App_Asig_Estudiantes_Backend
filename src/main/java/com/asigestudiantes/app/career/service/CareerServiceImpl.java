package com.asigestudiantes.app.career.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asigestudiantes.app.career.repository.CareerRepository;
import com.asigestudiantes.app.model.Career;

@Service
public class CareerServiceImpl implements CareerService{

	@Autowired
	private CareerRepository careerRepository;
	
	@Override
	public Iterable<Career> findAll() {
		return careerRepository.findAll();
	}

	@Override
	public Iterable<String> findAllNames() {
		return careerRepository.listDistinctNames();
	}

}
