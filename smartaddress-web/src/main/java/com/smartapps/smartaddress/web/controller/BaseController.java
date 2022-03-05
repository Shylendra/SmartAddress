package com.smartapps.smartaddress.web.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.smartapps.smartaddress.web.service.facade.AddressServiceFacade;
import com.smartapps.smartlib.service.ClientDetailsService;

public class BaseController {

	@Autowired
	protected ClientDetailsService clientDetailsService;
	
	@Autowired
	protected AddressServiceFacade addressServiceFacade;

}
