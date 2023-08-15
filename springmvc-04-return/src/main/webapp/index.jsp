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
   <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
    <script>
        $(function (){
            $("#btn").click(function (){
                // alert("button click")
                $.ajax({
                    url:"returnStringData.do",
                    data:{
                        name:"zhangsan",
                        age:20
                    },
                    type:"post",
                    // dataType:"json",
                    dataType:"text",
                    success:function (resp){
                        //[{"name":"张三","age":18},{"name":null,"age":null}]
                        // alert(resp.name+":"+resp.age)

                        alert("返回的是文本数据："+resp)
                    }
                })
            })
        })
    </script>
</head>
<body>
    <p>处理器方法返回String表示视图名称</p>

  <%--  <form action="/returnVoid.do" method="post">
        姓名：<input type="text" name="name"><br>
        年龄：<input type="text" name="age"><br>
        <input type="submit" value="提交参数">
    </form>--%>
    <br>
    <br>
    <button id="btn">发起ajax请求</button>

</body>
</html>
