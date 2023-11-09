package com.asigestudiantes.app.selection.service;

import java.util.List;

import com.asigestudiantes.app.model.Selection;

public interface SelectionService {
	public List<Selection> findByIdProcess(long id_selection_process);
}
