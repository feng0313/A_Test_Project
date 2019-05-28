
<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

 

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

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>登录页面</title>

</head>

 

<script type="text/javascript">

$(function(){

    $("a").addClass("btn btn-default btn-xs");

     

});

function update(){

	var d=confirm("确定更新吗？");

	if(d){

		document.getElementById('form1').submit();

	}

	else{

		

	}

}

</script>

<body>

<form action="BookesRegister.html" method="post" align="center">

<input type="submit" value="新建图书" >

</form>

  <form action="BooksSomeSearchServlet" method="post" align="center">

<input type="text" name="num">

<input type="submit" value="搜索图书">

</form>

      

<table  width="1000" border="1" cellpadding="0" class="table table-striped table-bordered table-hover  table-condensed" align='center'>

  		<tr>

  			<th>ID</th>

	  		<th>图书编号</th>

	  		<th>书名</th>

			<th>出版社</th>

	  		<th>作者</th>

	  		<th>状态</th>

	  		<th>确定</th>

  		</tr>

<c:forEach var="B" items="${bookAll}"  > 

<form action="BooksUpdateServlet?id=${B.id}" method="post" id="form1"> 

      	<tr>

			<td>${B.id}</td>

			<td><input type="text" name="num" value="${B.num}"></td>

			<td><input type="text" name="bookname" value="${B.bookname}"></td>

			<td><input type="text" name="publish" value="${B.publish}"></td>

			<td><input type="text" name="author" value="${B.author}"></td>

			<td><input type="text" name="status" value="${B.status}"></td>

			<td><a  onclick="update()">确定</a></td>

		</tr>

      </form>

		

    </c:forEach> 

 

    <tr>

    	<td colspan="7" align="center">

    		<a href="BooksBianjiServlet?start=0">[首  页]</a>

    		<a href="BooksBianjiServlet?start=${pre}">[上一页]</a>

    		<a href="BooksBianjiServlet?start=${next}">[下一页]</a>

    		<a href="BooksBianjiServlet?start=${last}">[末  页]</a>

    	</td>

    </tr>

 

 

</table>

 

</body>

</html>
