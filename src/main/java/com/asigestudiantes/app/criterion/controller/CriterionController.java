package com.asigestudiantes.app.criterion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping
	public ResponseEntity<?> saveCriterion(@RequestBody Criterion criterion){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(criterionService.saveCriterion(criterion));
		}catch(Exception e){
			e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                             .body("An error ocurred while trying to save the criterion");
		}
	}
	
	@PostMapping("/saveAllCriteria")
	public ResponseEntity<?> saveAllCriterion(@RequestBody List<Criterion> criteria){
		try {
			criterionService.saveAllCriteria(criteria);;
			return ResponseEntity.ok().build();
		}catch(Exception e){
			e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                             .body("An error ocurred while trying to save the criterion");
		}
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
