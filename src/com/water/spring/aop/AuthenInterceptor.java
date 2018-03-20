package com.water.spring.aop;

import java.lang.reflect.Method;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.water.authen.Authen;
import com.water.constant.Constant;
import com.water.pojo.TbUser;

@Component
@Aspect
public class AuthenInterceptor {

	@Pointcut(value="execution (* com.water.controller.*.* (..))")
	public void authPointCut() {}
	
	@Around(value="AuthenInterceptor.authPointCut()")
	public Object authBefore (ProceedingJoinPoint  joinPoint) {
		try {
			Method method = getSourceMethod(joinPoint);
			//获取session
			HttpSession session = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
			TbUser user = (TbUser)session.getAttribute("user");
			if (method.isAnnotationPresent(Authen.class)) {
				Authen annotation = method.getAnnotation(Authen.class);
				//是否含有注解
				if (annotation.adminAuth()) {
					//是否是管理员
					if (Constant.ADMIN_AUTH.equals(user.getUserAdmin())) {
						Object proceed = joinPoint.proceed(joinPoint.getArgs());
						return proceed;
					}
				}
			} else {
				//没有注解的
				Object proceed = joinPoint.proceed(joinPoint.getArgs());
				return proceed;
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}
	//获取对应的方法
	private Method getSourceMethod(JoinPoint jp){
        Method proxyMethod = ((MethodSignature) jp.getSignature()).getMethod();
        try {
            return jp.getTarget().getClass().getMethod(proxyMethod.getName(), proxyMethod.getParameterTypes());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return null;
    }
}
