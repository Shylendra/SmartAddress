package com.smartapps.smartaddress.web.util;

public class SmartAddressWebUtil {

	/* Controller Settings */
	public static final String CONTEXT_ROOT = "/smartaddress-api/";

	public static final String REGISTER_ADDRESS_OPERATION = "Register address";
	public static final String REGISTER_ADDRESS = "api/addresses";
	
	public static final String RETRIEVE_ADDRESSES_OPERATION = "Retrieve addresses";
	public static final String RETRIEVE_ADDRESSES = "api/addresses";
	
	public static final String RETRIEVE_ADDRESS_OPERATION = "Retrieve address by id";
	public static final String RETRIEVE_ADDRESS = "api/addresses/{id}";
	
	public static final String RETRIEVE_CUSTOMER_ADDRESSES_OPERATION = "Retrieve addresses by customer id";
	public static final String RETRIEVE_CUSTOMER_ADDRESSES = "api/addresses/customer/{custId}";
	
	public static final String RETRIEVE_CUSTOMER_APPID_ADDRESSES_OPERATION = "Retrieve addresses by customer id and appId";
	public static final String RETRIEVE_CUSTOMER_APPID_ADDRESSES = "api/addresses/customer/{custId}/appid/{appId}";
	
	public static final String UPDATE_ADDRESS_OPERATION = "Update address";
	public static final String UPDATE_ADDRESS = "api/addresses/{id}";
	
	public static final String DELETE_ADDRESS_OPERATION = "Delete address by id";
	public static final String DELETE_ADDRESS = "api/addresses/{id}";
	
	public static final String DELETE_ADDRESS_BY_CUSTID_OPERATION = "Delete address by customer id";
	public static final String DELETE_ADDRESS_BY_CUSTID = "api/addresses/customer/{custId}";
	
	public static final String DELETE_ADDRESS_BY_CUSTIDS_OPERATION = "Delete address by customer id list";
	public static final String DELETE_ADDRESS_BY_CUSTIDS = "api/addresses/customer/bulk-delete";

	private SmartAddressWebUtil() {
	}

}
