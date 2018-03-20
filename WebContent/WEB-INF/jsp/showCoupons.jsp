<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include  file="../sys/sys.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>展示所有的优惠券</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<link href="../bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/outer/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="../bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>

<script type="text/javascript">
	//获取所有的商品  tdCoupons  tbCouponsId
	function getproducts(obj){
		var couId = $(obj).parent().parent().find(".tdCoupons").find(".tbCouponsId").val();
		
		$.post(
			"${ctx}/tbProductTbCouponsVO/getProductAndCoupons.action",
			{
				"tbCoupons.id" : couId
			},
			function(data){
				var _htmlModel = $("#tabBody");
				var _couId = $("#couId");
				_couId.prop("value",couId);
				_htmlModel.children().remove();
				var _html = "";
				for (var i = 0; i < data.length; i++) {
					_html += "<tr><td><input name='' type='checkbox' class='chks' value='"+data[i].tbProduct.id+"'";
					if (data[i].tbCoupons != null && data[i].noCoupons == "0") {
						_html += "checked"
					}
					_html = _html + "/></td><td>" + data[i].tbProduct.proName +"</td></tr>";
				}
				_htmlModel.append(_html);
			}
		);
	}
	//提交对应的商品信息
	function submitProducts(){
		var chks = $(".chks:checked");
		var proIds = new Array();
		for (var i = 0; i < chks.length; i++) {
			proIds.push($(chks[i]).val());
		}
		$.ajax({
			type:"POST",
			url:"${ctx}/tbProductTbCouponsVO/addOrUpdateProductAndCoupons.action",
			dataType: "text",
			cache: false,
			traditional: true,
			data:{
				"tbCoupons.id" : $("#couId").val(),
				proIds : proIds
			},
			success:function(data){
				alert("添加成功");
			},
			error:function(){
				alert("添加失败");
			}
		});
	}
	
	/* 得到所有的用户 信息*/
	function issueCoupons(obj) {
		var tbCouponsId = $(obj).parent().parent().children(".tdCoupons").children(".tbCouponsId").val();
		$.post(
			"${ctx}/tbCoupons/showTbCouponByJson.action",
			{
				id:tbCouponsId
			},
			function (data){
				$("#myModalUsers").html("<input type='hidden' id='couOverNum' value='" + data.overNum + "' />所有用户 &nbsp;&nbsp;&nbsp;&nbsp;剩余优惠券：" + data.overNum + "个");
			}
		); 
		/* 得到相应的用户 */
		$.ajax({
			type:"POST",
			url:"${ctx}/tbUser/getAllTbUsersByJosn.action",
			dataType:"json",
			cache : false,
			data:{
				
			},
			success:function(data) {
				var myUserModel = $("#tabUserBody");
				$("#couUserId").prop("value",tbCouponsId);
				myUserModel.children().remove();
				var _html = "" ;
				for (var i = 0; i < data.length; i++) {
					_html += "<tr class='couponsUsers'><td><input name='' type='checkbox' class='chks' value='"+data[i].id+"'";
					_html = _html + "/></td><td>" + data[i].userName +"</td><td class='thirdTr'><input type='number' class='userNames dfinput' style='width:150px' onKeyUp=changeCousNum() /></td></tr>";
				}
				myUserModel.append(_html);
			}
		});
	}
	/* 发售优惠券随时验证是否发售过多 */
	function changeCousNum(){
		var $userNames = $(".userNames");
		var totalNum = 0;
		var couOverNum = $("#couOverNum").val();
		for (var i = 0; i < $userNames.length; i++) {
			totalNum = Number(totalNum) + Number($($userNames[i]).val());
		}
		if (couOverNum < totalNum) {
			$("#sellCous").prop("disabled","disabled");
			alert("您发售的优惠券过多！");
		} else {
			$("#sellCous").removeAttr("disabled");
		}
	}
	//发售对应的用户
	function submitUsersCoupons() {
		var couponsUsers = $(".couponsUsers");
		var usersArray = Array();
		var numsArray = Array();
		for (var i = 0; i < couponsUsers.length; i ++) {
			var nums = $(couponsUsers[i]).children(".thirdTr").children(".userNames").val();
			var userId = $(couponsUsers[i]).children().children(".chks").val();
			if (nums >= 0 && nums != null && nums != "") {
				usersArray.push(userId);
				numsArray.push(nums);
			}
		}
		$.ajax({
			type:"POST",
			url:"${ctx}/tbCouponsUser/addOrUpdateTbCouponsUsers.action",
			dataType:"json",
			traditional: true,
			cache : false,
			data:{
				"userIds":usersArray,
				"couponsNums":numsArray,
				couponsId : $("#couUserId").val()
			},
			success:function(data) {
				alert(222)
				window.location.href="${ctx}/tbCoupons/showAllTbCoupons.action";
			}
		});
	}
	
$(document).ready(function(){

  $(".click").click(function(){
  	$(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>
<style>
	input::-webkit-outer-spin-button,
	input::-webkit-inner-spin-button{
		-webkit-appearance: none !important;
	}
	input[type="number"]{-moz-appearance:textfield;}
</style>
</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">数据表</a></li>
    <li><a href="#">基本内容</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    	<ul class="toolbar">
        <li class="click" onclick="javascript:window.location.href='${ctx}/tbCoupons/addOrUpdateTbCouponsPage.action'"><span><img src="../images/t01.png" /></span>添加</li>
        <li class="click"><span><img src="../images/t02.png" id="uuu"/></span>修改</li>
        <li><span><img src="../images/t03.png" /></span>删除</li>
        <li><span><img src="../images/t04.png" /></span>统计</li>
        </ul>
        <ul class="toolbar1">
        <li><span><img src="../images/t05.png" /></span>设置</li>
        </ul>
    </div>

	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">所有商品</h4>
					<input type="hidden" id="couId" value="" />
				</div>
				<div class="modal-body" id="modelBody">
					<table class="tablelist" id="tabModel">
				    	<thead>
					    	<tr>
					        <th><input name="" type="checkbox" value="" checked="checked"/></th>
					        <th>商品名称</th>
							</tr>
						</thead>
						<tbody id="tabBody">
						
						</tbody>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" onclick="submitProducts()">提交</button>
				</div>
			</div>
		</div>
    </div><!-- Model End -->
    
    
    	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myUserModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalUsers"></h4> 
					<input type="hidden" id="couUserId" value="" />
				</div>
				<div class="modal-body" id="modelUserBody">
					<table class="tablelist" id="tabUserModel">
				    	<thead>
					    	<tr>
					        <th><input name="" type="checkbox" value="" checked="checked"/></th>
					        <th>用户名称</th>
					        <th>发售数量</th>
							</tr>
						</thead>
						<tbody id="tabUserBody">
						
						</tbody>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="sellCous" onclick="submitUsersCoupons()">发售</button>
				</div>
			</div>
		</div>
    </div><!-- Model End -->
    
    <table class="tablelist">
    	<thead>
	    	<tr>
	        <th><input name="" type="checkbox" value="" checked="checked"/></th>
	        <th>优惠券名称<!-- <i class="sort"><img src="../images/px.gif" /></i> --></th>
	        <th>自发或抢购</th>
	        <th>优惠券发行开始时间</th>
	        <th>优惠券发行结束时间</th>
	        <th>使用开始时间</th>
	        <th>使用结束时间</th>
	        <th>数量</th>
	        <th>优惠价格</th>
	        <th>剩余数量</th>
	        <!-- <th>创建时间</th> -->
	        <th>创建人</th>
	        <th>操作</th>
	        </tr>
        </thead>
        <tbody>
        <c:forEach items="${tbCoupons}" var="tbCoupon">
	        <tr>
	        <td class="tdCoupons"><input type="hidden" value="${tbCoupon.id}" class="tbCouponsId"/><input name="" type="checkbox" value="" /></td>
	        <td>${tbCoupon.couponsName}</td>
	        <td>
	        	<c:if test="${tbCoupon.couponsTimeOwn eq '0'}">自发</c:if>
	        	<c:if test="${tbCoupon.couponsTimeOwn eq '1'}">抢购</c:if>
	        </td>
	        <td><fmt:formatDate value="${tbCoupon.couponsBeginTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	        <td><fmt:formatDate value="${tbCoupon.couponsEndTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	        <td><fmt:formatDate value="${tbCoupon.useBeginTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	        <td><fmt:formatDate value="${tbCoupon.useEndTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	        <td>${tbCoupon.couponsNum}</td>
	        <td>${tbCoupon.couponsPrice}</td>
	        <td>${tbCoupon.overNum}</td>
	        <%-- <td><fmt:formatDate value="${tbCoupon.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
	        <td>${tbCoupon.createUser}</td>
	        <td><a href="javascript:;" onclick="getproducts(this)"  data-toggle="modal" data-target="#myModal" class="tablelink">优惠商品</a>
				<a href="${ctx}/tbCoupons/addOrUpdateTbCouponsPage.action?id=${tbCoupon.id}" class="tablelink">更新</a>
				<c:if test="${tbCoupon.couponsTimeOwn eq '0'}"><a href="javascript:;" onclick="issueCoupons(this)" class="tablelink" data-toggle="modal" data-target="#myUserModel" >发布</a></c:if>
				<c:if test="${tbCoupon.couponsTimeOwn eq '1'}"><a href="${ctx}/tbCoupons/deleteCoupons.action?id=${tbCoupon.id}" class="tablelink">已发布</a></c:if>
			</td>
				<a href="${ctx}/tbCoupons/deleteCoupons.action?id=${tbCoupon.id}" class="tablelink">删除</a>
	        </tr> 
	     </c:forEach>
        </tbody>
    </table>
    
   
    <div class="pagin">
    	<div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        <li class="paginItem"><a href="javascript:;">1</a></li>
        <li class="paginItem current"><a href="javascript:;">2</a></li>
        <li class="paginItem"><a href="javascript:;">3</a></li>
        <li class="paginItem"><a href="javascript:;">4</a></li>
        <li class="paginItem"><a href="javascript:;">5</a></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;">10</a></li>
        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>
    
    
   <!--  <div class="tip">
    	<div class="tiptop"><span>添加</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="../images/ticon.png" /></span>
        <div class="tipright">
        <p>身份证号：<input name="username" type="text"/></p>
        <p>用户名：<input name="username" type="text"/></p>
        <p>密&nbsp;&nbsp;码：<input name="password" type="text"/></p>
        <p>地&nbsp;&nbsp;址：<input name="username" type="text"/></p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div> -->
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
