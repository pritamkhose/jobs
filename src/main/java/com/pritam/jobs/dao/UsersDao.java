package com.pritam.jobs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pritam.jobs.model.Users;

@Repository
public interface UsersDao extends CrudRepository<Users, Long> {

	@Query("from Users where emailID=:emailID and mobileNo=:mobileNo")
	public List<Users> existsByUser(String emailID, String mobileNo);
}
