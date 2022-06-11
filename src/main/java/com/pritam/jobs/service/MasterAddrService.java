package com.pritam.jobs.service;

import java.util.List;

import com.pritam.jobs.model.MasterAddr;

public interface MasterAddrService {

	List<MasterAddr> getAddr(Integer pageNo, Integer pageSize, String sortBy);

	List<MasterAddr> getPincode(Integer pageNo, Integer pageSize, Integer pincode);
}
