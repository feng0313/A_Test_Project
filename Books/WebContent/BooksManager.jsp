<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%

String path = request.getContextPath();

String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>登录页面</title>

</head>

<body>

${xiaoxi} <br> 

 

 

<form action="BookesAllSearchServlet" method="post" align="center">

<input type="submit" value="查看所有图书">

</form>

 

 

</body>

</html>
