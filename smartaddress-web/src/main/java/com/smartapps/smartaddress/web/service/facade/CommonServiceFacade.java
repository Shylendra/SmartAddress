package com.smartapps.smartaddress.web.service.facade;

import org.springframework.beans.factory.annotation.Autowired;

import com.smartapps.smartaddress.jpa.service.AddressService;
import com.smartapps.smartaddress.web.assemblers.SmartAddressAssembler;
import com.smartapps.smartlib.service.MessageService;

public class CommonServiceFacade {

	@Autowired
	protected AddressService addressService;
	
	@Autowired
	protected MessageService messageService;
	
	@Autowired
	protected SmartAddressAssembler assembler;

}
