package com.pritam.jobs.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="pincode")
@Data
public class MasterAddr implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private int ID;

	@Column
	@NotNull
	@Range(min = 99999, max = 1000000, message = "pincode field must be at least 6 characters")
	private int Pincode;

	@Column
	@NotNull
	private String CircleName;

	@Column
	@NotNull
	@JsonIgnore
	private String RegionName;
	
	@Column
	@NotNull
	private String DivisionName;

	@Column
	@NotNull
	private String OfficeName;
	
	@Column
	@NotNull
	@JsonIgnore
	private String OfficeType;

	@Column
	@NotNull
	@JsonIgnore
	private String Delivery;
	
	@Column
	@NotNull
	private String District;

	@Column
	@NotNull
	private String StateName;
	
	@Column
	@NotNull
	private String Latitude;

	@Column
	@NotNull
	private String Longitude;

}
