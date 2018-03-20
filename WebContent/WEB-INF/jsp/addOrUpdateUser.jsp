<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include  file="../sys/sys.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="../js/outer/jquery-1.11.0.min.js"></script>
<script language="JavaScript" src="../js/outer/jquery.validate.js"></script>
<script language="JavaScript" src="../js/outer/messages_zh.js"></script>
<script language="JavaScript" src="../js/inner/card.js"></script>
<script type="text/javascript">
/* $.validator.setDefaults({
	submitHandler: function(){
		//$("#commentFrom").submit();
	}
}); */

$().ready(function(){
	
    $.validator.addMethod("checkIdCard",function(value,element,params){  
        return this.optional(element)||(idCardNoUtil.checkIdCardNo(value));  
    },"*请输入正确的身份证号码！"); 
	
	$("#commentFrom").validate({
		errorPlacement:function(error,element){
			if(element.is(":text") || element.is(":password")){
				error.appendTo(element.parent());
			}else{
				error.appendTo(element.parent().next());
			}
		},
		errorElement:"em",
		errorClass:"errormsg",
		rules:{
			userIdcard:{
				required: true,
				checkIdCard:true
			},
			userName: {
				required:true,
				maxlength:30
			},
			password: {
				required: true,
				minlength: 6,
				maxlength: 16
			},
			userAddress: {
				required:true,
				maxlength:80
			},
			userPhone:{ 
				required:true,
				maxlength:11
			}
		},
		messages: {
			userIdcard: {
				required:"*必填信息",
				checkIdCard:"*请输入正确的身份证号码！"
			},
			userName: {
				required:"*必填信息",
				maxlength:"*最大长度10个字"
			},
			password: {
				required:"*必填信息",
				minlength:"*密码长度不能小于6位",
				maxlength:"*密码长度不能大于16位"
			},
			userAddress: {
				required:"*必填信息",
				maxLength:"*最大长度80个字"
			},
			userPhone: {
				required:"*必填信息",
				maxLength:"*最大长度11位"
			}
		}
	});
	
});

</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>	
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">表单</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <ul class="forminfo">
    <form action="${ctx}/tbUser/addOrUpdateTbUser.action" method="post" class="cmxfrom" id="commentFrom">
    	<input type="hidden" value="${tbUser.id}" name="id"/>
	    <li><label>身份证号</label><input id="userIdcard" name="userIdcard" type="text" class="dfinput" value="${tbUser.userIdcard}" maxlength="18"/></li>
	    <li><label>姓名</label><input id="userName" name="userName" type="text" class="dfinput" value="${tbUser.userName}" maxlength="30"/></li>
	    <li><label>登录名</label><input id="loginName" name="loginName" type="text" class="dfinput" value="${tbUser.loginName}" maxlength="30"/></li>
	    <li><label>是否管理员</label><input name="userAdmin" type="checkbox" value="1" ${tbUser.userAdmin eq '1' ? 'checked':''}/>是</li>
	    <li><label>密码</label><input id="password" name="password" type="password" class="dfinput" value="${tbUser.password}" maxlength="16"/></li>
	    <li><label>地址</label><input id="userAddress" name="userAddress" type="text" class="dfinput" value="${tbUser.userAddress}" maxlength="80"/></li>
	    <li><label>联系方式</label><input id="userPhone" name="userPhone" type="text" class="dfinput" value="${tbUser.userPhone}" maxlength="11"/></li>
	    <li><label>&nbsp;</label><input type="submit" class="btn" value="确认保存" id="submit"/></li>
    </form>
    </ul>
    
    
    </div>
</body>
</html>
