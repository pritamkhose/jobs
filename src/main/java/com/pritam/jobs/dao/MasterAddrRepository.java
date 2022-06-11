package com.pritam.jobs.dao;

import org.springframework.stereotype.Repository;

import com.pritam.jobs.model.MasterAddr;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
 
@Repository
public interface MasterAddrRepository
        extends PagingAndSortingRepository<MasterAddr, Integer> {

	@Query("from MasterAddr") // where Pincode=:Pincode
	Page<MasterAddr> findAllPincode(PageRequest paging, Integer Pincode);
 
}