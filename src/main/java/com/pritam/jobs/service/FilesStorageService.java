package com.pritam.jobs.service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.pritam.jobs.storage.FileDB;

public interface FilesStorageService {
	public void init();

	public void save(MultipartFile file);

	public Resource load(String filename);

	public void deleteAll();

	public Stream<Path> loadAll();

	public ArrayList<String> logSaver();

	public Boolean delete(String filename);

	public FileDB storeDB(MultipartFile file) throws IOException;

	public List<FileDB> getAllFilesDB();

	public FileDB getFileDB(long id);

	public void deleteFileDB(long id);

	public boolean existsFileById(long id);
}
