package com.smartapps.smartaddress.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartapps.smartaddress.shared.dto.AddressDto;
import com.smartapps.smartaddress.web.util.SmartAddressWebUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Validated
@RequestMapping(SmartAddressWebUtil.CONTEXT_ROOT)
public class SmartAddressController extends BaseController {

	/* Read - Read all */
	@GetMapping(SmartAddressWebUtil.RETRIEVE_ADDRESSES)
	public ResponseEntity<List<AddressDto>> retrieveAddresses() {
		return ResponseEntity.ok().body(prepareAddresses(20));
	}

	private List<AddressDto> prepareAddresses(int count) {
		List<AddressDto> addresses = new ArrayList<>();
		for(int i=0;i<=count;i++) {
			addresses.add(prepareAddress(i));
		}
		return addresses;
	}
	
	private AddressDto prepareAddress(int id) {

		return AddressDto.builder()
				.id(id)
				.customerId(id+1)
				.addressLine1("addressLine"+id)
				.addressLine2("addressLine"+ (id +1))
				.city("city"+id)
				.state("state"+id)
				.country("country"+id)
				.postalCode("postalCode"+id).build();
				
	}
}
