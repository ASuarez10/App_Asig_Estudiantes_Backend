package com.asigestudiantes.app.criterion.service;

import java.util.List;

import com.asigestudiantes.app.model.Criterion;
import com.asigestudiantes.app.model.Headquarter;

public interface CriterionService {

	Iterable<Criterion> findAllCriteriaJPQL();
	
	Criterion saveCriterion(Criterion criterion);
	
	void saveAllCriteria(List<Criterion> criteria);
	
//	Iterable<Headquarter> findAllHeadquarterJPQL();
	
}
