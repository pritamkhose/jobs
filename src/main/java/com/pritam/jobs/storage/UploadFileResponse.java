package com.pritam.jobs.storage;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class UploadFileResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String fileName;
	private String fileDownloadUri;
	private String fileType;
	private long size;

}
