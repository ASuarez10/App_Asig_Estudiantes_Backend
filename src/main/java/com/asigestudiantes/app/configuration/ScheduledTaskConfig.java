package com.asigestudiantes.app.configuration;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import com.asigestudiantes.app.candidate.component.ScheduledTask;
import com.asigestudiantes.app.candidate.service.CandidateService;

@Configuration
public class ScheduledTaskConfig {
	
	//@Autowired
	//private CandidateService candidateService;

	@Bean
	public ScheduledTask scheduledTask() {
		return new ScheduledTask();
	}
	
	
	
	@Scheduled(cron = "0 * * * * *") //Execute every minute.
	public void executeTask() {
		LocalDateTime now = LocalDateTime.now();
		int hour = now.getHour();
		int minute = now.getMinute();
		System.out.println("The time is now: "+hour+":"+minute);
		System.out.println("Scheduled time storaged: "+scheduledTask().getScheduleTime());
		if(scheduledTask().getScheduleTime() != null) {
			if(scheduledTask().getScheduleTime().equals(hour+":"+minute) ) {
				scheduledTask().run();
			}
		}
	}
	
}
