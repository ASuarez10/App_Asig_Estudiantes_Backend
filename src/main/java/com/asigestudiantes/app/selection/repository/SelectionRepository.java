package com.asigestudiantes.app.selection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asigestudiantes.app.model.Selection;

@Repository
public interface SelectionRepository extends JpaRepository<Selection, Long>{

}
