<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="../bootstrap-3.3.5-dist/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="../css/homepage.css" />
<script type="text/javascript" src="../js/outer/jquery-1.11.0.min.js"></script>
<script src="../bootstrap-3.3.5-dist/js/bootstrap.min.js "></script>
<script type="text/javascript" src="../js/adminhomepage.js"></script>
<script>
	$(function() {
		var ctx = '${ctx}';
		loadComplete.init_function();
		loadComplete.firstNode(ctx);
	});
</script>
<title>水站系统</title>
</head>
<body>
	<div class="row">
		<div class="col-md-2">
			<div class="panel-group table-responsive" role="tablist" id="panelContain">
			</div>
		</div>
		<div class="col-md-10">
			<!-- <iframe src="sysNodesList.jsp"></iframe> -->
			<%-- <iframe src="${ctx}/sysNode/getAllSysNodes.action"></iframe> --%>
		</div>
	</div>
</body>
</html>