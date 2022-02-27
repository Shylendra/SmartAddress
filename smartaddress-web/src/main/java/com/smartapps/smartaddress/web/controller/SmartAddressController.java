package com.smartapps.smartaddress.web.controller;

import java.util.List;

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
import com.smartapps.smartaddress.jpa.dto.AddressDto;
import com.smartapps.smartaddress.web.util.SmartAddressWebUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Validated
@RequestMapping(SmartAddressWebUtil.CONTEXT_ROOT)
public class SmartAddressController extends BaseController {

	@Operation(summary = "Register address")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully retrieved."), 
			@ApiResponse(responseCode = "400", description = "Bad request."),
			@ApiResponse(responseCode = "401", description = "You are not authorized to access the resource."),
			@ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden."),
			@ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found.")})
	@PostMapping(SmartAddressWebUtil.REGISTER_ADDRESS)
	public ResponseEntity<AddressDto> register(
			@Parameter(name = "registerAddress", description = "JSON with AddressDto object in and out", required = true) @Valid @RequestBody AddressDto address) 
			throws JsonProcessingException {
		return ResponseEntity.ok().body(addressServiceFacade.register(address));
	}

	@Operation(summary = "Retrieve addresses")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully retrieved."), 
			@ApiResponse(responseCode = "400", description = "Bad request."),
			@ApiResponse(responseCode = "401", description = "You are not authorized to access the resource."),
			@ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden."),
			@ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found.")})
	@GetMapping(SmartAddressWebUtil.RETRIEVE_ADDRESSES)
	public ResponseEntity<List<AddressDto>> retrieveAll() 
			throws JsonProcessingException {
		return ResponseEntity.ok().body(addressServiceFacade.retrieveAll());
	}

	@Operation(summary = "Retrieve address by id")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully retrieved."), 
			@ApiResponse(responseCode = "400", description = "Bad request."),
			@ApiResponse(responseCode = "401", description = "You are not authorized to access the resource."),
			@ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden."),
			@ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found.")})
	@GetMapping(SmartAddressWebUtil.RETRIEVE_ADDRESS)
	public ResponseEntity<AddressDto> retrieveById(
			@PathVariable("id") @Valid Integer id) {
		return ResponseEntity.ok().body(addressServiceFacade.retrieveById(id));
	}

	@Operation(summary = "Retrieve addresses by customer id")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully retrieved."), 
			@ApiResponse(responseCode = "400", description = "Bad request."),
			@ApiResponse(responseCode = "401", description = "You are not authorized to access the resource."),
			@ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden."),
			@ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found.")})
	@GetMapping(SmartAddressWebUtil.RETRIEVE_CUSTOMER_ADDRESSES)
	public ResponseEntity<List<AddressDto>> retrieveByCustomerId(
			@PathVariable("custId") @Valid Integer custId) throws JsonProcessingException {
		return ResponseEntity.ok().body(addressServiceFacade.retrieveByCustomerId(custId));
	}

	@Operation(summary = "Update address")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully retrieved."), 
			@ApiResponse(responseCode = "400", description = "Bad request."),
			@ApiResponse(responseCode = "401", description = "You are not authorized to access the resource."),
			@ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden."),
			@ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found.")})
	@PutMapping(SmartAddressWebUtil.UPDATE_ADDRESS)
	public ResponseEntity<AddressDto> update(
			@PathVariable("id") @Valid Integer id,
			@Parameter(name = "updateAddress", description = "JSON with AddressDto object in and out", required = true) @Valid @RequestBody AddressDto address) 
			throws JsonProcessingException {
			address.setId(id);
		return ResponseEntity.ok().body(addressServiceFacade.update(address));
	}

	@Operation(summary = "Delete address by id")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully retrieved."), 
			@ApiResponse(responseCode = "400", description = "Bad request."),
			@ApiResponse(responseCode = "401", description = "You are not authorized to access the resource."),
			@ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden."),
			@ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found.")})
	@DeleteMapping(SmartAddressWebUtil.DELETE_ADDRESS)
	public ResponseEntity<String> deleteById(
			@PathVariable("id") @Valid Integer id)
			throws JsonProcessingException {
		addressServiceFacade.deleteById(id);
		return ResponseEntity.ok().body("DELETED");
	}
	
}
