package com.water.service;

import com.water.pojo.TbLogger;

public interface TbLoggerService {
	/**
	 * 插入日志
	 * @param tbLogger
	 * @return
	 */
	public int insertLogger(TbLogger tbLogger);
}
