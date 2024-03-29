package com.pritam.jobs.controller;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.pritam.jobs.service.FilesStorageService;
import com.pritam.jobs.storage.FileDB;
import com.pritam.jobs.storage.FileInfo;
import com.pritam.jobs.storage.MyFileNotFoundException;
import com.pritam.jobs.storage.ResponseMessage;

@Controller
@CrossOrigin("*")
public class FilesController {
	@Autowired
	FilesStorageService storageService;

	@PostMapping("/upload")
	public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			storageService.save(file);
			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}

	@PostMapping("/uploadMultipleFiles")
	public ResponseEntity<List<ResponseEntity<Object>>> uploadMultipleFiles(
			@RequestParam("files") MultipartFile[] files) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(Arrays.asList(files).stream().map(file -> uploadFile(file)).collect(Collectors.toList()));
	}

	@GetMapping("/files")
	public ResponseEntity<List<FileInfo>> getListFiles() {
		List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
			String filename = path.getFileName().toString();
			String url = MvcUriComponentsBuilder
					.fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();
			return new FileInfo(filename, url);
		}).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
	}

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = storageService.load(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	@DeleteMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Void> deleteFile(@PathVariable String filename) {
		return new ResponseEntity<Void>(storageService.delete(filename) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@GetMapping("/logSaver")
	public ResponseEntity<ArrayList<String>> logSaver() {
		return ResponseEntity.status(HttpStatus.OK).body(storageService.logSaver());
	}

	@GetMapping("/downloadLog/{fileName:.+}")
	public ResponseEntity<Resource> downloadLog(@PathVariable String fileName, HttpServletRequest request) {
		try {
			Path fileStorageLocation = Paths.get("./AppLogs/").toAbsolutePath().normalize();
			Path filePath = fileStorageLocation.resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if (resource.exists()) {
				return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
						"attachment; fileName=\"" + resource.getFilename() + "\"").body(resource);
			} else {
				throw new MyFileNotFoundException("File not found " + fileName);
			}
		} catch (MalformedURLException ex) {
			throw new MyFileNotFoundException("File not found " + fileName, ex);
		}
	}

	@PostMapping("/uploadDB")
	public ResponseEntity<Object> uploadFileDB(@RequestParam("file") MultipartFile file) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(storageService.storeDB(file));
		} catch (Exception e) {
			String message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}

	@GetMapping("/filesDB")
	public ResponseEntity<List<FileDB>> getListFilesDB() {
		return ResponseEntity.status(HttpStatus.OK).body(storageService.getAllFilesDB());
	}

	@GetMapping("/filesDB/{id}")
	public ResponseEntity<byte[]> getFileDB(@PathVariable long id) {
		try {
			FileDB fileDB = storageService.getFileDB(id);
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
					.body(fileDB.getData());
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/filesDB/{id}")
	public ResponseEntity<Void> deleteFileDB(@PathVariable long id) {
		if (storageService.getFileDB(id) != null) {
			storageService.deleteFileDB(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
