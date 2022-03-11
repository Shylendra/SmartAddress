package com.smartapps.smartaddress.web.service.facade;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.smartapps.smartaddress.jpa.dto.AddressDto;
import com.smartapps.smartaddress.jpa.entities.Address;
import com.smartapps.smartaddress.jpa.util.SmartAddressJpaUtil;
import com.smartapps.smartlib.util.SmartLibraryUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class AddressServiceFacadeImpl extends CommonServiceFacade implements AddressServiceFacade {

	@Override
	public AddressDto register(AddressDto obj) throws JsonProcessingException {
		log.info(String.format(" %s = register() REQUEST: %n %s ", SmartAddressJpaUtil.LOGPREFIX_SMART_ADDRESS_JPA,
				SmartLibraryUtil.mapToString(obj, true)));
		Address entityObj = SmartLibraryUtil.map(obj, Address.class);
		entityObj.setAddressLine1(entityObj.getAddressLine1() + "_VERSION_2");
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
		
		log.info(String.format(" %s = register() RESPONSE: %n %s ", SmartAddressJpaUtil.LOGPREFIX_SMART_ADDRESS_JPA,
				response));
		return response;
	}

	@Override
	public List<AddressDto> retrieveAll() throws JsonProcessingException {
		log.info(String.format(" %s = retrieveAll(): ", SmartAddressJpaUtil.LOGPREFIX_SMART_ADDRESS_JPA));
		
		List<AddressDto> objList = new ArrayList<>();
		List<Address> entityObjList = addressService.readAll();
		for(Address entityObj: entityObjList) {
			objList.add(SmartLibraryUtil.map(entityObj, AddressDto.class));
		}
		log.info(String.format(" %s = retrieveAll() RESPONSE: %n %s ", SmartAddressJpaUtil.LOGPREFIX_SMART_ADDRESS_JPA,
				SmartLibraryUtil.mapToString(objList, true)));
		return objList;
	}

	@Override
	public AddressDto retrieveById(Integer id) {
		log.info(String.format(" %s = retrieveById(%s): ", SmartAddressJpaUtil.LOGPREFIX_SMART_ADDRESS_JPA,
				id));
		
		AddressDto response = SmartLibraryUtil.map(addressService.readById(id), AddressDto.class);
		
		log.info(String.format(" %s = retrieveById(%s) RESPONSE: %n %s ", SmartAddressJpaUtil.LOGPREFIX_SMART_ADDRESS_JPA, id,
				response));
		return response;
	}

	@Override
	public List<AddressDto> retrieveByCustomerId(Integer custId) throws JsonProcessingException {
		log.info(String.format(" %s = retrieveByCustomerId(%s): ", SmartAddressJpaUtil.LOGPREFIX_SMART_ADDRESS_JPA,
				custId));
		
		List<AddressDto> objList = new ArrayList<>();
		List<Address> entityObjList = addressService.readByCustomerId(custId);
		for(Address entityObj: entityObjList) {
			objList.add(SmartLibraryUtil.map(entityObj, AddressDto.class));
		}
		log.info(String.format(" %s = retrieveByCustomerId(%s) RESPONSE: %n %s ", SmartAddressJpaUtil.LOGPREFIX_SMART_ADDRESS_JPA, custId,
				SmartLibraryUtil.mapToString(objList, true)));
		return objList;
	}

	@Override
	public AddressDto update(AddressDto obj) throws JsonProcessingException {
		log.info(String.format(" %s = update() REQUEST: %n %s ", SmartAddressJpaUtil.LOGPREFIX_SMART_ADDRESS_JPA,
				SmartLibraryUtil.mapToString(obj, true)));
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
		
		log.info(String.format(" %s = update() RESPONSE: %n %s ", SmartAddressJpaUtil.LOGPREFIX_SMART_ADDRESS_JPA,
				response));
		return response;
	}

	@Override
	public void deleteById(Integer id) {
		log.info(String.format(" %s = deleteById(%s): ", SmartAddressJpaUtil.LOGPREFIX_SMART_ADDRESS_JPA,
				id));
		addressService.deleteById(id);
	}

}
