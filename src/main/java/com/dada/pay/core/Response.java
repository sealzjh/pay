package com.dada.pay.core;


public class Response {
	private Integer status;
	private String msg;
	private Object data;

	public Response(Integer status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
	
	public static Response success(Object data){
		return new Response(0, null, data);
	}
	
	public static Response fail(String msg){
		return new Response(1, msg, null);
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
