package com.asigestudiantes.app.criterion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asigestudiantes.app.criterion.service.CriterionService;
import com.asigestudiantes.app.model.Criterion;
import com.asigestudiantes.app.model.Headquarter;

@RestController
@RequestMapping("criteria")
@CrossOrigin(origins = "http://localhost:4200")
public class CriterionController {
	
	@Autowired
	private CriterionService criterionService;
	
	//Get all criteria
	@GetMapping
	public List<Criterion> getAllCriteriaJPQL(){
		
		List<Criterion> criteria = ((List<Criterion>)criterionService.findAllCriteriaJPQL());
		
		return criteria;
		
	}
	
	//Get all criteria
//	@GetMapping
//	public List<Headquarter> getAllHeadquarterJPQL(){
//		
//		List<Headquarter> headquarters = ((List<Headquarter>)criterionService.findAllHeadquarterJPQL());
//		
//		return headquarters;
//		
//	}

}
