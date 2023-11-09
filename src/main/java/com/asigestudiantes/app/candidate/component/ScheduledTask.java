package com.asigestudiantes.app.candidate.component;

import java.time.LocalDateTime;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asigestudiantes.app.candidate.service.CandidateService;

@Component
public class ScheduledTask extends TimerTask{
	
	@Autowired
	private CandidateService candidateService;
	
	private String scheduleTime;

	@Override
	public void run() {
		
		System.out.println("Entra en run()");
		
		this.candidateService.executeSelectionProcess(1);
		System.out.println("Selection process executed succesfully");
		this.scheduleTime = null;
	}
	
	public void setScheduleTime(String time) {
		this.scheduleTime = time;
	}

	public String getScheduleTime() {
		return this.scheduleTime;
	}
	
}
