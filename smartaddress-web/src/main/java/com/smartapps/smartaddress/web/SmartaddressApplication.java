package com.smartapps.smartaddress.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableCaching
@SpringBootApplication
@EnableEurekaClient
public class SmartaddressApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartaddressApplication.class, args);
	}

}
