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

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>编辑页面</title>

</head>

 

<script type="text/javascript">

$(function(){

    $("a").addClass("btn btn-default btn-xs");

     

});

function check(){

	var d=confirm("确定新建吗？");

	if(d){

		document.getElementById('form1').submit();  //document.getElementById取id，用submit提交表单

	}

	else{

 

	}

}

 

</script>

<body>

 

<form action="BooksRegisterServlet" method="post" id="form1">

<table  width="1200" border="1" cellpadding="0" class="table table-striped table-bordered table-hover  table-condensed" align='center'>

  		<tr>

	  		<th>图书编号</th>

	  		<th>书名</th>

			<th>出版社</th>

	  		<th>作者</th>

	  		<th>状态</th>

	  		<th>确定</th>

	  		<th>重置</th>

  		</tr>

  		

		<tr>

			<td><input type="hidden" name="qwer"></td>

			<td><input type="text" name="num"></td>

			<td><input type="text" name="bookname"></td>

			<td><input type="text" name="publish"></td>

			<td><input type="text" name="author"></td>

			<td><select name="status"><option value="在库" selected>在库</option><option value="出借">出借</option></select></td>

			<td><a   onclick="check()">确定</a>  </td>

			<td><input type="reset" value="重置"></td>

		</tr>

 

 

</table>

</form>

</body>

</html>
