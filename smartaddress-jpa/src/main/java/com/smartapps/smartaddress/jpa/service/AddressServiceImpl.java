package com.smartapps.smartaddress.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartapps.smartaddress.jpa.entities.Address;
import com.smartapps.smartaddress.jpa.repository.AddressRepository;
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
		if(entityObj.isPresent()) {
			return entityObj.get();
		}
		
		return null;
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
	public List<Address> readByCustomerIdAndAppId(Integer custId, String appId) {
		log.info(messageService.getMessage(
				SharedMessages.LOG001_PREFIX, 
				new Object[]{
						this.getClass().getSimpleName(), 
						new Object(){}.getClass().getEnclosingMethod().getName()}));
		return repository.findByCustomerIdAndProcApprId(custId, appId);
	}

	@Override
	public Optional<Address> update(Address obj) {
		log.info(messageService.getMessage(
				SharedMessages.LOG001_PREFIX, 
				new Object[]{
						this.getClass().getSimpleName(), 
						new Object(){}.getClass().getEnclosingMethod().getName()}));
		return Optional.of(repository.save(obj));
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
