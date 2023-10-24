package com.asigestudiantes.app.candidate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.asigestudiantes.app.model.Candidate;
import com.asigestudiantes.app.candidate.repository.CandidateRepository;

@Service
public class CandidateServiceImpl implements CandidateService{

	@Autowired
	private CandidateRepository candidateRepository;
	
	@Override
	public Iterable<Candidate> findAll() {
		return candidateRepository.findAll();
	}

	@Override
	public Page<Candidate> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Candidate> findById(String id) {
		return candidateRepository.findById(id);
	}

	@Override
	public Candidate save(Candidate candidate) {
		return candidateRepository.save(candidate);
	}

	@Override
	public void saveCandidates(List<Candidate> candidates) {
		candidateRepository.saveAll(candidates);
	}

	@Override
	public void deleteById(String id) {
		candidateRepository.deleteById(id);
	}

	@Override
	public void deleteAllCandidates() {
		candidateRepository.deleteAll();
	}

	@Override
	public List<String> findDistinctCities() {
		return candidateRepository.listDistinctCities();
	}

	@Override
	public List<String> findDistinctEstates() {
		return candidateRepository.listDistinctEstates();
	}

	@Override
	public List<String> findDistinctSexes() {
		return candidateRepository.listDistinctSexes();
	}

}
