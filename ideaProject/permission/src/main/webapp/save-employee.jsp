<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>办公系统 - 基础表格</title>
    <meta name="keywords" content="办公系统">
    <meta name="description" content="办公系统">

    <link rel="shortcut icon" href="favicon.ico"> 
    	<link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="css/plugins/select/bootstrap-select.min.css" rel="stylesheet">
	<link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        
      <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>员工管理<small>>修改信息</small></h5>
                    </div>
                    <div class="ibox-content">
                        <form id="saveEmpForm" method="get" action="#" class="form-horizontal">
                       	<div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">姓名</label>
                                <div class="col-sm-3">
                                    <input name="ename" type="text" class="form-control input-sm">
                                </div>
                                <label class="col-sm-2 col-sm-offset-1 control-label">用户名</label>
                                <div class="col-sm-3">
                                    <input name="username" type="text" class="form-control input-sm">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">密码</label>
                                <div class="col-sm-3">
                                    <input name="password" type="text" class="form-control input-sm">
                                </div>
                                <label class="col-sm-2 col-sm-offset-1 control-label">性别</label>
                                <div class="col-sm-3">
                                    <select name="esex" class="selectpicker form-control">
										<option>男</option>
										<option>女</option>
									</select>
                                </div>                     
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">身份证号码</label>
                                <div class="col-sm-3">
                                    <input name="pnum" type="text" class="form-control input-sm">
                                </div>
                                <label class="col-sm-2 col-sm-offset-1 control-label">联系电话</label>
                                <div class="col-sm-3">
                                    <input name="telephone" type="text" class="form-control input-sm">
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                              <label class="col-sm-2 control-label">部门</label>
                                <div class="col-sm-3">
                                    <select name="dfk" class="selectpicker form-control">
										<c:forEach items="${depts}" var="item">
                                            <option value="${item.deptno}">${item.dname}</option>
                                        </c:forEach>
									</select>
                                </div>
                            <div class="form-group">
                                <label class="col-sm-2 col-sm-offset-1 control-label">入职时间</label>
                                <div class="col-sm-3">
                                    <input name="hiredate" placeholder="yyyy/MM/dd">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                              <div class="form-group">
                                <label class="col-sm-2 control-label">年龄</label>
                                <div class="col-sm-3">
                                    <input name="eage" type="text" class="form-control input-sm">
                                </div>
                                <label class="col-sm-2 col-sm-offset-1 control-label">角色</label>
                                <div class="col-sm-3">
                                    <select name="roleid" class="selectpicker form-control">
                                        <c:forEach items="${roles}" var="item">
                                            <option value="${item.roleid}">${item.rolename}</option>
                                        </c:forEach>
									</select>
                                </div>                     
                            </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">备注</label>
                                <div class="col-sm-9">
                                    <textarea name="remark" class="form-control"></textarea>
                                </div>
                                
                            </div>
                        </div>
                        
                     	<div class="row">
                     		<div class="hr-line-dashed"></div>
                     	</div>
                          
                         <div class="row">
                            <div class="form-group">
                                <div class="col-sm-3 col-sm-offset-3 text-right">
                                    <button type="button" onclick="saveEmployee()" class="btn btn-primary"><i class="fa fa-save"></i> 保存内容</button>
                                </div>
                                <div class="col-sm-3">
                                	<a href="${pageContext.request.contextPath}/findAllEmps" class="btn btn-white"><i class="fa fa-reply"></i> 返回</a>
                                	</div>
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
    <script src="js/plugins/sweetalert/sweetalert.min.js"></script>
	<script src="js/plugins/select/bootstrap-select.min.js"></script>
	<script src="js/plugins/layer/laydate/laydate.js"></script>
   <script>
       function saveEmployee(){
           $.ajax({
               url:"insertEmp",
               type:"POST",
               data:$("#saveEmpForm").serialize(),
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
                               window.location.href="${pageContext.request.contextPath}/findAllEmps";
                           }
                       );
                   }else {
                       swal(result.error);
                   }
               }
           });
       }
   </script>

</body>


</html>
    