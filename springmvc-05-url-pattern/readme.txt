ch05-url-pattern: 研究中央调度器的url-pattern设置为 "/"


发送的请求都是由哪些服务器处理的
tomcat本身能处理静态资源的访问，像html,图片，js文件都是静态资源



在jsp,html中试音的地址，都是在前端页面中的地址，都是相对地址
地址分类：
1.绝对地址,带有协议名称的是绝对地址，http://www.baidu.com,ftp://202.122.23.1
2.相对地址，没有协议开头的，例如user/some.do,/user/some.do
相对地址不能独立使用，必须有一个参考地址，通过参考地址+相对地址本身才能指定资源

3.参考地址
在你的页面中的，访问地址不加"/"

http://localhost:8080/springmvc_05/some
路径：http://localhost:8080/springmvc_05/
资源：some

http://localhost:8080/springmvc_05/index.jsp
1.当你的地址没有斜杠开头，例如user/some.do,当你点击链接时，访问地址是当前页面的地址
加上链接的地址
http://localhost:8080/springmvc_05/+user/some.do

2.在你的页面中，访问的地址加"/"
访问的是：http://localhost:8080/springmvc_05/index.jsp
路径：http://localhost:8080/springmvc_05/
资源：index.jsp
点击/user/some.do访问的地址变为http://localhost:8080/user/some.do
参考地址是你的服务器的地址，也就是http://localhost:8080

3.index.jsp 访问user/some.do,放回后现在的地址：http://localhost:8080/springmvc_05/user/some.do
路径：http://localhost:8080/springmvc_05/user/
资源：some.do

在index.jsp在user/some.do,就变为http://localhost:8080/springmvc_05/user/user/some.do 错误

解决方案
1.加入${pageContext.request.contextPath}
2.加入一个base标签，是html语言中的标签。表示当前页面中的访问地址的基地址
你的页面中所有没有"/"开头 的地址，都是以base标签中的地址为参考地址
使用base中的地址+user/some.do组成访问的地址
