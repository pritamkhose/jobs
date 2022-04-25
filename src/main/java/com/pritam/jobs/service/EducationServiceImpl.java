package com.pritam.jobs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pritam.jobs.dao.EducationDao;
import com.pritam.jobs.model.Education;

import java.util.ArrayList;
import java.util.List;

@Service(value = "educationService")
public class EducationServiceImpl implements EducationService {

	@Autowired
	private EducationDao educationDao;

	public List<Education> findAll() {
		List<Education> list = new ArrayList<>();
		educationDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		educationDao.deleteById(id);
	}

	@Override
	public void deleteByRefID(long refID) {
		educationDao.deleteByRefID(refID);
	}

	@Override
	public Education save(Education education) {
		return educationDao.save(education);
	}

	@Override
	public Education find(long id) {
		Education education = educationDao.findById(id).orElse(null);
		if (education == null) {
			education = null;
		}
		return education;

	}

	@Override
	public boolean existsById(long id) {
		return educationDao.existsById(id);
	}

	@Override
	public List<Education> findRefID(Long id) {
		List<Education> list = new ArrayList<>();
		System.out.println(list);
		educationDao.findRefID(id).iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public List<Education> saveList(List<Education> education, long refID) {
		for (Education edu : education) {
			edu.setRefID(refID);
		}
		educationDao.saveAll(education);
		List<Education> list = new ArrayList<>();
		educationDao.findRefID(refID).iterator().forEachRemaining(list::add);
		return list;
	}

}
