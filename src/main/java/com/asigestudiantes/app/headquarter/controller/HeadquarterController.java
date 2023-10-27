package com.asigestudiantes.app.headquarter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asigestudiantes.app.headquarter.service.HeadquarterService;
import com.asigestudiantes.app.model.Headquarter;

@RestController
@RequestMapping("headquarters")
@CrossOrigin(origins = "http://localhost:4200")
public class HeadquarterController {

	@Autowired
	private HeadquarterService headquarterService;
	
	//Get all headquarters
	@GetMapping
	public List<Headquarter> readAllHeadquarters(){
		List<Headquarter> headquarters = ((List<Headquarter>)headquarterService.findAll());
		return headquarters;
	}
	
	//Get all headquarters names
	@GetMapping("/names")
	public List<String> readAllHeadquartersNames(){
		List<String> headquartersNames = ((List<String>)headquarterService.findAllNames());
		return headquartersNames;
	}
	
}
