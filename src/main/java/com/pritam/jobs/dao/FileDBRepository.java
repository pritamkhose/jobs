package com.pritam.jobs.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pritam.jobs.storage.FileDB;

@Repository
public interface FileDBRepository extends CrudRepository<FileDB, Long> {

}
