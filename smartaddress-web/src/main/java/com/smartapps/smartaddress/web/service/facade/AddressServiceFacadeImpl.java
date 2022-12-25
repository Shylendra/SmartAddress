package com.smartapps.smartaddress.web.service.facade;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

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

		Address reqEntityObj = assembler.mapToEntity(obj);
		Address resEntityObj = addressService.create(reqEntityObj).get();
		if(resEntityObj != null) {
			AddressDto resObj = assembler.mapToDto(resEntityObj);
			log.info(messageService.getMessage(
					SharedMessages.LOG003_RESPONSE, 
					new Object[]{
							this.getClass().getSimpleName(), 
							new Object(){}.getClass().getEnclosingMethod().getName(),
							resObj}));
			return resObj;
		}
		
		return null;
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
			objList.add(assembler.mapToDto(entityObj));
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

		Address entityObj = addressService.readById(id);
		if(entityObj != null) {
			AddressDto resObj = assembler.mapToDto(entityObj);

			log.info(messageService.getMessage(
					SharedMessages.LOG003_RESPONSE, 
					new Object[]{
							this.getClass().getSimpleName(), 
							new Object(){}.getClass().getEnclosingMethod().getName(),
							resObj}));
			return resObj;
		}
		return null;
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
			objList.add(assembler.mapToDto(entityObj));
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

		Address entityObj = addressService.readById(obj.getId());
		if(entityObj != null) {
			assembler.mapToEntityForUpdate(entityObj, obj);
			Address resEntityObj = addressService.update(entityObj).get();
			AddressDto resObj = assembler.mapToDto(resEntityObj);
			log.info(messageService.getMessage(
					SharedMessages.LOG003_RESPONSE, 
					new Object[]{
							this.getClass().getSimpleName(), 
							new Object(){}.getClass().getEnclosingMethod().getName(),
							resObj}));
			return resObj;
		}
		return null;
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
