<%--
  Created by IntelliJ IDEA.
  User: 吾空白
  Date: 2023/3/4
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+
            request.getContextPath()+"/";
%>
<html>
<head>
    <title>参询学生ajax</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
       $(function (){
           //在当前页面dom对象加载后，执行loadStudentData函数
           loadStudentData()
           $("#btnLoader").click(function (){
             loadStudentData()
           })
       })

       function loadStudentData(){
           $.ajax({
               url:"student/queryStudent.do",
               type:"get",
               dataType:"json",
               success:function (resp){
                   //清除就数据
                   $("#info").html("")
                   //增加新数据
                   $.each(resp,function (i,n){
                       $("#info").append("<tr>")
                           .append("<td>"+n.id+"</td>")
                           .append("<td>"+n.name+"</td>")
                           .append("<td>"+n.age+"</td>")
                           .append("</tr>")
                   })
               }
           })
       }
    </script>
</head>
<body>
    <div align="center">
        <table>
            <thead>
            <tr>
                <td>学号</td>
                <td>姓名</td>
                <td>年龄</td>
            </tr>
            </thead>
            <tbody id="info">

            </tbody>
        </table>
        <input type="button" id="btnLoader" value="查询学生信息">
    </div>
</body>
</html>
