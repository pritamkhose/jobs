package com.pritam.jobs.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pritam.jobs.model.Data;

@Repository
public interface DataDao extends CrudRepository<Data, Long> {

}
