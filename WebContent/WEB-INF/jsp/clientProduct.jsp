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
	
	<script type="text/javascript" src="js/outer/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="js/equalcolumns.js"></script>
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
	</script>
</head>
<body>

	<header>
		<h1>桶装水
		<a style="float:right;font-size: 10px;padding:0;font-weight:normal" href="javascript:">登录</a>
		</h1>
	</header>
	<nav>
		<ul>
			<li><a href="${ctx}">主页</a></li>
			<li class="selected"><a href="${ctx}/clientProducts.action">产品</a></li>
			<li><a href="${ctx}/showTbCouPonsProduct.action">优惠专区</a></li>
			<li><a href="#">联系我们</a></li>
		</ul>
	</nav>
<%-- 			
			 --%>
			
	
		<ul>
	<section id="intro">
		<c:forEach items="${tbProducts}" var="tbProduct" varStatus="status">
			<c:if test="${status.count < 3}">
			<li style="list-style: none;" class="myLi">
				<header>
					<h2>${tbProduct.proName}</h2>
				</header>
				<p>${tbProduct.proDesc}</p>
				<p>￥${tbProduct.proPrice}</p>
				<img src="${ctx}${tbProduct.proPic}" alt="lime" style="width: 220px";height="215px"/>
				<!-- <img src="images/introimage.png" alt="lime" /> -->
			</li>
			</c:if>
		</c:forEach>
		</ul>
	</section>
	<section id="content">
				<ul class="column">
				    <!--eqblock-->
		       <c:forEach items="${tbProducts}" var="tbProduct" varStatus="status">
				    <li>
				        <section class="block">
									<a href="#">
										<img src="${ctx}${tbProduct.proPic}" alt=""  />
									</a> 
										<h3><a href="#">${tbProduct.proName}</a></h3> 
										<p>${tbProduct.proDesc}</p> 
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
