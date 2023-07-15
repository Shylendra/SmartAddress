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
		return repository.findAllByOrderByProcTsDesc();
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
	public List<Address> readByCustomerId(String custId) {
		log.info(messageService.getMessage(
				SharedMessages.LOG001_PREFIX, 
				new Object[]{
						this.getClass().getSimpleName(), 
						new Object(){}.getClass().getEnclosingMethod().getName()}));
		return repository.findByCustomerIdOrderByProcTsDesc(custId);
	}

	@Override
	public List<Address> readByCustomerIdAndAppId(String custId, String appId) {
		log.info(messageService.getMessage(
				SharedMessages.LOG001_PREFIX, 
				new Object[]{
						this.getClass().getSimpleName(), 
						new Object(){}.getClass().getEnclosingMethod().getName()}));
		return repository.findByCustomerIdAndProcAppIdOrderByProcTsDesc(custId, appId);
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

	@Override
	public void deleteByCustomerId(String customerId) {
		log.info(messageService.getMessage(
				SharedMessages.LOG001_PREFIX, 
				new Object[]{
						this.getClass().getSimpleName(), 
						new Object(){}.getClass().getEnclosingMethod().getName()}));
		List<Address> custAddresses = repository.findByCustomerIdOrderByProcTsDesc(customerId);
		if(custAddresses != null && !custAddresses.isEmpty()) {
			repository.deleteByCustomerId(customerId);
		}
	}

	@Override
	public void deleteByCustomerIdIn(List<String> customerIds) {
		log.info(messageService.getMessage(
				SharedMessages.LOG001_PREFIX, 
				new Object[]{
						this.getClass().getSimpleName(), 
						new Object(){}.getClass().getEnclosingMethod().getName()}));
		repository.deleteByCustomerIdIn(customerIds);
	}

}
