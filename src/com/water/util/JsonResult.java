package com.water.util;

import java.util.HashMap;
import java.util.Map;

import com.water.constant.Constant;

public class JsonResult {
	/**
	 * json 数据返回成功 
	 * @param object
	 * @return
	 */
	public static Map<String, Object> JsonResultOk (Object object) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		String code = Constant.SysCode.JSON_SUCCESS_CODE; 
		jsonMap.put(code, object);
		return jsonMap;
	}
	/**
	 * json 数据返回失败
	 * @param object
	 * @return
	 */
	public static Map<String, Object> JsonResultError (Object object) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		String code = Constant.SysCode.JSON_ERROR_CODE; 
		jsonMap.put(code, object);
		return jsonMap;
	}
}
