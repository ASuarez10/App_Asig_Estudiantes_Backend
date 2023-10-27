package com.asigestudiantes.app.career.service;

import com.asigestudiantes.app.model.Career;

public interface CareerService {

	public Iterable<Career> findAll();
	
	public Iterable<String> findAllNames();
	
}
