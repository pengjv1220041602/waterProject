<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include  file="../sys/sys.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>无标题文档</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<link href="../css/select.css" rel="stylesheet" type="text/css" />
<link href="../bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
<link href="../bootstrap-3.3.5-dist/css/bootstrap-fileinput.css" rel="stylesheet">

<script type="text/javascript" src="../js/outer/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="../js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="../js/select-ui.min.js"></script>
<script type="text/javascript" src="../editor/kindeditor.js"></script>
<script src="../bootstrap-3.3.5-dist/js/bootstrap-fileinput.js"></script>

<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : '../index.css'
    });
    
   /*  $(function () {
        //比较简洁，细节可自行完善
        $('#uploadSubmit').click(function () {
            var data = new FormData($('#uploadForm')[0]);
            $.ajax({
                url: 'xxx/xxx',
                type: 'POST',
                data: data,
                async: false,
                cache: false,
                contentType: false,
                processData: false,
                success: function (data) {
                    console.log(data);
                    if(data.status){
                        console.log('upload success');
                    }else{
                        console.log(data.message);
                    }
                },
                error: function (data) {
                    console.log(data.status);
                }
            });
        });

    }) */

    
    
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
    <li><a href="#">系统设置</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">发布通知</a></li> 
    <li><a href="#tab2">自定义</a></li> 
  	</ul>
    </div> 
    
  	<div id="tab1" class="tabson">
    
    <div class="formtext">Hi，<b>admin</b>，欢迎您试用信息发布功能！</div>
    <form action="${ctx}/tbProduct/addOrUpdateTbProduct.action" method="post"  enctype="multipart/form-data">
    <input type="hidden" name="id" value="${tbProduct.id}" />
    <ul class="forminfo">
    <li><label>商品名称<b>*</b></label><input name="proName" type="text" class="dfinput" placeholder="请填写单位名称" value="${tbProduct.proName}"  style="width:518px;"/></li>
   
    <li><label>所属种类<b>*</b></label>  

    <div class="vocation">
    <select class="select1" name="kindId">
	    <c:forEach items="${tbKinds}" var="tbKind">
	    	<option value="${tbKind.id}" ${tbProduct.kindId eq tbKind.id ? 'selected':''}>${tbKind.kindName}</option>
	    </c:forEach>
    </select>
    </div>
    
    </li>
    <li><label>商品价格<b>*</b></label><input name="proPrice" type="text" class="dfinput" placeholder="请填写产品价格" value="${tbProduct.proPrice}"  style="width:518px;"/></li>
    <li><label>产品容量<b>*</b></label>
    
    <div class="vocation">
    <select class="select1" name="proCapacity">
    <option>200L</option>
    <option>300L</option>
    <option>400L</option>
    <option>500L</option>
    </select>
    </div>
    
    </li>
    
    <li><label>上传图片<b>*</b></label>
		<div class="fileinput fileinput-new" data-provides="fileinput"  id="exampleInputUpload">
             <div class="fileinput-new thumbnail" style="width: 168px;height: 126px;max-height:126px;">
                 <img id='picImg' style="width: 168px;height: 126px;" src='${tbProduct.proPic eq null ? "../images/noimage.png" : ctx.concat(tbProduct.proPic)}' alt="" />
             </div>
             <div class="fileinput-preview fileinput-exists thumbnail" style="width: 168px; height: 126px;"></div>
             <div>
                 <span class="btn btn-primary btn-file">
                     <span class="fileinput-new">选择文件</span>
                     <span class="fileinput-exists">换一张</span>
                     <input type="file" name="pictureFile" id="picID" accept="image/gif,image/jpeg,image/x-png" value="${tbProduct.proPic}"/>
                     <input type="hidden" name="proPic" value="${tbProduct.proPic}" />
                 </span>
                 <a href="javascript:;" class="btn btn-warning fileinput-exists" data-dismiss="fileinput">移除</a>
             </div>
         </div>
    </li>
    
    <li><label>描述内容<b>*</b></label>
    
   <!-- <textarea id="content7" name="content" style="width:700px;height:250px;visibility:hidden;"></textarea> -->
    <textarea class="form-control" rows="3" style="width: 820px" name="proDesc">${tbProduct.proDesc}</textarea>
    </li>
    <li><label>&nbsp;</label><input type="submit" class="btn btn-info" style="background-color: rgb(52,83,145)" value="保存商品"/></li>
    </ul>
    </form>
    </div> 
    
  	<div id="tab2" class="tabson">
    
    </div>  
       
	</div> 
 
	<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
    
    </div>

</body>
</html>
