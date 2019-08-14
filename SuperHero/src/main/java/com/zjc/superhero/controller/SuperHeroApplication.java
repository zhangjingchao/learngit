package com.zjc.superhero.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.zjc.superhero.controller"})
public class SuperHeroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperHeroApplication.class, args);
	}

}
