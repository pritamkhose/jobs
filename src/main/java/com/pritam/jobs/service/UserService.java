package com.pritam.jobs.service;

import java.util.List;

import com.pritam.jobs.model.Users;

public interface UserService {

	Users save(Users data);

	List<Users> findAll();

	Users find(long id);

	void delete(long id);

	boolean existsById(long id);

	boolean existsByUser(Users user);

}
