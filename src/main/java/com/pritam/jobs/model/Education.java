package com.pritam.jobs.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import lombok.*;
import lombok.Data;

@Entity
@Data
public class Education implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	@NotNull
	private long refID;

	@Column
	@NotNull
	@Size(min = 1, message = "education field must be at least 1 and max 255 characters")
	private String education;

	@Column
	@NotNull
	@Size(min = 1, message = "course field must be at least 1 and max 255 characters")
	private String course;

	@Column
	@NotNull
	@Size(min = 1, message = "specialization field must be at least 1 and max 255 characters")
	private String specialization;

	@Column
	@NotNull
	@Range(min = 0, max = 3, message = "courseType field must be at 0 to 3")
	private int courseType;

	@Column
	@Size(min = 1, message = "university field must be at least 1 and max 255 characters")
	private String university;

	@Column
	@Size(min = 1, message = "institute field must be at least 1 and max 255 characters")
	private String institute;

	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;

	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;

	@Column
	@NotNull
	@Range(min = 0, max = 3, message = "resultType field must be at 0 to 3")
	private int resultType;

	@Column
	@Size(min = 1, max = 10, message = "result field must be at least 1 and max 10 characters")
	private String result;

	@Column
	@Size(message = "specialization field must be at least 1 and max 255 characters")
	private String remark;

}
