package com.asigestudiantes.app.candidate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.asigestudiantes.app.model.Candidate;

public interface CandidateService {

	public Iterable<Candidate> findAll();
	
	public Page<Candidate> findAll(Pageable pageable);
	
	public Optional<Candidate> findById(String id);
	
	public Candidate save(Candidate candidate);
	
	public void saveCandidates(List<Candidate> candidates);
	
	public void deleteById(String id);
	
	public void deleteAllCandidates();
	
	public List<String> findDistinctCities();
	
	public List<String> findDistinctEstates();
	
	public List<String> findDistinctSexes();
}
