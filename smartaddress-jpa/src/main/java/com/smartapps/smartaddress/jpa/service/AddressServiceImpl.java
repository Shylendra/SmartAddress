package com.smartapps.smartaddress.jpa.service;

import java.util.List;
import java.util.Optional;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartapps.smartaddress.jpa.entities.Address;
import com.smartapps.smartaddress.jpa.repository.AddressRepository;
import com.smartapps.smartlib.exception.ResourceNotFoundException;
import com.smartapps.smartlib.service.MessageService;
import com.smartapps.smartlib.util.SharedMessages;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository repository;
	
	@Autowired
	private MessageService messageService;
	
	private static final String ENTITY_NAME = "Address";

	@Override
	public Optional<Address> create(Address obj) {
		log.info(messageService.getMessage(
				SharedMessages.LOG001_PREFIX, 
				new Object[]{
						this.getClass().getSimpleName(), 
						new Object(){}.getClass().getEnclosingMethod().getName()}));
		return Optional.of(repository.save(obj));
	}

	@Override
	public List<Address> readAll() {
		log.info(messageService.getMessage(
				SharedMessages.LOG001_PREFIX, 
				new Object[]{
						this.getClass().getSimpleName(), 
						new Object(){}.getClass().getEnclosingMethod().getName()}));
		return repository.findAll();
	}

	@Override
	public Address readById(Integer id) {
		log.info(messageService.getMessage(
				SharedMessages.LOG001_PREFIX, 
				new Object[]{
						this.getClass().getSimpleName(), 
						new Object(){}.getClass().getEnclosingMethod().getName()}));
		Optional<Address> entityObj = repository.findById(id);
		if(!entityObj.isPresent()) {
			throw new ResourceNotFoundException(messageService.getMessage(SharedMessages.ERR001_RESOURCE_NOTFOUND, 
					new Object[]{ENTITY_NAME,id}));
		}
		
		return entityObj.get();
	}

	@Override
	public List<Address> readByCustomerId(Integer custId) {
		log.info(messageService.getMessage(
				SharedMessages.LOG001_PREFIX, 
				new Object[]{
						this.getClass().getSimpleName(), 
						new Object(){}.getClass().getEnclosingMethod().getName()}));
		return repository.findByCustomerId(custId);
	}

	@Override
	public Optional<Address> update(Address obj) {
		log.info(messageService.getMessage(
				SharedMessages.LOG001_PREFIX, 
				new Object[]{
						this.getClass().getSimpleName(), 
						new Object(){}.getClass().getEnclosingMethod().getName()}));
		
		Address entityObj = readById(obj.getId());
		entityObj.setCustomerId(obj.getCustomerId());
		
		if(StringUtils.isNotEmpty(obj.getAppId())) {
			entityObj.setAppId(obj.getAppId());
		}
		if(StringUtils.isNotEmpty(obj.getAddressLine1())) {
			entityObj.setAddressLine1(obj.getAddressLine1());
		}
		if(StringUtils.isNotEmpty(obj.getAddressLine2())) {
			entityObj.setAddressLine2(obj.getAddressLine2());
		}
		if(StringUtils.isNotEmpty(obj.getCity())) {
			entityObj.setCity(obj.getCity());
		}
		if(StringUtils.isNotEmpty(obj.getState())) {
			entityObj.setState(obj.getState());
		}
		if(StringUtils.isNotEmpty(obj.getCountry())) {
			entityObj.setCountry(obj.getCountry());
		}
		if(StringUtils.isNotEmpty(obj.getPostalCode())) {
			entityObj.setPostalCode(obj.getPostalCode());
		}
		if(StringUtils.isNotEmpty(obj.getLatitude())) {
			entityObj.setLatitude(obj.getLatitude());
		}
		if(StringUtils.isNotEmpty(obj.getLongitude())) {
			entityObj.setLongitude(obj.getLongitude());
		}
		
		return Optional.of(repository.save(entityObj));
	}

	@Override
	public void deleteById(Integer id) {
		log.info(messageService.getMessage(
				SharedMessages.LOG001_PREFIX, 
				new Object[]{
						this.getClass().getSimpleName(), 
						new Object(){}.getClass().getEnclosingMethod().getName()}));

		repository.deleteById(readById(id).getId());
	}

}
