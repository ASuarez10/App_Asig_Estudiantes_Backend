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
		
		LocalDateTime now = LocalDateTime.now();
		
		int hour = now.getHour();
		int minute = now.getMinute();
		
		//TODO condicion para comparar si ya es la hora para ejecutar y si hay una hora programada
		if(this.scheduleTime != null) {
			if(this.scheduleTime == hour+":"+minute) {
				this.candidateService.executeSelectionProcess(1);
				this.scheduleTime = null;
			}
		}

	}
	
	public void setScheduleTime(String time) {
		this.scheduleTime = time;
	}

}
