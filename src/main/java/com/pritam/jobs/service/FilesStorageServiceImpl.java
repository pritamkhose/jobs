package com.pritam.jobs.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.pritam.jobs.dao.FileDBRepository;
import com.pritam.jobs.storage.FileDB;

@Service
public class FilesStorageServiceImpl implements FilesStorageService {
	private final Path root = Paths.get("uploads");

	@Autowired
	private FileDBRepository fileDBRepository;

	public FileDB storeDB(MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		FileDB FileDB = new FileDB(fileName, file.getContentType(), fileName, file.getBytes(), null, null);
		return fileDBRepository.save(FileDB);
	}

	public FileDB getFileDB(String id) {
		return fileDBRepository.findById(id).get();
	}

	public Stream<FileDB> getAllFilesDB() {
		return fileDBRepository.findAll().stream();
	}
	
	public void deleteFileDB(String id) {
		 fileDBRepository.deleteById(id);
	}


	@Override
	public void init() {
		try {
			Files.createDirectory(root);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize folder for upload!");
		}
	}

	@Override
	public void save(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		}
	}

	@Override
	public Resource load(String filename) {
		try {
			Path file = root.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("Could not read the file!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
	}

	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(root.toFile());
	}

	@Override
	public Stream<Path> loadAll() {
		try {
			return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
		} catch (IOException e) {
			throw new RuntimeException("Could not load the files!");
		}
	}

	@Override
	public ArrayList<String> logSaver() {
		ArrayList<String> al = new ArrayList<>();
		try {
			File source = new File("./AppLogs/log.log");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String dateString = simpleDateFormat.format(new Date());
			File dest = new File("./AppLogs/log-" + dateString + ".log");
			// copy source to target using Files Class
			Files.copy(source.toPath(), dest.toPath());

			// only folder file
			File folder = new File("./AppLogs/");
			File[] listOfFiles = folder.listFiles();
			System.out.println(listOfFiles);
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					al.add(listOfFiles[i].getName());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			al.add("failed");
			al.add(e.getMessage());
		}
		return al;
	}

	@Override
	public Boolean delete(String filename) {
		try {
			Path file = root.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return Files.deleteIfExists(file);
			} else {
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}
}
