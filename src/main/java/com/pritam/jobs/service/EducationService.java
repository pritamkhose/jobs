package com.pritam.jobs.service;

import java.util.List;

import com.pritam.jobs.model.Education;

public interface EducationService {

	Education save(Education education);

	List<Education> findAll();

	Education find(long id);

	void delete(long id);

	boolean existsById(long id);

	List<Education> findRefID(Long id);

}
