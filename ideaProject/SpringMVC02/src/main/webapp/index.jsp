<%--
  Created by IntelliJ IDEA.
  User: 28686
  Date: 2020/9/25
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="/hello">1、点击跳转</a><br>
    <a href="/hello2">2、点击跳转</a><br>
    <a href="/hello3">3、点击跳转</a><br>
    <a href="/hello4">4、点击跳转</a><br>
    <a href="/hello5">5、点击跳转</a><br>
    <a href="/hello6">6、点击跳转</a><br>
    <a href="/hello7">7、点击跳转</a><br>
    <a href="/hello8">8、点击跳转</a><br>
    <a href="/hello9">9、点击跳转</a><br>
    <a href="/hello10">10、点击跳转</a><br>
    <form action="/hello11" method="get">
        name<input type="text" name="name">
        id<input type="text" name="id">
        <button>提交</button>
    </form><br>
    <form action="/hello12" method="post">
        name<input type="text" name="name">
        id<input type="text" name="id">
        <button>提交</button>
    </form><br>
    <form action="/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <input type="submit" value="提交">
    </form><br>
    <a href="/download">下载</a>
</body>
</html>
