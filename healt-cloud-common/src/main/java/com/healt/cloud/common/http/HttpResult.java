package com.healt.cloud.common.http;

import lombok.Data;

/**
 * HTTP结果封装
 * @author Louis
 * @date Jan 12, 2019
 */

@Data
public class HttpResult {

	private int code;
	private String msg;
	private Object data;

	//私有构造器，约束外部不允许new
	private HttpResult(){

	}

	public static HttpResult ok(Object data) {
		return restResult(HttpStatus.SUCCESS.getStatus(), HttpStatus.SUCCESS.getMessage(), data);
	}

	public static HttpResult ok(String msg, Object data){
		return restResult(HttpStatus.SUCCESS.getStatus(), msg, data);
	}

	public static HttpResult error(int code, String msg) {
		return restResult(code, msg, null);
	}

	public static HttpResult error(int code, String msg, Object data){
		return restResult(code, msg, data);
	}

	private static HttpResult restResult(int code, String msg, Object data){
		HttpResult r = new HttpResult();
		r.setCode(code);
		r.setMsg(msg);
		r.setData(data);
		return r;
	}


}
