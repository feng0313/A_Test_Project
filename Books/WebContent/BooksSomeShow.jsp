<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%

String path = request.getContextPath();

String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>

<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">

<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>

<html>

  <head>

    <base href="<%=basePath%>">

    <title>图书页面</title>

  </head>

  

<script>

$(function(){

    $("a").addClass("btn btn-default btn-xs");

     

});

function del(){

	var d=confirm("确定删除吗？");

	if(d){

		return true;

	}

	else{

		return false;

	}

}

</script>

  

  <body>

  <h1>${xiaoxi}</h1>

  <table  width="1200" border="1" cellpadding="0" class="table table-striped table-bordered table-hover  table-condensed" align='center'>

  		<tr>

  			<th>ID</th>

	  		<th>图书编号</th>

	  		<th>书名</th>

			<th>出版社</th>

	  		<th>作者</th>

	  		<th>状态</th>

	  		<th>删除</th>

	  		<th>编辑</th>

  		</tr>

     <c:forEach var="B" items="${bookSome}"  > 

      <form action="BooksUpdateServlet" method="post"> 

       <tr>

	       <td>${B.id}</td>

	       <td>${B.num}</td>

	       <td>${B.bookname}</td>

	       <td>${B.publish}</td>

	       <td>${B.author}</td>

	       <td>${B.status}</td>

	       

	       <td><a href="BooksDeleteServlet?id=${B.id}" onclick="javascript:return del()">删除</a>  

	       <td><input type="submit" value="编辑"/></td>

	   </tr>

    </form> 

    </c:forEach>  

 

    </table>

  </body>

</html>
