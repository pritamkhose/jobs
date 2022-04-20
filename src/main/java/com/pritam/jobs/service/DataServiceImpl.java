package com.pritam.jobs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pritam.jobs.dao.DataDao;
import com.pritam.jobs.model.Data;

import java.util.ArrayList;
import java.util.List;


@Service(value = "dataService")
public class DataServiceImpl implements DataService {
	
	@Autowired
	private DataDao dataDao;

	public List<Data> findAll() {
		List<Data> list = new ArrayList<>();
		dataDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		dataDao.deleteById(id);
	}

	@Override
    public Data save(Data data) {
        return dataDao.save(data);
    }

	@Override
	public Data find(long id) {
		Data data = dataDao.findById(id).orElse(null);
		if(data == null){
			data = null;
		}
		return data;

	}

	@Override
	public boolean existsById(long id) {
		return dataDao.existsById(id);
	}
}
