package com.pritam.jobs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pritam.jobs.model.Address;

@Repository
public interface AddressDao extends CrudRepository<Address, Long> {

	@Query("from Address where refID=:refID")
	public List<Address> findRefID(Long refID);

	@Modifying
	@Query("delete from Address where refID=:refID")
	public void deleteByRefID(long refID);
}
