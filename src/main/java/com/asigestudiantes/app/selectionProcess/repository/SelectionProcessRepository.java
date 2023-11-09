package com.asigestudiantes.app.selectionProcess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asigestudiantes.app.model.SelectionProcess;

@Repository
public interface SelectionProcessRepository extends JpaRepository<SelectionProcess, Long>{

}
