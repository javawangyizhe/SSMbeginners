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
    <link href="css/plugins/select/bootstrap-select.min.css" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper2 wrapper-content2 animated fadeInRight">
	    <div class="row">
	    		<div class="col-sm-5">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>添加部门</h5>
                    </div>
                    <div class="ibox-content">
                        <form  action="saveDept" method="post" class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">部门编号：</label>

                                <div class="col-sm-8">
                                    <input type="text" name="deptno" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">部门名称：</label>

                                <div class="col-sm-8">
                                    <input type="text" name="dname" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">区域：</label>

                                <div class="col-sm-8">
                                    <input type="text" name="local" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-8">
                                    <button class="btn btn-sm btn-white" type="submit"><i class="fa fa-save"></i> 保存</button>
                                    <button class="btn btn-sm btn-white" type="reset"><i class="fa fa-undo"></i> 重置</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
	    		<div class="col-sm-7">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>部门列表 <small>点击修改信息将显示在左边表单</small></h5>
                    </div>
                    <div class="ibox-content">                    	
                        <div class="hr-line-dashed2"></div>
                        <div class="row">
                            <div class="table-responsive">
                            <table class="table table-striped list-table">
                                <thead>
                                    <tr>		
                                        <th>选择</th>
                                        <th>部门编号</th>
                                        <th>部门名称</th>
                                        <th>区域</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${pageInfo.list}" var="item">
                                    <tr>
                                        <td><input name="checkName" type="checkbox" ></td>
										<td>${item.deptno}</td>
										<td>${item.dname}</td>
										<td>${item.local}</td>
                                        <td>
	                                     <a href="update-dept.jsp?deptno=${item.deptno}"><i class="glyphicon glyphicon-edit  text-navy"></i></a>
	                                     <a href="javascript:void(0)" onclick="deleteDeptById(${item.deptno})" class="btndel"><i class="glyphicon glyphicon-remove  text-navy"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="row">
	                        	<div class="col-sm-5">
	                        		<button class="btn btn-sm btn-primary"  onclick="chooseAll()" type="button"><i class="fa fa-check-square-o"></i> 全选</button>
	                        		<button class="btn btn-sm btn-primary"  onclick="chooseOther()" type="button"><i class="fa fa-square-o"></i> 反选</button>
	                        		<button class="btn btn-sm btn-primary" onclick="deleteMutiDepts()" type="button"><i class="fa fa-times-circle-o"></i> 删除</button>
	                    
	                        	</div>
							<div class="col-sm-7 text-right">
								<div class="btn-group">

                                    <span>共有${pageInfo.pages}页,当前是第${pageInfo.pageNum}页</span>
                                    <a href='${pageContext.request.contextPath}/findAlldepts?pageNum=${pageInfo.firstPage}&pageSize=3'>首页</a>
                                    <a href='${pageContext.request.contextPath}/findAlldepts?pageNum=${pageInfo.prePage}&pageSize=3'>上一页</a>
                                    <a href='${pageContext.request.contextPath}/findAlldepts?pageNum=${pageInfo.nextPage}&pageSize=3'>下一页</a>
                                    <a href='${pageContext.request.contextPath}/findAlldepts?pageNum=${pageInfo.lastPage}&pageSize=3'>尾页</a>
	                            </div>
							</div>
                        </div>
                        </div>
                    </div>
                </div>
            </div>
            
	    	</div>
	
	</div>       
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
     <script src="js/plugins/select/bootstrap-select.min.js"></script>
    <script src="js/plugins/sweetalert/sweetalert.min.js"></script>

   <script>
     function deleteDeptById(id){
         swal({
             title: "您确定要删除这个部门吗",
             text: "删除后将无法恢复，请谨慎操作！",
             type: "warning",
             showCancelButton: true,
             confirmButtonColor: "#DD6B55",
             confirmButtonText: "删除",
             closeOnConfirm: false
         }, function () {//此函数是点击删除执行的函数
             $.ajax({
                 url:"deleteDeptById",
                 type:"POST",
                 data:{"id":id},
                 dataType:"json",
                 success:function (result){
                     if(result.msg){
                         swal(
                             {
                                 title:"提示信息",
                                 text:result.msg,
                                 type:"success",
                                 // imageUrl:"link",
                                 confirmButtonColor:"#AEDEF4", //确认按钮颜色
                                 showConfirmButton:true,
                                 confirmButtonText:"确定",
                             },
                             function(){
                                 window.location.href="${pageContext.request.contextPath}/findAlldepts";
                             }
                         );
                     }else{
                         swal(result.error)
                     }
                 }
             });
         });
     }
     function chooseAll() {
         var checknames = document.getElementsByName("checkName");
         for (var i = 0; i < checknames.length; i++) {
             checknames[i].checked ="checked";
         }
     }
     function chooseOther() {
         var checknames = document.getElementsByName("checkName");
         for (var i = 0; i < checknames.length; i++) {
             if(checknames[i].checked == false){
                 checknames[i].checked= true;
             }else{
                 checknames[i].checked = false;
             }
         }
     }

     function deleteMutiDepts(){

         swal({
             title: "您确定要删除这些部门吗",
             text: "删除后将无法恢复，请谨慎操作！",
             type: "warning",
             showCancelButton: true,
             confirmButtonColor: "#DD6B55",
             confirmButtonText: "删除",
             closeOnConfirm: false
         }, function () {//此函数是点击删除执行的函数
             var arr =[];
             var checks = document.getElementsByName("checkName");
             for(var i=0;i<checks.length;i++){
                 if(checks[i].checked){
                     var deptno=checks[i].parentNode.parentNode.children[1].innerHTML;
                     arr[i]=deptno;
                 }
             }
             var deptnos = arr.toString();
             $.ajax({
                 url: "deleteMutiDepts",
                 type:"POST",
                 dataType: "json",
                 data: {"deptnos":deptnos},
                 success:function (result){
                     if(result.msg){
                         swal(
                             {
                                 title:"提示信息",
                                 text:result.msg,
                                 type:"success",
                                 // imageUrl:"link",
                                 confirmButtonColor:"#AEDEF4", //确认按钮颜色
                                 showConfirmButton:true,
                                 confirmButtonText:"确定",
                             },
                             function(){
                                 window.location.href="${pageContext.request.contextPath}/findAlldepts";
                             }
                         );
                     }else{
                         swal(result.error)
                     }
                 }
             });
         });

     }
   </script>
</body>


</html>
    
