package com.smartapps.smartaddress.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.smartapps.smartaddress.jpa.dto.AddressDto;
import com.smartapps.smartaddress.web.util.SmartAddressWebUtil;
import com.smartapps.smartlib.annotations.GlobalApiReponses;
import com.smartapps.smartlib.annotations.GlobalApiReponsesDelete;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Validated
@RequestMapping(SmartAddressWebUtil.CONTEXT_ROOT)
public class SmartAddressController extends CommonController {

	@Operation(summary = SmartAddressWebUtil.REGISTER_ADDRESS_OPERATION)
	@GlobalApiReponses
	@PostMapping(SmartAddressWebUtil.REGISTER_ADDRESS)
	public ResponseEntity<AddressDto> register(
			@Parameter(name = "registerAddress", description = "JSON with AddressDto object in and out", required = true) @Valid @RequestBody AddressDto address) 
			throws JsonProcessingException {
		return ResponseEntity.ok().body(addressServiceFacade.register(address));
	}

	@Operation(summary = SmartAddressWebUtil.RETRIEVE_ADDRESSES_OPERATION)
	@GlobalApiReponses
	@GetMapping(SmartAddressWebUtil.RETRIEVE_ADDRESSES)
	public ResponseEntity<List<AddressDto>> retrieveAll(HttpServletRequest request) 
			throws IOException, GeoIp2Exception {
		return ResponseEntity.ok().body(addressServiceFacade.retrieveAll());
	}

	@Operation(summary = SmartAddressWebUtil.RETRIEVE_ADDRESS_OPERATION)
	@GlobalApiReponses
	@GetMapping(SmartAddressWebUtil.RETRIEVE_ADDRESS)
	public ResponseEntity<AddressDto> retrieveById(
			@PathVariable("id") @Valid Integer id) {
		return ResponseEntity.ok().body(addressServiceFacade.retrieveById(id));
	}

	@Operation(summary = SmartAddressWebUtil.RETRIEVE_CUSTOMER_ADDRESSES_OPERATION)
	@GlobalApiReponses
	@GetMapping(SmartAddressWebUtil.RETRIEVE_CUSTOMER_ADDRESSES)
	public ResponseEntity<List<AddressDto>> retrieveByCustomerId(
			@PathVariable("custId") @Valid Integer custId) throws JsonProcessingException {
		return ResponseEntity.ok().body(addressServiceFacade.retrieveByCustomerId(custId));
	}

	@Operation(summary = SmartAddressWebUtil.UPDATE_ADDRESS_OPERATION)
	@GlobalApiReponses
	@PutMapping(SmartAddressWebUtil.UPDATE_ADDRESS)
	public ResponseEntity<AddressDto> update(
			@PathVariable("id") @Valid Integer id,
			@Parameter(name = "updateAddress", description = "JSON with AddressDto object in and out", required = true) @Valid @RequestBody AddressDto address) 
			throws JsonProcessingException {
			address.setId(id);
		return ResponseEntity.ok().body(addressServiceFacade.update(address));
	}

	@Operation(summary = SmartAddressWebUtil.DELETE_ADDRESS_OPERATION)
	@GlobalApiReponsesDelete
	@DeleteMapping(SmartAddressWebUtil.DELETE_ADDRESS)
	public ResponseEntity<String> deleteById(
			@PathVariable("id") @Valid Integer id)
			throws JsonProcessingException {
		addressServiceFacade.deleteById(id);
		return ResponseEntity.ok().body("DELETED");
	}
	
}
