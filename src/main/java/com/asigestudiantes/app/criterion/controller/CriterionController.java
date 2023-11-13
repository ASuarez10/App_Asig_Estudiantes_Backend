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

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("criteria")
@CrossOrigin(origins = "http://localhost:4200")
public class CriterionController {
	
	@Autowired
	private CriterionService criterionService;
	
	//Get all criteria
	@Operation(summary = "Get all criteria records")
	@GetMapping
	public List<Criterion> getAllCriteriaJPQL(){
		
		List<Criterion> criteria = ((List<Criterion>)criterionService.findAllCriteriaJPQL());
		
		return criteria;
		
	}
	
	//Save all the criteria with a list as parameter
	@Operation(summary = "Save all the criteria with a list as parameter")
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

}
