package com.smartapps.smartaddress.web.service.facade;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.smartapps.smartaddress.jpa.dto.AddressDto;
import com.smartapps.smartaddress.jpa.entities.Address;
import com.smartapps.smartlib.util.SharedMessages;
import com.smartapps.smartlib.util.SmartLibraryUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class AddressServiceFacadeImpl extends CommonServiceFacade implements AddressServiceFacade {

	@Override
	public AddressDto register(AddressDto obj) throws JsonProcessingException {
		log.info(messageService.getMessage(
				SharedMessages.LOG002_REQUEST, 
				new Object[]{
						this.getClass().getSimpleName(), 
						new Object(){}.getClass().getEnclosingMethod().getName(),
						obj}));

		Address entityObj = SmartLibraryUtil.map(obj, Address.class);
		if(StringUtils.isNotEmpty(obj.getStartDate())) {
			entityObj.setStartDate(obj.getSqlStartDate());
		}
		if(StringUtils.isNotEmpty(obj.getEndDate())) {
			entityObj.setEndDate(obj.getSqlEndDate());
		}
		if(StringUtils.isNotEmpty(obj.getProcTs())) {
			entityObj.setProcTs(obj.getSqlProcTs());
		}
		AddressDto response = SmartLibraryUtil.map(addressService.create(entityObj).get(), AddressDto.class);
		
		log.info(messageService.getMessage(
				SharedMessages.LOG003_RESPONSE, 
				new Object[]{
						this.getClass().getSimpleName(), 
						new Object(){}.getClass().getEnclosingMethod().getName(),
						response}));

		return response;
	}

	@Override
	public List<AddressDto> retrieveAll() throws JsonProcessingException {
		log.info(messageService.getMessage(
				SharedMessages.LOG001_PREFIX, 
				new Object[]{
						this.getClass().getSimpleName(), 
						new Object(){}.getClass().getEnclosingMethod().getName()}));
		
		List<AddressDto> objList = new ArrayList<>();
		List<Address> entityObjList = addressService.readAll();
		for(Address entityObj: entityObjList) {
			objList.add(SmartLibraryUtil.map(entityObj, AddressDto.class));
		}

		log.info(messageService.getMessage(
				SharedMessages.LOG003_RESPONSE, 
				new Object[]{
						this.getClass().getSimpleName(), 
						new Object(){}.getClass().getEnclosingMethod().getName(),
						SmartLibraryUtil.mapToString(objList, true)}));
		
		return objList;
	}

	@Override
	public AddressDto retrieveById(Integer id) {
		log.info(messageService.getMessage(
				SharedMessages.LOG001_PREFIX, 
				new Object[]{
						this.getClass().getSimpleName(), 
						new Object(){}.getClass().getEnclosingMethod().getName()}));

		AddressDto response = SmartLibraryUtil.map(addressService.readById(id), AddressDto.class);

		log.info(messageService.getMessage(
				SharedMessages.LOG003_RESPONSE, 
				new Object[]{
						this.getClass().getSimpleName(), 
						new Object(){}.getClass().getEnclosingMethod().getName(),
						response}));
		return response;
	}

	@Override
	public List<AddressDto> retrieveByCustomerId(Integer custId) throws JsonProcessingException {
		log.info(messageService.getMessage(
				SharedMessages.LOG001_PREFIX, 
				new Object[]{
						this.getClass().getSimpleName(), 
						new Object(){}.getClass().getEnclosingMethod().getName()}));
		
		List<AddressDto> objList = new ArrayList<>();
		List<Address> entityObjList = addressService.readByCustomerId(custId);
		for(Address entityObj: entityObjList) {
			objList.add(SmartLibraryUtil.map(entityObj, AddressDto.class));
		}
		
		log.info(messageService.getMessage(
				SharedMessages.LOG003_RESPONSE, 
				new Object[]{
						this.getClass().getSimpleName(), 
						new Object(){}.getClass().getEnclosingMethod().getName(),
						SmartLibraryUtil.mapToString(objList, true)}));
		return objList;
	}

	@Override
	public AddressDto update(AddressDto obj) throws JsonProcessingException {
		log.info(messageService.getMessage(
				SharedMessages.LOG002_REQUEST, 
				new Object[]{
						this.getClass().getSimpleName(), 
						new Object(){}.getClass().getEnclosingMethod().getName(),
						obj}));

		Address addressToUpdate = SmartLibraryUtil.map(obj, Address.class);
		if(StringUtils.isNotEmpty(obj.getStartDate())) {
			addressToUpdate.setStartDate(obj.getSqlStartDate());
		}
		if(StringUtils.isNotEmpty(obj.getEndDate())) {
			addressToUpdate.setEndDate(obj.getSqlEndDate());
		}
		if(StringUtils.isNotEmpty(obj.getProcTs())) {
			addressToUpdate.setProcTs(obj.getSqlProcTs());
		}
		AddressDto response = SmartLibraryUtil.map(addressService.update(addressToUpdate).get(), AddressDto.class);
		
		log.info(messageService.getMessage(
				SharedMessages.LOG003_RESPONSE, 
				new Object[]{
						this.getClass().getSimpleName(), 
						new Object(){}.getClass().getEnclosingMethod().getName(),
						response}));
		return response;
	}

	@Override
	public void deleteById(Integer id) {
		log.info(messageService.getMessage(
				SharedMessages.LOG001_PREFIX, 
				new Object[]{
						this.getClass().getSimpleName(), 
						new Object(){}.getClass().getEnclosingMethod().getName()}));
		addressService.deleteById(id);
	}

}
