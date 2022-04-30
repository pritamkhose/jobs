package com.pritam.jobs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pritam.jobs.storage.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
}
