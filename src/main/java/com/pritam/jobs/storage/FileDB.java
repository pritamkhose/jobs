package com.pritam.jobs.storage;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Data
@Table(name = "files")
public class FileDB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private long id;

	@Column
	@NotNull
	private String name;

	@Column
	@NotNull
	private String type;

	@Lob
	@Column
	@NotNull
	private byte[] data;

	@Column
	private Boolean active = true;

	@Column(name = "created_on")
	@CreationTimestamp
	@JsonIgnore
	private LocalDateTime createdOn;
}
