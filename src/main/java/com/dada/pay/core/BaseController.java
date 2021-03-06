package com.dada.pay.core;

import com.dada.pay.core.Response;

public abstract class BaseController {
	
	public Response success(Object data) {
		return Response.success(data);
	}
	
	public Response fail(int status,String msg) {
		return Response.fail(status , msg);
	}

}
