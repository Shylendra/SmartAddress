package com.smartapps.smartaddress.jpa.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smartapps.smartlib.util.SmartDateUtil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto implements Serializable {

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
	private String procTs;

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

	@JsonIgnore
	public Timestamp getSqlProcTs() {
		if(StringUtils.isNotEmpty(procTs)) {
			return SmartDateUtil.parseTimestamp(procTs);
		}
		return SmartDateUtil.getCurrentSystemTimestamp();
	}
	
}
