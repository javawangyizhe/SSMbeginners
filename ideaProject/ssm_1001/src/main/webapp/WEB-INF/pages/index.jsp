<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 28686
  Date: 2020/10/5
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Basic CRUD Application - jQuery EasyUI CRUD Demo</title>
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
</head>
<body>
<h2>基础CRUD操作</h2>
<div id="show"><a id="reload" href="/findAllStudent">自动跳转</a></div>
<table id="dg" title="Student" class="easyui-datagrid" style="width:700px;height:250px"
       url="get_users.php"
       toolbar="#toolbar" pagination="true"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="sid" width="50">学生id</th>
        <th field="sname" width="50">学生姓名</th>
        <th field="saddress" width="50">学生住址</th>
        <th field="ssex" width="50">学生性别</th>
        <th field="sage" width="50">学生年龄</th>
    </tr>
    </thead>
    <c:forEach items="${list}" var="list" varStatus="student">
        <tr>
            <td>${list.sid}</td>
            <td>${list.sname}</td>
            <td>${list.saddress}</td>
            <td>
                <c:if test="${list.ssex==1}">男</c:if>
                <c:if test="${list.ssex==0}">女</c:if>
            </td>
            <td>${list.sage}</td>
        </tr>
    </c:forEach>
</table>
<div id="toolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加学生信息</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改学生信息</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除学生信息</a>
</div>

<div id="dlg" class="easyui-dialog" style="width:400px" data-options="closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'">
    <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px" >
        <h3>学生信息</h3>
        <div style="margin-bottom:10px">
            <input name="sname" class="easyui-textbox" required="true" label="学生姓名:" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="saddress" class="easyui-textbox" required="true" label="学生住址:" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            学生性别:
            <input type="radio"   required="true" name="ssex" value="1">男
            <input type="radio"  required="true" name="ssex" value="0">女
        </div>
        <div style="margin-bottom:10px">
            <input name="sage" class="easyui-textbox" required="true" label="学生年龄:" style="width:100%">
        </div>
    </form>
</div>
<div id="dlg-buttons">
    <a href="/findAllStudent" id="save" class="easyui-linkbutton c6" iconCls="icon-ok"  style="width:90px">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
</div>
<script type="text/javascript">
    document.getElementById("show").style.display = "none";
    var url;
    function newUser(){
        $('#dlg').dialog('open').dialog('center').dialog('setTitle','新学生信息');
        $('#fm').form('clear');
        $("#save").click(function(){
           var formObject = {};
           var formArray =$("#fm").serializeArray();
           $.each(formArray,function(i,item){
                formObject[item.name] = item.value;
            });
           $.ajax({
              url:"/insertStudent",
              type:"post",
              contentType:"application/json",
              data:JSON.stringify(formObject),
              dataType: "json",
              success:function (obj) {
                  document.getElementById("reload").click();
              }
           });
        });
    }
    function editUser(){
        var row = $('#dg').datagrid('getSelected');
        if (row){
            $('#dlg').dialog('open').dialog('center').dialog('setTitle','修改学生信息');
            $('#fm').form('load',row);
            $("#save").click(function(){
                var formObject = {};
                var formArray =$("#fm").serializeArray();
                formArray.push({"name":"sid","value":row.sid})
                $.each(formArray,function(i,item){
                    formObject[item.name] = item.value;
                });
                $.ajax({
                    url:"/updateStudent",
                    type:"post",
                    contentType:"application/json",
                    data:JSON.stringify(formObject),
                    dataType: "json",
                    success:function (obj) {
                        document.getElementById("reload").click();
                    }
                });
            });
        }
    }
    function destroyUser(){
        var row = $('#dg').datagrid('getSelected');
        if (row){
            $.messager.confirm('Confirm','Are you sure you want to destroy this user?',function(r){
                if (r){
                    $.ajax({
                        url:"/deleteStudent",
                        data:{
                            "id":row.sid
                        },
                        success:function (obj) {
                            document.getElementById("reload").click();
                        }
                    });
                }
            });
        }
    }
</script>
</body>
</html>