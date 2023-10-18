package com.asigestudiantes.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asigestudiantes.app.model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, String> {

}
