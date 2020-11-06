<%--
  Created by IntelliJ IDEA.
  User: 28686
  Date: 2020/9/24
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>--%>
<script src="js/jquery-3.4.1.js"></script>
<script src="js/jquery.validate.js"></script>
<html>
<head>
    <link rel="stylesheet" href="/css/style.css">
    <title>Title</title>
</head>
<body>

    <a href="helloController">Hello SprintMVC</a>
    <a href="helloController3">Hello SprintMVC1</a>
    <%--<form action="/helloController2" method="post">
        id<input type="text" name="id"><br>
        name<input type="text" name="name"><br>
        roder1<input type="text" name="orders[0].oid"><br>
        <input type="text" name="orders[0].odis"><br>
        <input type="text" name="orders[0].onum"><br>
        roder2<input type="text" name="orders[1].oid"><br>
        <input type="text" name="orders[1].odis"><br>
        <input type="text" name="orders[1].onum"><br>
        <button>提交</button>
    </form>--%>
    <form action="/helloController2" method="post">
        oid<input type="text" name="oid"><br>
        odis<input type="text" name="odis"><br>
        onum<input type="text" name="onum"><br>
        brithday<input type="text" name="brithday"><br>
        <button>提交</button>
    </form>
<script>
    $(function(){
        alert("123456")
    })
</script>
</body>
</html>
