package com.smartapps.smartaddress.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartapps.smartaddress.jpa.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
	List<Address> findAllByOrderByProcTsDesc();
	List<Address> findByCustomerIdOrderByProcTsDesc(final int customerId);
	List<Address> findByCustomerIdAndProcApprIdOrderByProcTsDesc(final int customerId, final String appId);
}
