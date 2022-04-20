package com.pritam.jobs.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pritam.jobs.model.Address;

@Repository
public interface AddressDao extends CrudRepository<Address, Long> {

}
