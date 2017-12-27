package com.hxy.timing.timingdome;

import com.hxy.timing.timingdome.mail.MailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TimingDomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimingDomeApplication.class, args);
	}
	@Bean
	public MailService mailService(){
		return new MailService();
	}
	@Bean
	public VelocityEngine get(){
		return new VelocityEngine();
	}
}
