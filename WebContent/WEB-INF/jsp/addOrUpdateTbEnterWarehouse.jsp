<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../sys/sys.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加更新入库页面</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<link href="../css/select.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="../js/outer/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="../js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="../js/select-ui.min.js"></script>
<script type="text/javascript">
	$(function(){
		onloadComplete();
	})
	
	function onloadComplete() {
		var kindId = $("#kindId option:selected").val();
		sendAjax(kindId);
	}
	
	function kindChangeEvent(){
		var kindId = $("#kindId option:selected").val();
		sendAjax(kindId);
	}
	
	
	function sendAjax(kindId) {
		$.get(
				"${ctx}/tbProduct/showProductsByJson.action",
				{kindId:kindId},
				function(data) {
					$("#divProId").find(".uew-select-text").text("");
					$("#proId").children().remove();
					var _html = "";
					for (var i = 0; i < data.length; i++) {
						if (i == 0) {
							$("#divProId").find(".uew-select-text").text(data[i].proName);
							_html += "<option value="+data[i].id+" selected='selected'>"+data[i].proName+"</option>";
						} else { 
							_html += "<option value="+data[i].id+">"+data[i].proName+"</option>";
						} 
					}
					$("#proId").append(_html);
				}
			);
	}
	
	
</script>

<script type="text/javascript">
	$(document).ready(function(e) {
		$(".select1").uedSelect({
			width : 345
		});
		$(".select2").uedSelect({
			width : 167
		});
		$(".select3").uedSelect({
			width : 100
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

		<div class="formtitle">
			<span>基本信息</span>
		</div>

			<ul class="forminfo">
				<form action="${ctx}/tbEnterWarehouse/addOrUpdateEnterWarehouse.action" method="post">
					<input type="hidden" value="${enterWarehouse.id}" name="id" />
					<%-- <li><label>商品名称</label><input name="kindName" type="text" class="dfinput" value="${enterWarehouse.kindName}" /> --%>
					<li>
						<label>所属种类<b>*</b></label>
						<div class="vocation">
							<select class="select1" name="tbProduct.kindId" id="kindId" onchange="kindChangeEvent()">
								<c:forEach items="${tbKinds}" var="tbKind">
									<option value="${tbKind.id}" ${tbProduct.kindId eq tbKind.id ? 'selected':''}>${tbKind.kindName}</option>
								</c:forEach>
							</select>
						</div>
					</li>
					
					<li>
						<label>商品名称<b>*</b></label>
						<div class="vocation" id="divProId">
							<select class="select1" id="proId" name="tbProduct.id">
								
							</select>
						</div>
					</li>
					
					<li><label>入库数量<b>*</b></label><input name="enterWarehouseNum" type="text" class="dfinput" value="" /></li>
					<li><label>&nbsp;</label><input type="submit" class="btn" value="确认保存" /></li>
				</form>
			</ul>
		</div>
</body>
</html>
