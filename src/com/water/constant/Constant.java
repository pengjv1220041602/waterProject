package com.water.constant;

import java.io.File;

public class Constant {
	//删除标志
	public static final String DEL_FLAG = "0";
	//存在标志
	public static final String EXIST_FLAG = "1";
	
	public static final String PIC_SAVE = File.separator+"imgpro"+File.separator;
	
	//管理员与用户
	public static final String ADMIN_AUTH = "1";
	public static final String USER_AUTH = "0";
	
	//系统错误码
	public static class SysCode {
		public static final String EXCEPTION_CODE = "500";
		public static final String NO_FOUND_CODE = "400";
		public static final String JSON_ERROR_CODE = "406";
		public static final String JSON_SUCCESS_CODE = "200";
	}
	
	
	
	//对应的父节点常量
	public static class SysNodeConstant {
		//默认父节点为1
		public static final String PID = "1";
	}
	
	public static class TbCouponsConstant {
		//自发
		public static final String ZI_FA = "0";
		//抢购
		public static final String QIANG_GOU = "1";
	}
}
