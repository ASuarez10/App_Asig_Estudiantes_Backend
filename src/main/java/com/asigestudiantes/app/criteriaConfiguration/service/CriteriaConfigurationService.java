package com.asigestudiantes.app.criteriaConfiguration.service;

import java.util.List;

import com.asigestudiantes.app.model.CriteriaConfiguration;

public interface CriteriaConfigurationService {
	public void saveConfiguration(List<CriteriaConfiguration> confs);
	
	public void deleteByAutomatized(int isAutomatized);
}
