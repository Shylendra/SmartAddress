package com.smartapps.smartaddress.web.service.facade;

import org.springframework.beans.factory.annotation.Autowired;

import com.smartapps.smartaddress.jpa.service.AddressService;

public class CommonServiceFacade {

	@Autowired
	protected AddressService addressService;
	
}
