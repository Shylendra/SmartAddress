package com.smartapps.smartaddress.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartapps.smartaddress.jpa.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
