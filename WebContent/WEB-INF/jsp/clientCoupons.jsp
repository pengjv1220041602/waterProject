<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include  file="../sys/sys.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>桶装水</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" href="css/styles.css" type="text/css" media="screen" />
	<link rel="stylesheet" type="text/css" href="css/print.css" media="print" />
	<link href="bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript" src="js/outer/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="js/equalcolumns.js"></script>
	<script type="text/javascript" src="bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(function(){
			var li = $(".myLi");
			var num=0;  
		    var len=li.length;  
		    $(li[1]).css("display","none");
		    $(li[2]).css("display","none");
		    setInterval(function(){  
		    	$(li[num]).css("display","none");
		        num=++num==len?0:num;
		        $(li[num]).css("display","inline-block");
		        //li[num].style.display="inline-block";  
		  
		},3000);
		})
		function getCoupons(obj){
			var userId = "${user.id}";
			var couId =  $(obj).prev(".couId").val();
			 $.post(
				"${ctx}/getCoupons.action",
				{
					"tbUser.id" : userId,
					"tbCoupons.id" : couId
				},
				function(data){
					//$("#modelCouponsBody").html(data.result);
					alert(data.result);
					window.location.href = "${ctx}/showTbCouPonsProduct.action";
				}
			);
		}
	</script>
	<style type="text/css">
		*{
			-webkit-box-sizing:inherit !important;
			box-sizing:inherit !important;
		}
	</style>
</head>
    
<body>
<!-- 模态框（Modal） -->
	<div class="modal fade" id="myLoginModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="position:relative;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					登录
				</div>
				<div class="modal-body" id="modelBody">
					<form action="${ctx}/tbUserLogin.action" method="post">
						用户名：<input type="text" name="loginName" />
						密&nbsp;&nbsp;码：<input type="text" name="password" />
						<button type="submit" class="btn btn-primary">提交</button>
					</form>
				</div>
			</div>
		</div>
    </div><!-- Model End -->
    
    <!-- 模态框（Modal） -->
	<div class="modal fade" id="myCouponsModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				
				<div class="modal-body" id="modelCouponsBody">
					
				</div>
				
			</div>
		</div>
    </div><!-- Model End -->
    
  
    
	<header>
		<h1 style="font-weight: bold;padding : 31px 0 29px 0 !important;line-height:0 !important">桶装水   
			<a style="float:right;font-size: 10px;padding:0;font-weight:normal" href="javascript:">登录</a>
		</h1>
	</header>
	<nav>
		<ul>
			<li><a href="${ctx}">主页</a></li>
			<li><a href="${ctx}/clientProducts.action">产品</a></li>
			<li class="selected"><a href="${ctx}/showTbCouPonsProduct.action">优惠专区</a></li>
			<li><a href="#">联系我们</a></li>
		</ul>
	</nav>
	
		<ul>
	<section id="intro">
		<c:forEach items="${tbCoupons}" var="tbCoupon" varStatus="status">
			<c:if test="${status.count < 3}">
			<li style="list-style: none;" class="myLi">
				<header>
					<h2>${tbCoupon.couponsName}</h2>
				</header>
				<p>${tbCoupon.couponsDesc}</p>
				<p>优惠价格：￥${tbCoupon.couponsPrice}</p>
				<p>剩余数量：${tbCoupon.overNum}</p>
				<p style="width: 400px">抢购起始时间：<fmt:formatDate value="${tbCoupon.couponsBeginTime}" pattern="yyyy-MM-dd HH:mm:ss"/> 至 <fmt:formatDate value="${tbCoupon.couponsEndTime}" pattern="yyyy-MM-dd HH:mm:ss"/></p> 
				<p style="width: 400px">优惠起始时间：<fmt:formatDate value="${tbCoupon.useBeginTime}" pattern="yyyy-MM-dd HH:mm:ss"/> 至 <fmt:formatDate value="${tbCoupon.useEndTime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
				<input type="hidden" value="${tbCoupon.id}" class="couId"/>
				<a href="javascript:" data-toggle="modal" data-target="${user.id != null ? '#myCouponsModel':'#myLoginModel'}" ${user.id != null ? 'onclick=getCoupons(this)' : ''}><img src="images/qiang.jpg" alt="lime" style="width: auto;"/></a>
			</li>
			</c:if>
		</c:forEach>
		</ul>
	</section>
	<section id="content">
				<ul class="column">
				    <!--eqblock-->
		       <c:forEach items="${productAndCoupons}" var="productAndCoupon" varStatus="status">
				    <li>
				        <section class="block"  style="-webkit-box-sizing:inherit;box-sizing:none;">  
									<a href="#">
										<img src="${ctx}${productAndCoupon.tbProduct.proPic}" alt=""  />
									</a> 
										<h3><a href="#">${productAndCoupon.tbProduct.proName}</a></h3> 
										<p>${productAndCoupon.tbProduct.proDesc}</p>
										<p>商品价格：￥${productAndCoupon.tbProduct.proPrice}</p>
										<p>优惠价格：￥${productAndCoupon.tbCoupons.couponsPrice}</p> 
				        </section>
				    </li>
				</c:forEach> 

				    </section>
		
	<footer>
    <section>
    <h3></h3>
    <p></p>
    <p></p>
    </section>
    
    <section>
    <h3></h3>
    <p>版权所有&copy;联系方式：1111111 欢迎订购</p>
    <p></p>
    </section>
    
    <section>
    <h3></h3>
    <p><a href="#" title="your site name"></a></p>
    <p></p>
    </section>

	</footer>
<!-- Free template created by http//freehtml5templates.com -->
</body>
</html>
