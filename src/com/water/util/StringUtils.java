package com.water.util;

/**
 * 字符串使用
 * @author zhangpj
 *
 */
public class StringUtils {
	
	public static boolean isBlank(String s) {
		return s == null ||"".equals(s.trim());
	}
}
