package com.pritam.jobs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pritam.jobs.dao.AddressDao;
import com.pritam.jobs.model.Address;

import java.util.ArrayList;
import java.util.List;


@Service(value = "addressService")
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressDao addressDao;

	public List<Address> findAll() {
		List<Address> list = new ArrayList<>();
		addressDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		addressDao.deleteById(id);
	}

	@Override
    public Address save(Address address) {
		System.out.println(address.toString());
        return addressDao.save(address);
    }

	@Override
	public Address find(long id) {
		Address address = addressDao.findById(id).orElse(null);
		if(address == null){
			address = null;
		}
		return address;

	}

	@Override
	public boolean existsById(long id) {
		return addressDao.existsById(id);
	}
}
