/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.luming.common.utils;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import lombok.Data;

/**
 * 返回数据
 *
 * @author Mark sunlightcs@gmail.com
 */
@Data
public class R {
	private static final long serialVersionUID = 1L;

	private  int code;
	private  String msg;
	private  Map<String, Object> data = new HashMap<>();
	
	public R() {
		this.code = 200;
		this.msg = "success";
		this.data = new HashMap<>();
	}
	
	public static R error() {
		return error(500, "未知异常，请联系管理员");
	}
	
	public static R error(String msg) {
		return error(500, msg);
	}
	
	public static R error(int code, String msg) {
		R r = new R();
		r.code = code;
		r.msg = msg;
		return r;
	}

	public static R ok(String msg) {
		R r = new R();
		r.msg = msg;
		r.code = 200;
		return r;
	}
	
	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.data = map;
		r.code = 200;
		r.msg = "success";
		return r;
	}
	
	public static R ok() {
		return new R();
	}

	public R put(String key, Object value) {
		this.data.put(key, value);
		return this;
	}
}
