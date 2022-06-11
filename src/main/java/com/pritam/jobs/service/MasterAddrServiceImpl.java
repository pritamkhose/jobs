package com.pritam.jobs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pritam.jobs.dao.MasterAddrRepository;
import com.pritam.jobs.model.MasterAddr;

import java.util.ArrayList;
import java.util.List;

@Service(value = "masterAddrService")
public class MasterAddrServiceImpl implements MasterAddrService {

	@Autowired
	private MasterAddrRepository repository;

	@Override
	public List<MasterAddr> getAddr(Integer pageNo, Integer pageSize, String sortBy) {
		PageRequest paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<MasterAddr> pagedResult = repository.findAll(paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<MasterAddr>();
		}
	}

	@Override
	public List<MasterAddr> getPincode(Integer pageNo, Integer pageSize, Integer pincode) {
		PageRequest paging = PageRequest.of(pageNo, pageSize, Sort.by("ID"));
		Page<MasterAddr> pagedResult = repository.findAllPincode(paging, pincode);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<MasterAddr>();
		}
	}
}
