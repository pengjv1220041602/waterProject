package com.water.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggerRecord {
	public void loggerAround (JoinPoint joinPoint) {
		//开始记录日志
		try {
			System.out.println("========================开始记录日志===============================");
			long beforeTime = System.currentTimeMillis();
			((ProceedingJoinPoint) joinPoint).proceed();
			joinPoint.getSignature().getName();
			joinPoint.getArgs();
			System.out.println("aaaa");
			long endTime = System.currentTimeMillis();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("========================日志记录结束===============================");
		
	}
}
