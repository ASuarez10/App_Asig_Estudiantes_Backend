package com.asigestudiantes.app.selectionProcess.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.asigestudiantes.app.model.Selection;
import com.asigestudiantes.app.model.SelectionProcess;
import com.asigestudiantes.app.model.SelectionProcessExcel;
import com.asigestudiantes.app.selectionProcess.repository.SelectionProcessRepository;

@Service
public class SelectionProcessServiceImpl implements SelectionProcessService{

	@Autowired
	private SelectionProcessRepository spRepository;
	
	@Override
	public Page<SelectionProcess> getAllSelectionProcesses(int page, int size) {
		PageRequest pageable = PageRequest.of(page, size);
		return spRepository.findAll(pageable);
	}

	@Override
	public Optional<SelectionProcess> getSelectionProcessById(long id) {
		return spRepository.findById(id);
	}

	//Method to convert a selection process into a list in excel format sorted by percentage desc and priority asc.
	@Override
	public List<SelectionProcessExcel> convertToExcelFormat(SelectionProcess selectionProcess) {
		
		//Get selection list from selection process
		List<Selection> selections = selectionProcess.getSelection();
		
		//New list to return
		List<SelectionProcessExcel> processExcelList = new ArrayList<SelectionProcessExcel>();
		
		for(Selection selection : selections) {
			
			SelectionProcessExcel spExcel = new SelectionProcessExcel();
			
			//Fields from selection process
			spExcel.setId_process(selectionProcess.getId_process());
			spExcel.setProcess_date(selectionProcess.getProcess_date());
			
			//Fields from candidate
			spExcel.setId_candidate(selection.getCandidate().getId_candidate());
			spExcel.setCandidate_name(selection.getCandidate().getName());
			spExcel.setCandidate_lastname(selection.getCandidate().getLastname());
			spExcel.setCandidate_id_type(selection.getCandidate().getId_type());
			spExcel.setCandidate_sex(selection.getCandidate().getSex());
			spExcel.setCandidate_city(selection.getCandidate().getCity());
			spExcel.setCandidate_estate(selection.getCandidate().getEstate());
			spExcel.setCandidate_icfes_general(selection.getCandidate().getIcfes_general());
			spExcel.setCandidate_age(selection.getCandidate().getAge());
			
			//Fields from headquarter
			spExcel.setHeadquarter_city(selection.getCandidate().getHeadquartercareer().getHeadquarter().getHeadquarter_city());
			
			//Fields from career
			spExcel.setCareer_name(selection.getCandidate().getHeadquartercareer().getCareer().getCareer_name());
			
			//Field from education type
			spExcel.setEducation_type_name(selection.getCandidate().getEducation_type().getEducation_type_name());
			
			//Fields from selection
			spExcel.setPercentage(selection.getPercentage());
			spExcel.setPriority(selection.getPriority());
			
			processExcelList.add(spExcel);
			
		}
		
		Comparator<SelectionProcessExcel> customComparator = Comparator.comparingInt(SelectionProcessExcel::getPercentage)
																		.reversed()
																		.thenComparingInt(SelectionProcessExcel::getPriority);
		
		processExcelList.sort(customComparator);
		
		return processExcelList;
	}

	@Override
	public byte[] generateExcel(List<SelectionProcessExcel> selections) {
		
		//Create excel file .xlsx
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Seleccionados");
		
		Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Nombre");
        headerRow.createCell(2).setCellValue("Apellido");
        headerRow.createCell(3).setCellValue("Tipo de ID");
        headerRow.createCell(4).setCellValue("Sexo");
        headerRow.createCell(5).setCellValue("Ciudad de origen");
        headerRow.createCell(6).setCellValue("Departamento");
        headerRow.createCell(7).setCellValue("Icfes");
        headerRow.createCell(8).setCellValue("Edad");
        headerRow.createCell(9).setCellValue("Ciudad de interes");
        headerRow.createCell(10).setCellValue("Programa de interes");
        headerRow.createCell(11).setCellValue("Tipo de educacion");
        headerRow.createCell(12).setCellValue("Porcentaje");
        headerRow.createCell(13).setCellValue("Prioridad");
		
        int rowNumber = 1;
        
        for(SelectionProcessExcel selection : selections) {
        	Row bodyRow = sheet.createRow(rowNumber++);
        	
        	bodyRow.createCell(0).setCellValue(selection.getId_candidate());
        	bodyRow.createCell(1).setCellValue(selection.getCandidate_name());
        	bodyRow.createCell(2).setCellValue(selection.getCandidate_lastname());
        	bodyRow.createCell(3).setCellValue(selection.getCandidate_id_type());
        	bodyRow.createCell(4).setCellValue(selection.getCandidate_sex());
        	bodyRow.createCell(5).setCellValue(selection.getCandidate_city());
        	bodyRow.createCell(6).setCellValue(selection.getCandidate_estate());
        	bodyRow.createCell(7).setCellValue(selection.getCandidate_icfes_general());
        	bodyRow.createCell(8).setCellValue(selection.getCandidate_age());
        	bodyRow.createCell(9).setCellValue(selection.getHeadquarter_city());
        	bodyRow.createCell(10).setCellValue(selection.getCareer_name());
        	bodyRow.createCell(11).setCellValue(selection.getEducation_type_name());
        	bodyRow.createCell(12).setCellValue(selection.getPercentage());
        	bodyRow.createCell(13).setCellValue(selection.getPriority());
        	
        }
        
        //Convert excel book to bytes
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
        	workbook.write(outputStream);
        	workbook.close();
        }catch(IOException e) {
        	e.printStackTrace();
        }
        
        byte[] excelBytes = outputStream.toByteArray();
        
		return excelBytes;
	}

}
