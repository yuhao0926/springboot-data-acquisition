package com.dc.acquisition.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dc.acquisition.bean.Result;
import com.dc.acquisition.service.impl.PeopleServiceImpl;

@RestController
@RequestMapping(value = "/people")
public class PeopleController {

	@Resource
    private PeopleServiceImpl peopleService;
    
     @RequestMapping(value="/add",method = RequestMethod.POST)  
     public Result add(){
    	 Result result = new Result();
    	 peopleService.addPeople();
         return result;
     }  
    
    @RequestMapping(value="/findAll",method = RequestMethod.POST)
    public Result find(){
    	Result result = peopleService.findAllPeople();
    	
        return result;
    }
}
