package com.water.util;

import java.lang.reflect.Method;
import java.util.Date;

import com.water.constant.Constant;

public class AddOrUpdateUtils {
	private static final String SET_FLAG = "setFlag"; 
	private static final String SET_UPDATE_TIME = "setUpdateTime"; 
	private static final String SET_CREATE_TIME = "setCreateTime"; 
	private static final String SET_UPDATE_USER = "setUpdateUser"; 
	private static final String SET_CREATE_USER = "setCreateUser";
	public static void addOrUpdateUtils (Object object) {
		Class<?> clazz = object.getClass();
		try {
			Method[] methods = clazz.getMethods();
			for (Method method : methods) {
				switch (method.getName()) {
				case SET_FLAG:
					method.invoke(object, Constant.EXIST_FLAG);
					break;
				case SET_UPDATE_TIME:
					method.invoke(object, new Date());
					break;
				case SET_CREATE_TIME:
					method.invoke(object, new Date());
					break;
				case SET_UPDATE_USER:
					method.invoke(object, "admin");
					break;
				case SET_CREATE_USER:
					method.invoke(object, "admin");
					break;
				default:
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
