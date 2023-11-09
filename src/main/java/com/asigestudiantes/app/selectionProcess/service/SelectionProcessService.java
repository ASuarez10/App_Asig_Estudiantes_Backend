package com.asigestudiantes.app.selectionProcess.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.asigestudiantes.app.model.SelectionProcess;
import com.asigestudiantes.app.model.SelectionProcessExcel;

public interface SelectionProcessService {
	
	public Page<SelectionProcess> getAllSelectionProcesses(int page, int size);
	
	public Optional<SelectionProcess> getSelectionProcessById(long id);
	
	public List<SelectionProcessExcel> convertToExcelFormat(SelectionProcess selectionProcess);
	
	public byte[] generateExcel(List<SelectionProcessExcel> selections);
}
