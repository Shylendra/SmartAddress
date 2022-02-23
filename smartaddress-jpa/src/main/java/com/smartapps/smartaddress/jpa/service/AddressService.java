package com.smartapps.smartaddress.jpa.service;

import java.util.List;
import java.util.Optional;

import com.smartapps.smartaddress.jpa.entities.Address;

public interface AddressService {
	
	/* Create */
	public Optional<Address> create(final Address obj);
	
	/* Read */
	public List<Address> readAll();
	public Address readById(final Integer id);
	public List<Address> readByCustomerId(final Integer custId);
	
	/* Update */
	public Optional<Address> update(final Address obj);
	
	/* Delete */
	public void deleteById(final Integer id);

}
