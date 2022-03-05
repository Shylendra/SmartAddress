package com.smartapps.smartaddress.jpa.dto;

import java.io.Serializable;
import java.sql.Date;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smartapps.smartlib.dto.CommonDto;
import com.smartapps.smartlib.util.SmartDateUtil;

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
	
}
