package com.asigestudiantes.app.headquarter.service;

import com.asigestudiantes.app.model.Headquarter;

public interface HeadquarterService {

	public Iterable<Headquarter> findAll();
	
	public Iterable<String> findAllNames();
	
}
