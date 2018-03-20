<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include  file="../sys/sys.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	

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
    <form action="${ctx}/tbkind/addOrUpdatekind.action" method="post">
    	<input type="hidden" value="${tbkind.id}" name="id"/>
	    <li><label>商品种类</label><input name="kindName" type="text" class="dfinput" value="${tbkind.kindName}" />
	    <li><label>种类描述</label><input name="kindDesc" type="text" class="dfinput" value="${tbkind.kindDesc}"/>
	    <li><label>&nbsp;</label><input type="submit" class="btn" value="确认保存"/></li>
    </form>
    </ul>
    
    
    </div>
</body>
</html>
