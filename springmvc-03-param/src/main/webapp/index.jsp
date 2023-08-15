<%--
  Created by IntelliJ IDEA.
  User: 吾空白
  Date: 2023/2/19
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>接收参数给Controller</p>

    <form action="user/other.do" method="post">
        姓名：<input type="text" name="rname"><br>
        年龄：<input type="text" name="rage"><br>
        <input type="submit" value="提交参数">
    </form>


    <p>使用java对象接收请求参数</p><br>
    <form action="user/from.do" method="post">
        姓名：<input type="text" name="name"><br>
        年龄：<input type="text" name="age"><br>
        <input type="submit" value="提交参数">
    </form>

</body>
</html>
