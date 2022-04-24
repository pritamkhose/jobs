package com.pritam.jobs.service;

import java.util.List;

import com.pritam.jobs.model.Address;

public interface AddressService {

	Address save(Address address);

	List<Address> findAll();

	Address find(long id);

	void delete(long id);

	boolean existsById(long id);

	List<Address> findRefID(Long id);
}
