package com.smartapps.smartaddress.jpa.dto;

import java.io.Serializable;
import java.sql.Date;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.smartapps.smartlib.dto.CommonDto;
import com.smartapps.smartlib.util.SmartDateUtil;
import com.smartapps.smartlib.util.SmartLibraryUtil;
import com.smartapps.smartlib.validators.annotations.ValidAppId;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Address")
public class AddressDto extends CommonDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private int customerId;
	
	@ValidAppId
	private String appId;
	
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String country;
	private String postalCode;
	private String startDate;
	private String endDate;
	private String latitude;
	private String longitude;

	
	@JsonIgnore
	public Date getSqlStartDate() {
		if(StringUtils.isNotEmpty(startDate)) {
			return SmartDateUtil.parseDate(startDate);
		}
		return SmartDateUtil.getCurrentSystemDate();
	}

	@JsonIgnore
	public Date getSqlEndDate() {
		if(StringUtils.isNotEmpty(endDate)) {
			return SmartDateUtil.parseDate(endDate);
		}
		return SmartDateUtil.getCurrentSystemDate();
	}

	@Override
	public String toString() {
		try {
			return SmartLibraryUtil.mapToString(this, true);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
