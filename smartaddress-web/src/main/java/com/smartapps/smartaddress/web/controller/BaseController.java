package com.smartapps.smartaddress.web.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.smartapps.smartaddress.web.service.facade.AddressServiceFacade;

public class BaseController {

	@Autowired
	protected AddressServiceFacade addressServiceFacade;

}
