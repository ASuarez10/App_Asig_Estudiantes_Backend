package com.asigestudiantes.app.selectionProcess.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asigestudiantes.app.model.SelectionProcess;
import com.asigestudiantes.app.model.SelectionProcessExcel;
import com.asigestudiantes.app.selectionProcess.service.SelectionProcessService;

@RestController
@RequestMapping("selection-process")
@CrossOrigin(origins = "http://localhost:4200")
public class SelectionProcessController {
	
	@Autowired
	private SelectionProcessService spService;
	
	@GetMapping
	public Page<SelectionProcess> getSelectionProcesses(@RequestParam(name = "page",defaultValue = "0") int page, @RequestParam(name = "size",defaultValue = "10") int size){
		return spService.getAllSelectionProcesses(page, size);
	}
	
	@GetMapping("/downloadProcess/{id}")
	public ResponseEntity<byte[]> findById(@PathVariable(value="id") long process_id){
		Optional<SelectionProcess> oSP = spService.getSelectionProcessById(process_id);
		
		if(oSP.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		SelectionProcess process = oSP.get();
		
		//List of process records in excel format
		List<SelectionProcessExcel> selectionProcessExcel = spService.convertToExcelFormat(process);
		
		//Excel generated in bytes
		byte[] fileInBytes = spService.generateExcel(selectionProcessExcel);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//MediaType.APPLICATION_OCTET_STREAM indicates that message body has binary data without processing
		headers.setContentDispositionFormData("attachment", "SelectionProcess.xlsx");//File name
		
		return ResponseEntity.ok().headers(headers).body(fileInBytes);
	}
}
