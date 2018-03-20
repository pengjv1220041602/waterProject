package com.water.springmvc.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.water.authen.Authen;
import com.water.constant.Constant;
import com.water.pojo.TbUser;

public class LoggerInterceptor  implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		if (request.getRequestURI().indexOf("/login.action") > 0 || 
				request.getRequestURI().indexOf("/home.action") > 0 ||
				request.getRequestURI().equals("/waterPro/") ||
				request.getRequestURI().lastIndexOf("/clientProducts.action") > 0 ||
				request.getRequestURI().lastIndexOf("/showTbCouPonsProduct.action") > 0 ||
				request.getRequestURI().lastIndexOf("/tbUserLogin.action") > 0 ||
				request.getRequestURI().lastIndexOf("/redirectCompanyInfo.action") > 0 ||
				request.getRequestURI().lastIndexOf("/redirectCompanyTel.action") > 0) {
			return true;
		}
		HttpSession session = request.getSession();
		 TbUser user= (TbUser)session.getAttribute("user");
		if ( user != null) {
			Method[] methods = object.getClass().getMethods();
			for (Method method : methods) {
				//是否含有认证注解
				if (method.isAnnotationPresent(Authen.class)) {
					//含有
					Authen authen = method.getAnnotation(Authen.class);
					if (authen.adminAuth()) {
						if (Constant.ADMIN_AUTH.equals(user.getUserAdmin())){
							return true;
						}
					} else {
						if (Constant.USER_AUTH.equals(user.getUserAdmin())) {
							return true;
						}
					}
				}
			}
			return true;
		}
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		return false;
	}

}