package com.example.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@Value("${from}")
	String foo;
	@Value("${name}")
	String name;
	@RequestMapping(value = "/hi")
	public String hi(){
		return foo;
	}
	@RequestMapping(value = "/name")
	public String name(){
		return name;
	}
}