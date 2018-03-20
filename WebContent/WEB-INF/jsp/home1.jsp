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
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/equalcolumns.js"></script> 
	
</head>
<body>

	<header>
		<h1>桶装水<a style="float:right;font-size: 10px;padding:0;font-weight:normal" href="javascript:">登录</a></h1>
	</header>
	<nav>
		<ul>
			<li class="selected"><a href="${ctx}">主页</a></li>
			<li><a href="${ctx}/clientProducts.action">产品</a></li>
			<li><a href="${ctx}/showTbCouPonsProduct.action">优惠专区</a></li>
			<li><a href="#">联系我们</a></li>
		</ul>
	</nav>
	<section id="intro">
		<header>
			<h2>水是万物之源</h2>
		</header>
		<p>水是万物之源，是一切生物生存的物质基础。</p>
		<p>曾有学者估计地球上所有生物的含水量，几乎是地球地表淡水量的一半。
		地球上所有生物的含水量=1/2地球地表淡水量。
		地球上几乎所有生物的体内都含有水，都会因缺水而死亡。所以从这种意义上来讲，“生命就是水,水就是生命”。</p>
		<p>——————————珍惜水，就是珍惜生命。 </p>
		<img src="images/introimage.png" alt="lime" />
	</section>
	
	<section id="content">
				<ul class="column">
				    <!--eqblock-->
		       <c:forEach items="${tbProducts}" var="tbProduct" varStatus="status">
		       <c:if test="${status.count < 9}">
				    <li>
				        <section class="block">
									<a href="#">
										<img src="${ctx}${tbProduct.proPic}" alt="" style="width: 180px; height: 135px" />
									</a> 
										<h3><a href="#">${tbProduct.proName}</a></h3> 
										<p>${tbProduct.proDesc}</p> 
				        </section>
				    </li>
				</c:if>
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
