<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   isELIgnored="false" pageEncoding="UTF-8"%>
 <!DOCTYPE html>
<html>


<!-- Mirrored from www.gzsxt.cn/theme/hplus/table_basic.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:20:01 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>绿地中央广场综合物业办公系统 - 基础表格</title>
    <meta name="keywords" content="综合办公系统">
    <meta name="description" content="综合办公系统">

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
    <div class="ibox float-e-margins">
                   <div class="ibox-content">
                        <div class="row">
                        		<div class="col-sm-3 col-sm-offset-2 text-right">
                        			<h3><small>搜索条件:</small></h3>
                        		</div>
                            <form action="serachAllEmpWithCondition" method="post">
                            <div class="col-sm-2">
                                <select  name="type" class="selectpicker form-control">
                                    <option  value="0">选择查询类型</option>
                                    <option  value="1">姓名</option>
                                    <option  value="2">部门</option>
                                    <option  value="3">性别</option>
                                    <option  value="4">年龄</option>
                                    <option  value="5">联系电话</option>
                                </select>
                            </div>
                           
                            <div class="col-sm-3">
                                <div class="input-group">
                                    <input type="text" name="condition" placeholder="请输入关键词" class="input-sm form-control">
                                    <span class="input-group-btn">
                                        <button type="submit" class="btn btn-sm btn-primary"><i class="fa fa-search"></i>搜索</button>
                                    </span>
                                </div>                                
                            </div>
                            </form>
                            <div class="col-sm-2 text-right">
                            	 <a href="${pageContext.request.contextPath}/loadDeptsAndRoles"  class="btn btn-sm btn-primary" type="button"><i class="fa fa-plus-circle"></i> 添加员工</a>
                            </div>
                        </div>
                        <div class="hr-line-dashed2"></div>
                        <div class="table-responsive">
                            <table class="table table-striped list-table">
                                <thead>
                                    <tr>
                                        <th>选择</th>
                                        <th>序号</th>
                                        <th>姓名</th>
                                        <th>部门</th>
                                        <th>性别</th>
                                        <th>年龄</th>
                                        <th>联系电话</th>
                                        <th>入职时间</th>
                                        <th class="text-center">操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${pageInfo.list}" var="item" varStatus="vs">
                                    <tr>
                                        <td><input  type="checkbox" name="checkName" value="${item.eid}" ></td>
										<td>${vs.count}</td>
										<td>${item.ename}</td>
										<td>
                                            <c:forEach items="${depts}" var="dept">
                                                <c:if test="${item.dfk == dept.deptno}">
                                                    ${dept.dname}
                                                </c:if>
                                            </c:forEach>
                                        </td>
										<td>${item.esex}</td>
										<td>${item.eage}</td>
										<td>${item.telephone}</td>
										<td><fmt:formatDate value="${item.hiredate}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
                                        <td class="text-center">
	                                       <a href="${pageContext.request.contextPath}/loadEmpsAndDeptsAndRoles?eid=${item.eid}" class="btn btn-primary btn-xs"><i class="fa fa-edit"></i>编辑</a>
	                                       <button onclick="deleteEmp(${item.eid})" class="btn btn-danger btn-xs btndel"><i class="fa fa-close"></i>删除</button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                       
                        <div class="row">
	                        	<div class="col-sm-5">
	                        		<button class="btn btn-sm btn-primary" onclick="chooseAll()" type="button"><i class="fa fa-check-square-o"></i> 全选</button>
	                        		<button class="btn btn-sm btn-primary" onclick="chooseOther()" type="button"><i class="fa fa-square-o"></i> 反选</button>
	                        		<button class="btn btn-sm btn-primary" onclick="deleteMutiEmps()" type="button"><i class="fa fa-times-circle-o"></i> 删除</button>
	                        		<button id="demo1" class="btn btn-sm btn-primary" type="button"><i class="fa fa-table"></i> 导出Excel</button>
	                        	</div>
							<div class="col-sm-7 text-right">

                                <span>共有${pageInfo.pages}页,当前是第${pageInfo.pageNum}页</span>
                                <a href='${pageContext.request.contextPath}/findAllEmps?pageNum=${pageInfo.firstPage}&pageSize=10'>首页</a>
                                <a href='${pageContext.request.contextPath}/findAllEmps?pageNum=${pageInfo.prePage}&pageSize=10'>上一页</a>
                                <a href='${pageContext.request.contextPath}/findAllEmps?pageNum=${pageInfo.nextPage}&pageSize=10'>下一页</a>
                                <a href='${pageContext.request.contextPath}/findAllEmps?pageNum=${pageInfo.lastPage}&pageSize=10'>尾页</a>
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
	function deleteEmp(eid){
        swal({
            title: "您确定要删除该角色吗？",
            text: "修改后将无法恢复，请谨慎操作！",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "删除",
            closeOnConfirm: false
        }, function () {//此函数是点击删除执行的函数
            $.ajax({
                url:"deleteEmpByEid",
                type:"POST",
                data:{"eid":eid},
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
    function deleteMutiEmps(){

        swal({
            title: "您确定要删除这些角色吗",
            text: "删除后将无法恢复，请谨慎操作！",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "删除",
            closeOnConfirm: false
        }, function () {//此函数是点击删除执行的函数
            var arr =[];
            $('input[name="checkName"]:checked').each(function(){//checkName，其中选中的执行函数
                arr.push($(this).val());//将选中的值添加到数组arr中
            });
            var emps = arr.toString();
            $.ajax({
                url: "deleteMutiEmps",
                type:"POST",
                dataType: "json",
                data: {"emps":emps},
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
    