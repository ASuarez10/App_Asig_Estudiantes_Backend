package com.asigestudiantes.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import com.asigestudiantes.app.candidate.component.ScheduledTask;

@Configuration
public class ScheduledTaskConfig {

	@Bean
	public ScheduledTask scheduledTask() {
		return new ScheduledTask();
	}
	
	@Scheduled(cron = "0 * * * * *") //Execute every minute.
	public void executeTask() {
		scheduledTask().run();
	}
	
}
