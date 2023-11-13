package com.asigestudiantes.app.candidate.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asigestudiantes.app.model.Candidate;

import io.swagger.v3.oas.annotations.Operation;

import com.asigestudiantes.app.candidate.component.ScheduledTask;
import com.asigestudiantes.app.candidate.service.CandidateService;

@RestController
@RequestMapping("candidates")
@CrossOrigin(origins = "http://localhost:4200")
public class CandidateController {

	@Autowired
	private CandidateService candidateService;
	
	@Autowired
	private ScheduledTask scheduledTaskService;
	
	//Create multiple candidates
	@Operation(summary = "Create multiple candidates from a list of candidates")
	@PostMapping("/saveCandidates")
	public ResponseEntity<?> createMultipleCandidates(@RequestBody List<Candidate> candidates){
		try {
			candidateService.saveCandidates(candidates);
			return ResponseEntity.ok().build();
		}catch(Exception e){
			e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                             .body("An error ocurred while trying to save the candidates");
		}
	}
	
	//Get all cities from candidates
	@Operation(summary = "Get all cities from candidates")
	@GetMapping("/cities")
	public List<String> readAllCandidatesCities(){
		List<String> cities = candidateService.findDistinctCities();
		return cities;
	}
	
	//Get all cities from candidates
	@Operation(summary = "Get all cities from candidates")
	@GetMapping("/estates")
	public List<String> readAllCandidatesEstates(){
		List<String> estates = candidateService.findDistinctEstates();
		return estates;
	}
	
	//Get all cities from candidates
	@Operation(summary = "Get all cities from candidates")
	@GetMapping("/sexes")
	public List<String> readAllCandidatesSexes(){
		List<String> sexes = candidateService.findDistinctSexes();
		return sexes;
	}
	
	//Endpoint to execute the selection process manually
	@Operation(summary = "Executes the selection process manually")
	@PostMapping("/executeSelectionProcess")
	public ResponseEntity<?> executeSelectionProcess() {
		candidateService.executeSelectionProcess(0);
		return ResponseEntity.ok().build();
	}
	
	//Endpoint to schedule the selection process
	@Operation(summary = "Schedule the selection process")
	@PostMapping("/scheduleSelectionProcess")
	public ResponseEntity<?> scheduleSelectionProcess(@RequestBody Map<String, String> request) {
		LocalDateTime now = LocalDateTime.now();
		int hour = now.getHour();
		int minute = now.getMinute();
		System.out.println("Hora actual: "+hour+":"+minute);
		System.out.println("Hora de ejecucion programada: "+request.get("executionTime"));
		String executionTime = request.get("executionTime");
		scheduledTaskService.setScheduleTime(executionTime);
		
		return ResponseEntity.ok().build();
	}
}
