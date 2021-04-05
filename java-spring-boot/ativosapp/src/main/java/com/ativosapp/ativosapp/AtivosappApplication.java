package com.ativosapp.ativosapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"controllers"})
public class AtivosappApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtivosappApplication.class, args);
	}

}
