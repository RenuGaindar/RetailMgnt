package com.retail.management.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

	@JsonProperty("number")
	@Column(name = "number")
	private int number;
	@JsonProperty("postCode")
	@Column(name = "post_code")
	private String postCode;
	@JsonProperty("address")
	@Column(name = "address")
	private String address;
	
	@JsonProperty("city")
	@Column(name = "city")
	private String city;
	
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	public Address(int number, String postCode, String address, String city) {
		super();
		this.number = number;
		this.postCode = postCode;
		this.address = address;
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [number=" + number + ", postCode=" + postCode + ", address=" + address + ", city=" + city + "]";
	}

	


	
	
}
