package com.pritam.jobs.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	@NotNull
	@Size(min = 1, max = 50, message = "firstName field must be at least 1 and max 50 characters")
	private String firstName;

	@Column
	@NotNull
	@Size(min = 1, max = 50, message = "lastName field must be at least 1 and max 50 characters")
	private String lastName;

	@Column
	@NotNull
	@Size(min = 1, max = 50, message = "emailID field must be at least 1 and max 50 characters")
	private String emailID;

	@Column
	@NotNull
	@Pattern(regexp = "(^$|[0-9]{10})", message = "mobileNo should be exact 10 characters.")
	private String mobileNo;

	@Column(name = "created_on")
	@CreationTimestamp
	@JsonIgnore
	private LocalDateTime createdOn;

	@Column
	@Range(min = 0, max = 3, message = "userType field must be at 0 to 3")
	@JsonIgnore
	private int userType = 0;

}
