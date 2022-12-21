package com.smartapps.smartaddress.web.util;

public class SmartAddressWebUtil {

	/* Controller Settings */
	public static final String CONTEXT_ROOT = "/smartaddress-api/api/";

	public static final String REGISTER_ADDRESS_OPERATION = "Register address";
	public static final String REGISTER_ADDRESS = "addresses";
	
	public static final String RETRIEVE_ADDRESSES_OPERATION = "Retrieve addresses";
	public static final String RETRIEVE_ADDRESSES = "addresses";
	
	public static final String RETRIEVE_ADDRESS_OPERATION = "Retrieve address by id";
	public static final String RETRIEVE_ADDRESS = "addresses/{id}";
	
	public static final String RETRIEVE_CUSTOMER_ADDRESSES_OPERATION = "Retrieve addresses by customer id";
	public static final String RETRIEVE_CUSTOMER_ADDRESSES = "addresses/customer/{custId}";
	
	public static final String UPDATE_ADDRESS_OPERATION = "Update address";
	public static final String UPDATE_ADDRESS = "addresses/{id}";
	
	public static final String DELETE_ADDRESS_OPERATION = "Delete address by id";
	public static final String DELETE_ADDRESS = "addresses/{id}";

	/* OpenAPI Settings */
	public static final String TITLE = CONTEXT_ROOT.replaceAll("/api", "").replaceAll("/", "");
	public static final String DESCRIPTION = "SmartAddress REST API Information";
	public static final String VERSION = "1.0.0";

	private SmartAddressWebUtil() {
	}

}
