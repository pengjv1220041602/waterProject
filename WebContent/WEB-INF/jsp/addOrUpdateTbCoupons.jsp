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

$().ready(function(){
	

	
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
    <form action="${ctx}/tbCoupons/addOrUpdateTbCoupons.action" method="post" class="cmxfrom" id="commentFrom">
    	<input type="hidden" value="${tbCoupons.id}" name="id"/>
	    <li><label>优惠券名称</label><input id="couponsName" name="couponsName" type="text" class="dfinput" value="${tbCoupons.couponsName}" maxlength="18"/></li>
	    <li><label>自发抢购</label><cite><input name="couponsTimeOwn" type="radio" value="0" ${tbCoupons.couponsTimeOwn eq '0' ? 'checked':''}/>自发
	    						<input name="couponsTimeOwn" type="radio" value="1" ${tbCoupons.couponsTimeOwn eq '1' ? 'checked':''}/>抢购</cite></li>
	    <li><label>发行开始时间</label><input id="couponsBeginTime" name="couponsBeginTime" type="text" class="dfinput" value="${tbCoupons.couponsBeginTime}" maxlength="30"/></li>
	    <li><label>发行结束时间</label><input id="couponsEndTime" name="couponsEndTime" type="text" class="dfinput" value="${tbCoupons.couponsEndTime}" maxlength="30"/></li>
	    <li><label>使用开始时间</label><input id="useBeginTime" name="useBeginTime" type="text" class="dfinput" value="${tbCoupons.useBeginTime}" maxlength="19"/></li>
	    <li><label>使用结束时间</label><input id="useEndTime" name="useEndTime" type="text" class="dfinput" value="${tbCoupons.useEndTime}" maxlength="80"/></li>
	    <li><label>总数量</label><input id="couponsNum" name="couponsNum" type="text" class="dfinput" value="${tbCoupons.couponsNum}" maxlength="90"/></li>
	    <li><label>优惠价格</label><input id="couponsPrice" name="couponsPrice" type="text" class="dfinput" value="${tbCoupons.couponsPrice}" maxlength="11"/></li>
	    <li><label>描述</label><input id="couponsDesc" name="couponsDesc" type="text" class="dfinput" value="${tbCoupons.couponsDesc}" maxlength="11"/></li>
	    <li><label>&nbsp;</label><input type="submit" class="btn" value="确认保存" id="submit"/></li>
    </form>
    </ul>
    
    
    </div>
</body>
</html>
