package com.pritam.jobs.service;

import java.util.List;

import com.pritam.jobs.model.Education;

public interface EducationService {

	Education save(Education address);

	List<Education> saveList(List<Education> address, long refID);

	List<Education> findAll();

	Education find(long id);

	List<Education> findRefID(Long id);

	boolean existsById(long id);

	void delete(long id);

	void deleteByRefID(long refID);
}
