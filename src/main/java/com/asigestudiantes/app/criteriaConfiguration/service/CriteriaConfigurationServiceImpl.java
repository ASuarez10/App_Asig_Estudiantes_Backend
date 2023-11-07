package com.asigestudiantes.app.criteriaConfiguration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asigestudiantes.app.criteriaConfiguration.repository.CriteriaConfigurationRepository;
import com.asigestudiantes.app.model.CriteriaConfiguration;

@Service
public class CriteriaConfigurationServiceImpl implements CriteriaConfigurationService{

	@Autowired
	private CriteriaConfigurationRepository confRepository;
	
	@Override
	public void saveConfiguration(List<CriteriaConfiguration> confs) {
		confRepository.saveAll(confs);
	}

	@Override
	public void deleteByAutomatized(int isAutomatized) {
		confRepository.deleteByAutomatized(isAutomatized);
	}

}
