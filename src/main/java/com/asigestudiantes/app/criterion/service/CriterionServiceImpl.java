package com.asigestudiantes.app.criterion.service;

import java.util.List;

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

	@Override
	public Criterion saveCriterion(Criterion criterion) {
		return criterionRepository.save(criterion);
	}

	@Override
	public void saveAllCriteria(List<Criterion> criteria) {
		criterionRepository.saveAll(criteria);
	}

//	@Override
//	public Iterable<Headquarter> findAllHeadquarterJPQL() {
//		return criterionRepository.findAllHeadquarterJPQL();
//	}

}
