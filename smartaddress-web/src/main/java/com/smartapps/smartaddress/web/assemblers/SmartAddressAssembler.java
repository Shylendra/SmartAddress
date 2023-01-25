package com.smartapps.smartaddress.web.assemblers;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.stereotype.Component;

import com.smartapps.smartaddress.jpa.entities.Address;
import com.smartapps.smartlib.dto.AddressDto;

@Component
public class SmartAddressAssembler {

	public AddressDto mapToDto(Address entityObj) {
		AddressDto obj = new AddressDto();
		
		obj.setId(entityObj.getId());
		obj.setCustomerId(entityObj.getCustomerId());
		if(StringUtils.isNotEmpty(entityObj.getAddressType())) {
			obj.setAddressType(entityObj.getAddressType());
		}
		if(StringUtils.isNotEmpty(entityObj.getAddressLine1())) {
			obj.setAddressLine1(entityObj.getAddressLine1());
		}
		if(StringUtils.isNotEmpty(entityObj.getAddressLine2())) {
			obj.setAddressLine2(entityObj.getAddressLine2());
		}
		if(StringUtils.isNotEmpty(entityObj.getCity())) {
			obj.setCity(entityObj.getCity());
		}
		if(StringUtils.isNotEmpty(entityObj.getState())) {
			obj.setState(entityObj.getState());
		}
		if(StringUtils.isNotEmpty(entityObj.getCountry())) {
			obj.setCountry(entityObj.getCountry());
		}
		if(StringUtils.isNotEmpty(entityObj.getPostalCode())) {
			obj.setPostalCode(entityObj.getPostalCode());
		}
		if(entityObj.getStartDate() != null) {
			obj.setStartDate(entityObj.getStartDate().toString());
		}
		if(entityObj.getEndDate() != null) {
			obj.setEndDate(entityObj.getEndDate().toString());
		}


		/* Base Entity */
		if(entityObj.getProcTs() != null) {
			obj.setProcTs(entityObj.getProcTs().toString());
		}
		if(StringUtils.isNotEmpty(entityObj.getProcAppId())) {
			obj.setProcAppId(entityObj.getProcAppId());
		}
		if(StringUtils.isNotEmpty(entityObj.getProcUserId())) {
			obj.setProcUserId(entityObj.getProcUserId());
		}
		if(StringUtils.isNotEmpty(entityObj.getProcUserIpAddress())) {
			obj.setProcUserIpAddress(entityObj.getProcUserIpAddress());
		}
		if(StringUtils.isNotEmpty(entityObj.getProcUserLatitude())) {
			obj.setProcUserLatitude(entityObj.getProcUserLatitude());
		}
		if(StringUtils.isNotEmpty(entityObj.getProcUserLongitude())) {
			obj.setProcUserLongitude(entityObj.getProcUserLongitude());
		}
		return obj;
	}

	public Address mapToEntity(AddressDto obj) {
		Address entityObj = new Address();
		
		entityObj.setCustomerId(obj.getCustomerId());
		if(StringUtils.isNotEmpty(obj.getAddressType())) {
			entityObj.setAddressType(obj.getAddressType());
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
		if(entityObj.getStartDate() != null) {
			entityObj.setStartDate(obj.getSqlStartDate());
		}
		if(entityObj.getEndDate() != null) {
			entityObj.setEndDate(obj.getSqlEndDate());
		}

		/* Base Entity */
		if(StringUtils.isNotEmpty(obj.getProcTs())) {
			entityObj.setProcTs(obj.getSqlProcTs());
		}
		if(StringUtils.isNotEmpty(obj.getProcAppId())) {
			entityObj.setProcAppId(obj.getProcAppId());
		}
		if(StringUtils.isNotEmpty(obj.getProcUserId())) {
			entityObj.setProcUserId(obj.getProcUserId());
		}
		if(StringUtils.isNotEmpty(obj.getProcUserIpAddress())) {
			entityObj.setProcUserIpAddress(obj.getProcUserIpAddress());
		}
		if(StringUtils.isNotEmpty(obj.getProcUserLatitude())) {
			entityObj.setProcUserLatitude(obj.getProcUserLatitude());
		}
		if(StringUtils.isNotEmpty(obj.getProcUserLongitude())) {
			entityObj.setProcUserLongitude(obj.getProcUserLongitude());
		}

		return entityObj;
	}
	
	public void mapToEntityForUpdate(Address entityObj, AddressDto obj) {
		
		entityObj.setCustomerId(obj.getCustomerId());
		if(StringUtils.isNotEmpty(obj.getAddressType())) {
			entityObj.setAddressType(obj.getAddressType());
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
		if(entityObj.getStartDate() != null) {
			entityObj.setStartDate(obj.getSqlStartDate());
		}
		if(entityObj.getEndDate() != null) {
			entityObj.setEndDate(obj.getSqlEndDate());
		}

		/* Base Entity */
		if(StringUtils.isNotEmpty(obj.getProcTs())) {
			entityObj.setProcTs(obj.getSqlProcTs());
		}
		if(StringUtils.isNotEmpty(obj.getProcAppId())) {
			entityObj.setProcAppId(obj.getProcAppId());
		}
		if(StringUtils.isNotEmpty(obj.getProcUserId())) {
			entityObj.setProcUserId(obj.getProcUserId());
		}
		if(StringUtils.isNotEmpty(obj.getProcUserIpAddress())) {
			entityObj.setProcUserIpAddress(obj.getProcUserIpAddress());
		}
		if(StringUtils.isNotEmpty(obj.getProcUserLatitude())) {
			entityObj.setProcUserLatitude(obj.getProcUserLatitude());
		}
		if(StringUtils.isNotEmpty(obj.getProcUserLongitude())) {
			entityObj.setProcUserLongitude(obj.getProcUserLongitude());
		}
	}

}
