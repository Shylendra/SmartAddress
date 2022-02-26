package com.smartapps.smartaddress.jpa.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.smartapps.smartlib.util.SmartDateUtil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SMART_ADDRESS")
public class Address implements Serializable, BaseEntity<Address> {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "CUSTOMER_ID")
	private int customerId;
	
	@Column(name = "ADDRESS_LINE1")
	private String addressLine1;
	
	@Column(name = "ADDRESS_LINE2")
	private String addressLine2;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name = "POSTAL_CODE")
	private String postalCode;

	@Column(name = "START_DATE")
	private Date startDate = SmartDateUtil.getCurrentSystemDate();

	@Column(name = "END_DATE")
	private Date endDate = SmartDateUtil.getCurrentSystemDate();

	@Column(name = "PROC_TS")
	private Timestamp procTs = SmartDateUtil.getCurrentSystemTimestamp();

}
