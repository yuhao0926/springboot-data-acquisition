package com.dc.acquisition.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dc.acquisition.model.People;

@Mapper
public interface PeopleDao {
	public void insert(People people);
	public List<People> findAll();

    public void update(People user);
    
    public void delete(int id);
}
