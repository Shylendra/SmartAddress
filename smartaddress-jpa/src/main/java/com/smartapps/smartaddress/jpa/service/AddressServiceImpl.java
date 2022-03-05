package com.smartapps.smartaddress.jpa.service;

import java.util.List;
import java.util.Optional;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartapps.smartaddress.jpa.entities.Address;
import com.smartapps.smartaddress.jpa.repository.AddressRepository;
import com.smartapps.smartaddress.jpa.util.SmartAddressJpaUtil;
import com.smartapps.smartlib.exception.ResourceNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Optional<Address> create(Address obj) {
		log.info(String.format(" %s = create()", SmartAddressJpaUtil.LOGPREFIX_SMART_ADDRESS_JPA));
		return Optional.of(addressRepository.save(obj));
	}

	@Override
	public List<Address> readAll() {
		return addressRepository.findAll();
	}

	@Override
	public Address readById(Integer id) {
		log.info(String.format(" %s = readById(%s", SmartAddressJpaUtil.LOGPREFIX_SMART_ADDRESS_JPA, id));
		Optional<Address> entityObj = addressRepository.findById(id);
		if(!entityObj.isPresent()) {
			throw new ResourceNotFoundException("Address not found with id = " + id);
		}
		
		return entityObj.get();
	}

	@Override
	public List<Address> readByCustomerId(Integer custId) {
		log.info(String.format(" %s = readByCustomerId(%s", SmartAddressJpaUtil.LOGPREFIX_SMART_ADDRESS_JPA, custId));
		return addressRepository.findByCustomerId(custId);
	}

	@Override
	public Optional<Address> update(Address obj) {
		log.info(String.format(" %s = update()", SmartAddressJpaUtil.LOGPREFIX_SMART_ADDRESS_JPA));
		Address entityObj = readById(obj.getId());
		entityObj.setCustomerId(obj.getCustomerId());
		
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
		
		return Optional.of(addressRepository.save(entityObj));
	}

	@Override
	public void deleteById(Integer id) {
		addressRepository.deleteById(readById(id).getId());
	}

}
