package com.asigestudiantes.app.criterion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asigestudiantes.app.criterion.repository.CriterionRepository;
import com.asigestudiantes.app.model.Criterion;
import com.asigestudiantes.app.model.Headquarter;

@Service
public class CriterionServiceImpl implements CriterionService{

	@Autowired
	private CriterionRepository criterionRepository;
	
	@Override
	public Iterable<Criterion> findAllCriteriaJPQL() {
		return criterionRepository.findAllCriteriaJPQL();
	}

//	@Override
//	public Iterable<Headquarter> findAllHeadquarterJPQL() {
//		return criterionRepository.findAllHeadquarterJPQL();
//	}

}
