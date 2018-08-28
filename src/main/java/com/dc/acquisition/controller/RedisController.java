package com.dc.acquisition.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.dc.acquisition.bean.Redis;
import com.dc.acquisition.bean.Result;
import com.dc.acquisition.dao.RedisDao;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    RedisDao redisDao;

    @RequestMapping("/set") //1演示设置字符及对象。
    public Result set() {
    	Result result = new Result();
        Redis red = new Redis("1", "aaa", 16);
        Redis red2 = new Redis("2", "bbb", 17);
        Redis red3 = new Redis("3", "ccc", 18);
        Redis red4 = new Redis("4", "ddd", 19);
        Redis red5 = new Redis("5", "eee", 20);
        redisDao.save(red);
        redisDao.save(red2);
        redisDao.save(red3);
        redisDao.save(red4);
        redisDao.save(red5);
        redisDao.stringRedisTemplateDemo();
        return result;
    }

    @RequestMapping("/getStr") //2演示获得字符。
    public Result getStr() {
    	Result result = new Result();
    	JSONObject json = new JSONObject();
    	json.put("result", redisDao.getString());
    	result.setRows(json);
        return result;
    }

    @RequestMapping("/getObj") //3演示获得对象。
    public Result getPerson() {
    	Result result = new Result();
    	result.setRows(redisDao.getRedis());
        return result;
    }
    @RequestMapping("/delObj") //3演示获得对象。
    public Result delKey() {
    	Result result = new Result();
    	JSONObject json = new JSONObject();
    	json.put("result", redisDao.delKey("1"));
    	result.setRows(json);
        return result;
    }
}
