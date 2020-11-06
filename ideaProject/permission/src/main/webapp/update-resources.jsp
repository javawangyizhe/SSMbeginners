<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>


<!-- Mirrored from www.gzsxt.cn/theme/hplus/table_basic.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:20:01 GMT -->
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>办公系统 - 基础表格</title>
<meta name="keywords" content="办公系统">
<meta name="description" content="办公系统">

<link rel="shortcut icon" href="favicon.ico">
<link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
<link href="css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">
<link href="css/plugins/select/bootstrap-select.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/plugins/zTreeStyle/zTreeStyle.css" />

</head>

<body class="gray-bg">
	<div class="wrapper2 wrapper-content2 animated fadeInRight">
		<div class="row">
			
			<div class="col-sm">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>资源添加</h5>
					</div>
					<div class="ibox-content">
						<form id="updateform" class="form-horizontal">
							<input type="hidden" name="id" value="${sources.id}">
							<div class="form-group">
								<label class="col-sm-4 control-label">菜单资源名称：</label>

								<div class="col-sm-3">
									<input type="text" name="name" value="${sources.name}" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">父菜单：</label>

								<div class="col-sm-3" >
									<select id="pid" name="pid" >

									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">菜单资源路径：</label>

								<div class="col-sm-3">
									<input type="text" name="url" value="${sources.url}" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">备注：</label>
								<div class="col-sm-3">
									<textarea class="form-control" name="remark">${sources.remark}</textarea>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-4">
									<button id="saveResources" class="btn btn-sm btn-white" type="button">
										<i class="fa fa-save"></i> 保存
									</button>
									<button class="btn btn-sm btn-white" type="reset">
										<i class="fa fa-undo"></i> 重置
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>

		</div>

	</div>
	<script src="js/jquery.min.js?v=2.1.4"></script>
	<script src="js/bootstrap.min.js?v=3.3.6"></script>
	<script src="js/plugins/select/bootstrap-select.min.js"></script>
	<script src="js/plugins/sweetalert/sweetalert.min.js"></script>
	<script src="js/plugins/ztree/jquery.ztree.core.min.js"></script>
	<script src="js/plugins/ztree/jquery.ztree.exedit.js"></script>
	<script>
		$(function (){
			$.ajax({
				url:"findAllParentNodes",
				dataType:"json",
				success:function(result){
					$.each(result,function (index,item){
						console.info(item);
						$("#pid").append("<option selected=$(item.id==sources.pid?'selected':'') value="+item.id+">"+item.name+"</option>")
					});
				}
			});
		})
		$("#saveResources").click(function (){
			$.ajax({
				url:"saveResources",
				dataType: "json",
				data:$("#updateform").serialize(),
				success:function (result){
					if(result.msg){
						swal(result.msg);
					}else {
						swal(result.error);
					}
				}
			});
		})
	</script>
	
</body>


</html>
