package com.smartapps.smartaddress.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.smartapps.smartaddress.shared","com.smartapps.smartaddress.jpa","com.smartapps.smartaddress.web"})
@SpringBootApplication
public class SmartaddressApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartaddressApplication.class, args);
	}

}
