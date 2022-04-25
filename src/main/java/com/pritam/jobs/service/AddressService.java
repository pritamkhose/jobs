package com.pritam.jobs.service;

import java.util.List;

import com.pritam.jobs.model.Address;

public interface AddressService {

	Address save(Address address);

	List<Address> saveList(List<Address> address, long refID);

	List<Address> findAll();

	Address find(long id);

	List<Address> findRefID(Long id);

	boolean existsById(long id);

	void delete(long id);

	void deleteByRefID(long refID);
}
