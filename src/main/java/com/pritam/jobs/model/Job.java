package com.pritam.jobs.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class Job implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private Users user;
	
	private List<Address> address;
	
	private List<Education> education;

}
