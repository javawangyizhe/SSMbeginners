<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link href="css/plugins/select/bootstrap-select.min.css" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper2 wrapper-content2 animated fadeInRight">
		<div class="row">
			<div class="col-sm-6">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>资源管理</h5>
					</div>
					<div class="ibox-content">
						<div class="zTreeDemoBackground left" style="font-size: 16px">
							<%--加载树的位置：--%>
							<ul id="treeDemo" class="ztree"></ul>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>资源添加</h5>
					</div>
					<div class="ibox-content">
						<form id="insertform" class="form-horizontal">
							
							<div class="form-group">
								<label class="col-sm-4 control-label">菜单资源名称：</label>

								<div class="col-sm-7">
									<input type="text" name="name" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">父菜单：</label>

								<div class="col-sm-7">
									<select name="pid" id="pid" >

									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">菜单资源路径：</label>

								<div class="col-sm-7">
									<input type="text" name="url" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">备注：</label>
								<div class="col-sm-7">
									<textarea name="remark" class="form-control"></textarea>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-8">
									<button id="insertSources" class="btn btn-sm btn-white" type="button">
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
	<%--加入样式： --%>
	<link rel="stylesheet" href="css/plugins/zTreeStyle/zTreeStyle.css" />

	<script>
		var setting = {
			data: {
				simpleData: {
					enable: true,
					pIdKey:"pid"
				}
			},
			view : {
				addHoverDom : function(treeId, treeNode) {
					var aObj = $("#" + treeNode.tId + "_a");
					if (treeNode.editNameFlag
							|| $("#btnGroup" + treeNode.tId).length > 0)
						return;
					var s = '<span id="btnGroup'+treeNode.tId+'">';
					if (treeNode.level == 1) {
						if (treeNode.children.length == 0) {
							s += '<span class="button remove" onclick="deleteNode('
									+ treeNode.id + ')"></span>';
						}
					} else if (treeNode.level == 2) {
						s += '<span class="button edit" onclick="editNode('
								+ treeNode.id + ')" ></span>';
						s += '<span class="button remove" onclick="deleteNode('
								+ treeNode.id + ')" ></span>';
					}
					s += '</span>';
					aObj.append(s);
				},
				removeHoverDom : function(treeId, treeNode) {
					$("#btnGroup" + treeNode.tId).remove();
				}
			}
		};
		function loadResource(){
			$.ajax({
				url:"findAllSources",
				type:"get",
				dataType:"json",
				success:function(obj){
					var zTreeObj =$.fn.zTree.init($("#treeDemo"), setting, obj);
					zTreeObj.expandAll(true);
				}
			});
		}

		//初始化树
		$(function(){
			loadResource();
			//获取父菜单下拉框
			$.ajax({
				url:"findAllParentNodes",
				dataType:"json",
				success:function(result){
					$.each(result,function (index,item){
						$("#pid").append("<option value="+item.id+">"+item.name+"</option>")
					});
				}
			});
		})

		//增加方法
		$("#insertSources").click(function (){
			$.ajax({
				url:"insertResources",
				dataType: "json",
				data:$("#insertform").serialize(),
				success:function (result){
					if(result.msg){
						swal(result.msg);
						document.getElementById("insertform").reset();
						loadResource();
					}else {
						swal(result.error);
					}
				}
			});
		})




		//删除方法
		function deleteNode(id) {
			swal({
				title : "您确定要删除该资源么？",
				text : "删除后将无法恢复，请谨慎操作！",
				type : "warning",
				showCancelButton : true,
				confirmButtonColor : "#DD6B55",
				confirmButtonText : "删除",
				closeOnConfirm : false
			}, function() {
				$.ajax({
					url:"deleteSourceById?id="+id,
					type:"get",
					dataType: "json",
					success:function (result){
						if(result.msg){
							loadResource();
							swal(result.msg)
						}else{
							swal(result.error)
						}
					}
				});

			});
		}
		//修改方法
		function editNode(id) {
			window.location.href="loadSourcesById?id="+id;
		}
	</script>
</body>


</html>
