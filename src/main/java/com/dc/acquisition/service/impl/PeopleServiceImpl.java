package com.dc.acquisition.service.impl;

import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dc.acquisition.bean.Result;
import com.dc.acquisition.dao.PeopleDao;
import com.dc.acquisition.model.People;

@Service("peopleService")
public class PeopleServiceImpl {
	@Resource
	PeopleDao peopleDao;
	private static Logger log = LoggerFactory.getLogger(PeopleServiceImpl.class);
	
	public Result findAllPeople(){
		if (log.isInfoEnabled()){
			log.info("start findAllPeople");
		}
		Result result = new Result();
		List<People> records = peopleDao.findAll();
		result.setRows(records);
		result.setTotal(records.size());
		return result;
	}

	public void addPeople() {
		People people = new People();
		Random random = new Random();
		String randomStr = String.valueOf(random.nextInt(100));
		if (log.isInfoEnabled()){
			log.info("start addPeople,"+randomStr);
		}
		people.setPersonId(randomStr);
		people.setFirstName("first_"+randomStr);
		people.setLastName("last_"+randomStr);
		peopleDao.insert(people);
	}
}
