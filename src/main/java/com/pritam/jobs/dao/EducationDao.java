package com.pritam.jobs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pritam.jobs.model.Education;

@Repository
public interface EducationDao extends CrudRepository<Education, Long> {

	@Query("from Education where refID=:refID")
	public List<Education> findRefID(Long refID);

	@Modifying
	@Query("delete from Education where refID=:refID")
	public void deleteByRefID(long refID);
}
