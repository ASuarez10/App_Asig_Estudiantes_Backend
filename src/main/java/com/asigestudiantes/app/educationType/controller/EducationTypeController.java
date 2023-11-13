package com.asigestudiantes.app.educationType.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asigestudiantes.app.educationType.service.EducationTypeService;
import com.asigestudiantes.app.model.Education_type;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("educationTypes")
@CrossOrigin(origins = "http://localhost:4200")
public class EducationTypeController {

	@Autowired
	private EducationTypeService etService;
	
	//Get a list of education types
	@Operation(summary = "Get a list of education types names")
	@GetMapping("/names")
	public List<String> readAllEducationTypeNames(){
		
		List<String> eTypesNames = ((List<String>)etService.findAllNames());
		return eTypesNames;
	}
	
}
