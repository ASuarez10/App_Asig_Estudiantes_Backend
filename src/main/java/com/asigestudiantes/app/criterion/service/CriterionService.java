package com.asigestudiantes.app.criterion.service;

import com.asigestudiantes.app.model.Criterion;
import com.asigestudiantes.app.model.Headquarter;

public interface CriterionService {

	Iterable<Criterion> findAllCriteriaJPQL();
	
//	Iterable<Headquarter> findAllHeadquarterJPQL();
	
}
