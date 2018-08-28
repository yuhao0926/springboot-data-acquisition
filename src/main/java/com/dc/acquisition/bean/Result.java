package com.dc.acquisition.bean;

import com.alibaba.fastjson.JSONObject;

/**************
 * 返回结果通用对象
 * */
public class Result {
    private boolean success = false;
    private String msg = "交易完成";
    // private String status = "error";
    private int total;
    private Object rows;

    @Override
    public String toString() {
    	
    	return JSONObject.toJSONString(this);
    }
    public Result() {
    	
    }
    public Result(boolean success,int total) {
    	this.success = success;
    	this.total = total;
    }
    public Result(boolean success,String message) {
    	this.success = success;
    	this.msg = message;
    }
    
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Object getRows() {
        return rows;
    }

    public void setRows(Object rows) {
        this.rows = rows;
    }
}
