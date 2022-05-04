package com.pritam.jobs.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.lang.Nullable;

import lombok.Data;

@Entity
@Data
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	@NotNull
	private long refID;

	@Column
	@NotNull
	@Size(min = 1, max = 30, message = "type field must be at least 1 and max 30 characters")
	private String type;

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
	@Range(min = 99999, max = 1000000, message = "pincode field must be at least 6 characters")
	private int pincode;
}
