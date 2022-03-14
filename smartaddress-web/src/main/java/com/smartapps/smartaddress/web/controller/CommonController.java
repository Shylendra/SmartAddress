package com.smartapps.smartaddress.web.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.smartapps.smartaddress.web.service.facade.AddressServiceFacade;
import com.smartapps.smartlib.service.ClientDetailsService;
import com.smartapps.smartlib.service.MessageService;

public class CommonController {

	@Autowired
	protected ClientDetailsService clientDetailsService;
	
	@Autowired
	protected AddressServiceFacade addressServiceFacade;

	@Autowired
	protected MessageService messageService;

}
