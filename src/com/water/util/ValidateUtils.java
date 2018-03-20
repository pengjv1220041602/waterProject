package com.water.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.water.validate.MaxLength;
import com.water.validate.RegValidate;
import com.water.validate.Required;

/**
 * 验证帮助类
 * @author Zpj
 *
 */
public class ValidateUtils {
	
	public static boolean validateBean (Object object) {
		try{
			//得到所有字段
			Field[] fields = object.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				//是否含有此注解
				if (field.isAnnotationPresent(Required.class)) {
					PropertyDescriptor pd = new PropertyDescriptor(field.getName(),object.getClass());
			        Method getMethod = pd.getReadMethod();//获得get方法
			        Object o = getMethod.invoke(object);//执行get方法返回一个Object
			        String obj = null;
			        if (o != null) {
			        	obj = String.valueOf(o);
			        }
			        return StringUtils.isBlank(obj) == false ? true : false;
				}
				if (field.isAnnotationPresent(MaxLength.class)) {
					MaxLength maxLength = field.getAnnotation(MaxLength.class);
					PropertyDescriptor pd = new PropertyDescriptor(field.getName(),object.getClass());
			        Method getMethod = pd.getReadMethod();//获得get方法  
			        String obj = String.valueOf(getMethod.invoke(object));//执行get方法返回一个Object
			        boolean flag = StringUtils.isBlank(obj);
			        if (flag) {
			        	return true;
			        }
			        return obj.trim().length() < maxLength.maxLength() || 
			        		obj.trim().length() == maxLength.maxLength() ? true : false;
				}
				if (field.isAnnotationPresent(RegValidate.class)) {
					PropertyDescriptor pd = new PropertyDescriptor(field.getName(),object.getClass());
			        Method getMethod = pd.getReadMethod();//获得get方法  
			        String obj = String.valueOf(getMethod.invoke(object));//执行get方法返回一个Object
					
					RegValidate regValidate = field.getAnnotation(RegValidate.class);
					String reg = regValidate.regValidate();
					return obj.matches(reg) == true ? true : false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return false;
	}
	
}
