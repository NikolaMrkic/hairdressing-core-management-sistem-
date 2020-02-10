package com.hairdressingmanagementsistem;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HairdressingCoreManagementSistemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HairdressingCoreManagementSistemApplication.class, args);
		System.out.println("Test");
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
