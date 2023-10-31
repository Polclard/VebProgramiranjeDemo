package com.example.vebprogramiranjedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class VebProgramiranjeDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VebProgramiranjeDemoApplication.class, args);
	}

}
