package com.asigestudiantes.app.career.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asigestudiantes.app.career.service.CareerService;
import com.asigestudiantes.app.model.Career;

@RestController
@RequestMapping("careers")
@CrossOrigin(origins = "http://localhost:4200")
public class CareerController {

	@Autowired
	private CareerService careerService;
	
	@GetMapping
	public List<Career> readAllCareers(){
		List<Career> careers = ((List<Career>)careerService.findAll());
		return careers;
	}
	
	@GetMapping("/names")
	public List<String> readAllCareersNames(){
		List<String> careersNames = ((List<String>)careerService.findAllNames());
		return careersNames;
	}
	
}
