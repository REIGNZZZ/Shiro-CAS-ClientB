<%--
  Created by IntelliJ IDEA.
  User: REIGNZZZ
  Date: 2020/6/30
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>登录页</title>
</head>
<body>
<div align="center">
    <form action="${pageContext.request.contextPath}/shiros/login.do" method="post">
        用户名：<input type="text" name="username"><br><br>
        密&nbsp;&nbsp;&nbsp;码：<input id="pwd" type="password" name="password"><br><br>
        <input type="submit" value="登录">
    </form>
    <br><br>
</div>
</body>
</html>
