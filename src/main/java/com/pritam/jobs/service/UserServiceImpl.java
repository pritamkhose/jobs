package com.pritam.jobs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pritam.jobs.dao.UsersDao;
import com.pritam.jobs.model.Users;

import java.util.ArrayList;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersDao aDao;

	public List<Users> findAll() {
		List<Users> list = new ArrayList<>();
		aDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		aDao.deleteById(id);
	}

	@Override
	public Users save(Users Users) {
		return aDao.save(Users);
	}

	@Override
	public Users find(long id) {
		Users Users = aDao.findById(id).orElse(null);
		if (Users == null) {
			Users = null;
		}
		return Users;

	}

	@Override
	public boolean existsById(long id) {
		return aDao.existsById(id);
	}

	@Override
	public boolean existsByUser(Users user) {
		List<Users> u = aDao.existsByUser(user.getEmailID(), user.getMobileNo());
		System.out.println(u);
		if (u.size() > 0) {
			return true;
		}
		return false;
	}
}
