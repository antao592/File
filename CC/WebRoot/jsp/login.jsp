<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>登录</title>
  </head>
  
  <body>
    <form action="login.do" method="get">
   	 用户:<input id="username" name="username" type="text" />
   	 密码:<input id="password" name="password" type="password" />
   	 <button type="submit">提交</button>
    </form>
  </body>
</html>
