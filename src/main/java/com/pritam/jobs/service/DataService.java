package com.pritam.jobs.service;

import java.util.List;

import com.pritam.jobs.model.Data;

public interface DataService {

    Data save(Data data);
    List<Data> findAll();
    Data find(long id);
    void delete(long id);
    boolean existsById(long id);
}
