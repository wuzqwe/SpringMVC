<%--
  Created by IntelliJ IDEA.
  User: 吾空白
  Date: 2023/3/5
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
欢迎来到我的世界
<h3>数据:${param.myname}</h3><br>
<h3>fun:${param.myage}</h3>
<h3>=取参数数据：<%=request.getParameter("myname")%></h3>
</body>
</html>
