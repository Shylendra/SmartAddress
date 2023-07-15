package com.smartapps.smartaddress.web.service.facade;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.smartapps.smartlib.dto.AddressDto;

public interface AddressServiceFacade {

	public AddressDto register(final AddressDto obj) throws JsonProcessingException;
	public List<AddressDto> retrieveAll() throws JsonProcessingException;
	public AddressDto retrieveById(final Integer id);
	public List<AddressDto> retrieveByCustomerId(final String custId) throws JsonProcessingException;
	public List<AddressDto> readByCustomerIdAndAppId(final String custId, final String appId) throws JsonProcessingException;
	public AddressDto update(final AddressDto obj) throws JsonProcessingException;
	public void deleteById(final Integer id);
	public void deleteByCustomerId(final String customerId);
	public void deleteByCustomerIdIn(final List<String> customerIds);

}
