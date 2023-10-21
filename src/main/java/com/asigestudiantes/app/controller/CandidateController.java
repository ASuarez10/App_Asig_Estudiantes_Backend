package com.asigestudiantes.app.controller;

import java.util.List;
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
import com.asigestudiantes.app.service.CandidateService;

@RestController
@RequestMapping("candidates")
@CrossOrigin(origins = "http://localhost:4200")
public class CandidateController {

	@Autowired
	private CandidateService candidateService;
	
	//Create multiple candidates
	@PostMapping("/saveCandidates")
	public ResponseEntity<?> createMultipleCandidates(@RequestBody List<Candidate> candidates){
		candidateService.saveCandidates(candidates);
		return ResponseEntity.ok("Successfully saved candidates");
	}
	
	//Create a candidate
	@PostMapping
	public ResponseEntity<?> createCandidate(@RequestBody Candidate candidate){
		return ResponseEntity.status(HttpStatus.CREATED).body(candidateService.save(candidate));
	}
	
	//Find candidate by ID
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable(value="id") String candidateId){
		Optional<Candidate> oCandidate = candidateService.findById(candidateId);
		
		if(oCandidate.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Candidate candidate = oCandidate.get();
		candidate.getHeadquartercareer();
		return ResponseEntity.ok(candidate);
	}
	
	//Delete a candidate by Id
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCandidate(@PathVariable(value="id") String candidateId){
		if(candidateService.findById(candidateId).isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		candidateService.deleteById(candidateId);
		return ResponseEntity.ok().build();
	}
	
	//Delete all the candidates
	@DeleteMapping("/deleteCandidates")
	public ResponseEntity<?> deleteAllCandidates(){
		candidateService.deleteAllCandidates();
		return ResponseEntity.ok().build();
	}
	
	//Get all the candidates (No pageable)
	@GetMapping
	public List<Candidate> readAllCandidates(){
		List<Candidate> candidates = ((List<Candidate>)candidateService.findAll());
		return candidates;
	}
	
}
