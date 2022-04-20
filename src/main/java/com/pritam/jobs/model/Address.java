package com.pritam.jobs.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.lang.Nullable;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	@NotNull
    @Size(min = 4, max = 50, message = "addrLine1 field must be at least 4 and max 50 characters")
    private String addrLine1;
	
	@Column
	@NotNull
	@Size(min = 1, max = 50, message = "addrLine2 field must be at least 1 and max 50 characters")
    private String addrLine2;
    

	@Column
	@Nullable
	@Length(max = 50, message = "landmark field must be less than 50 characters")
	private String landmark;

	@Column
	@NotNull
	@Size(min = 1, max = 30, message = "city field must be at least 1 and max 30 characters")
	private String city;

	@Column
	@NotNull
	@Size(min = 1, max = 30, message = "district field must be at least 1 and max 30 characters")
	private String district;

	@Column
	@NotNull
	@Size(min = 1, max = 30, message = "state field must be at least 1 and max 30 characters")
	private String state;

	@Column
	@NotNull
	@Size(min = 1, max = 30, message = "country field must be at least 1 and max 30 characters")
	private String country;

	@Column
	@NotNull
	@Range(min= 99999, max= 1000000, message = "These field must be at least 6 characters")
	private int pincode;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddrLine1() {
		return addrLine1;
	}

	public void setAddrLine1(String addrLine1) {
		this.addrLine1 = addrLine1;
	}

	public String getAddrLine2() {
		return addrLine2;
	}

	public void setAddrLine2(String addrLine2) {
		this.addrLine2 = addrLine2;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
}
