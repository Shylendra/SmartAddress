package com.smartapps.smartaddress.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.smartapps.smartlib.service.ClientDetailsService;
import com.smartapps.smartlib.service.ClientDetailsServiceImpl;
import com.smartapps.smartlib.service.CsvService;
import com.smartapps.smartlib.service.CsvServiceImpl;
import com.smartapps.smartlib.service.MessageService;
import com.smartapps.smartlib.service.MessageServiceImpl;

@Configuration
public class SharedServicesConfig {
	
	@Bean
	public CsvService csvService() {
		return new CsvServiceImpl();
	}
	
	@Bean
	public ClientDetailsService clientDetailsService() {
		return new ClientDetailsServiceImpl();
	}

	@Bean
	public MessageService messageService() {
		return new MessageServiceImpl();
	}

}
