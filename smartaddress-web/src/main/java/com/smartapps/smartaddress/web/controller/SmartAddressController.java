package com.smartapps.smartaddress.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.jboss.logging.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.smartapps.smartaddress.jpa.dto.AddressDto;
import com.smartapps.smartaddress.web.util.SmartAddressWebUtil;
import com.smartapps.smartlib.annotations.GlobalApiReponsesDelete;
import com.smartapps.smartlib.annotations.GlobalApiReponsesGet;
import com.smartapps.smartlib.annotations.GlobalApiReponsesPost;
import com.smartapps.smartlib.annotations.GlobalApiReponsesPut;
import com.smartapps.smartlib.util.SmartHttpUtil;
import com.smartapps.smartlib.validators.annotations.ValidAppId;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RestController
@Validated
@RequestMapping(SmartAddressWebUtil.CONTEXT_ROOT)
public class SmartAddressController extends CommonController {

	@Operation(summary = SmartAddressWebUtil.REGISTER_ADDRESS_OPERATION)
	@GlobalApiReponsesPost
	@PostMapping(SmartAddressWebUtil.REGISTER_ADDRESS)
	public ResponseEntity<AddressDto> register(
			@RequestHeader(value = SmartHttpUtil.APP_ID_HEADER, required = true) @ValidAppId String appId,
			@RequestHeader(value = SmartHttpUtil.USER_ID_HEADER, required = true) String userId,
			@RequestHeader(value = SmartHttpUtil.USER_GROUPS_HEADER, required = true) String userGroups,
			@Parameter(name = "registerAddress", description = "JSON with request object in and out", required = true) @Valid @RequestBody AddressDto address,
			HttpServletRequest request) 
			throws JsonProcessingException {
		
		/** Logging **/
		MDC.put(SmartHttpUtil.APP_ID_HEADER, appId);
		MDC.put(SmartHttpUtil.USER_ID_HEADER, userId);
		MDC.put(SmartHttpUtil.USER_GROUPS_HEADER, userGroups);

		address.setProcApprId(appId);
		address.setProcUserId(userId);
		address.setProcUserIpAddress(SmartHttpUtil.getIpAddress(request));
		return ResponseEntity.ok().body(addressServiceFacade.register(address));
	}

	@Operation(summary = SmartAddressWebUtil.RETRIEVE_ADDRESSES_OPERATION)
	@GlobalApiReponsesGet
	@GetMapping(SmartAddressWebUtil.RETRIEVE_ADDRESSES)
	public ResponseEntity<List<AddressDto>> retrieveAll() 
			throws IOException {
		return ResponseEntity.ok().body(addressServiceFacade.retrieveAll());
	}

	@Operation(summary = SmartAddressWebUtil.RETRIEVE_ADDRESS_OPERATION)
	@GlobalApiReponsesGet
	@GetMapping(SmartAddressWebUtil.RETRIEVE_ADDRESS)
	public ResponseEntity<AddressDto> retrieveById(
			@PathVariable("id") @Valid Integer id) {
		return ResponseEntity.ok().body(addressServiceFacade.retrieveById(id));
	}

	@Operation(summary = SmartAddressWebUtil.RETRIEVE_CUSTOMER_ADDRESSES_OPERATION)
	@GlobalApiReponsesGet
	@GetMapping(SmartAddressWebUtil.RETRIEVE_CUSTOMER_ADDRESSES)
	public ResponseEntity<List<AddressDto>> retrieveByCustomerId(
			@PathVariable("custId") @Valid Integer custId) throws JsonProcessingException {
		return ResponseEntity.ok().body(addressServiceFacade.retrieveByCustomerId(custId));
	}

	@Operation(summary = SmartAddressWebUtil.UPDATE_ADDRESS_OPERATION)
	@GlobalApiReponsesPut
	@PutMapping(SmartAddressWebUtil.UPDATE_ADDRESS)
	public ResponseEntity<AddressDto> update(
			@RequestHeader(value = SmartHttpUtil.APP_ID_HEADER, required = true) @ValidAppId String appId,
			@RequestHeader(value = SmartHttpUtil.USER_ID_HEADER, required = true) String userId,
			@RequestHeader(value = SmartHttpUtil.USER_GROUPS_HEADER, required = true) String userGroups,
			@PathVariable("id") @Valid Integer id,
			@Parameter(name = "updateAddress", description = "JSON with request object in and out", required = true) @Valid @RequestBody AddressDto address,
			HttpServletRequest request) 
			throws JsonProcessingException {
		
		/** Logging **/
		MDC.put(SmartHttpUtil.APP_ID_HEADER, appId);
		MDC.put(SmartHttpUtil.USER_ID_HEADER, userId);
		MDC.put(SmartHttpUtil.USER_GROUPS_HEADER, userGroups);

		address.setId(id);
		address.setProcApprId(appId);
		address.setProcUserId(userId);
		address.setProcUserIpAddress(SmartHttpUtil.getIpAddress(request));
		return ResponseEntity.ok().body(addressServiceFacade.update(address));
	}

	@Operation(summary = SmartAddressWebUtil.DELETE_ADDRESS_OPERATION)
	@GlobalApiReponsesDelete
	@DeleteMapping(SmartAddressWebUtil.DELETE_ADDRESS)
	public ResponseEntity<String> deleteById(
			@RequestHeader(value = SmartHttpUtil.APP_ID_HEADER, required = true) @ValidAppId String appId,
			@RequestHeader(value = SmartHttpUtil.USER_ID_HEADER, required = true) String userId,
			@RequestHeader(value = SmartHttpUtil.USER_GROUPS_HEADER, required = true) String userGroups,
			@PathVariable("id") @Valid Integer id) {
		
		/** Logging **/
		MDC.put(SmartHttpUtil.APP_ID_HEADER, appId);
		MDC.put(SmartHttpUtil.USER_ID_HEADER, userId);
		MDC.put(SmartHttpUtil.USER_GROUPS_HEADER, userGroups);

		addressServiceFacade.deleteById(id);
		return ResponseEntity.ok().body("DELETED");
	}
	
}
