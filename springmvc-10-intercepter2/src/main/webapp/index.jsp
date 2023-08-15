<%--
  Created by IntelliJ IDEA.
  User: 吾空白
  Date: 2023/2/19
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+
            request.getContextPath()+"/";
%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="static/js/jquery-3.6.0.min.js"></script>
</head>
<body>
    <p>一个拦截器</p>


    <form action="some.do" method="post">
        姓名：<input type="text" name="name"><br>
        年龄：<input type="text" name="age"><br>
        <input type="submit" value="提交请求">
    </form>
    <br>
    <img src="static/images/1.jpg" alt="我是一个静态资源，不能显示">


</body>
</html>
