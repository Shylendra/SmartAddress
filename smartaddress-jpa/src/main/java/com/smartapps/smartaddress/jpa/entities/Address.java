package com.smartapps.smartaddress.jpa.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.smartapps.smartlib.converter.TrimConverter;
import com.smartapps.smartlib.entities.CommonEntity;
import com.smartapps.smartlib.util.SmartDateUtil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SMART_ADDRESS")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class Address extends CommonEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "CUSTOMER_ID")
	private String customerId;
	
	@Column(name = "ADDRESS_TYPE")
	@Convert(converter = TrimConverter.class)
	private String addressType;
	
	@Column(name = "ADDRESS_LINE1")
	@Convert(converter = TrimConverter.class)
	private String addressLine1;
	
	@Column(name = "ADDRESS_LINE2")
	@Convert(converter = TrimConverter.class)
	private String addressLine2;
	
	@Column(name = "CITY")
	@Convert(converter = TrimConverter.class)
	private String city;
	
	@Column(name = "STATE")
	@Convert(converter = TrimConverter.class)
	private String state;
	
	@Column(name = "COUNTRY")
	@Convert(converter = TrimConverter.class)
	private String country;
	
	@Column(name = "POSTAL_CODE")
	@Convert(converter = TrimConverter.class)
	private String postalCode;

	@Column(name = "START_DATE")
	private Date startDate = SmartDateUtil.getCurrentSystemDate();

	@Column(name = "END_DATE")
	private Date endDate = SmartDateUtil.getCurrentSystemDate();

}
