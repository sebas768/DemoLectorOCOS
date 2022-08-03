package com.pronaca.osoc.lecturaxml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({ "com.pronaca.osoc.lecturaxml.model.entities" })
public class ApiOsocLecturaxmlApplication {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ApiOsocLecturaxmlApplication.class, args);
	}

}
