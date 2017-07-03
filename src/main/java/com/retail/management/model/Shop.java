package com.retail.management.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.springframework.context.annotation.Scope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "shopdetails")
@JsonIgnoreProperties(ignoreUnknown = true)
@Scope(value = "request")
public class Shop {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("shopNumber")
	@Column(name="shop_Number")
	private int shopNumber;
	@JsonProperty("shopName")
	@Column(name="shop_name")
	private String shopName;
	@Embedded
	@JsonProperty("shopAddress")
	private Address shopAddress;
	@Version
	private int version;
	
	@NotNull
	@JsonProperty("latitude")
	@Column(name = "latitude")
	private Double latitude;
	
	@NotNull
	@JsonProperty("longitude")
	@Column(name = "longitude")
	private Double longitude;

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Address getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(Address shopAddress) {
		this.shopAddress = shopAddress;
	}

	public Shop(String shopName, Address shopAddress) {
		this.shopName = shopName;
		this.shopAddress = shopAddress;
	}

	public Shop(int shopNumber, String shopName, Address shopAddress) {
		super();
		this.shopNumber = shopNumber;
		this.shopName = shopName;
		this.shopAddress = shopAddress;
	}

	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getShopNumber() {
		return shopNumber;
	}

	
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Shop [shopNumber=" + shopNumber + ", shopName=" + shopName + ", shopAddress=" + shopAddress
				+ ", version=" + version + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	

}
