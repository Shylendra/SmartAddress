package com.smartapps.smartaddress.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartapps.smartaddress.jpa.entities.Address;
import com.smartapps.smartaddress.jpa.repository.AddressRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Optional<Address> create(Address obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address readById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> readByCustomerId(Integer custId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Address> update(Address obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
