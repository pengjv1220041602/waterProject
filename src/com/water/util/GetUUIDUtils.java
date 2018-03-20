package com.water.util;

import java.util.UUID;

public class GetUUIDUtils {
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
