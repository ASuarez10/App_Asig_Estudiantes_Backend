package com.asigestudiantes.app.criteriaConfiguration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asigestudiantes.app.criteriaConfiguration.service.CriteriaConfigurationService;
import com.asigestudiantes.app.model.CriteriaConfiguration;

@RestController
@RequestMapping("criteria-conf")
@CrossOrigin(origins = "http://localhost:4200")
public class CriteriaConfigurationController {

	@Autowired
	private CriteriaConfigurationService confService;
	
	@PostMapping("/saveConfs")
	public ResponseEntity<?> saveAllConfs(@RequestBody List<CriteriaConfiguration> confs){
		try {
			confService.saveConfiguration(confs);
			return ResponseEntity.ok().build();
		}catch(Exception e){
			e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                             .body("An error ocurred while trying to save the configurations");
		}
	}
	
	@DeleteMapping("/deleteByAutomatized/{is_automatized}")
	public ResponseEntity<?> deleteConfsByAutomatized(@PathVariable(value="is_automatized") String isAutomatized){
		confService.deleteByAutomatized(Integer.parseInt(isAutomatized));
		return ResponseEntity.ok().build();
	}
}
