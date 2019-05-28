<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%-- 调用了一个jsp类包，prefix="c"表示后续皆以"<c:"开头 --%>
<%

String path = request.getContextPath();

String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script> <!-- 这三个是用bootstrap中用来美化界面的 -->

<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">

<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>

<html>

  <head>

    <base href="<%=basePath%>">

    <title>图书页面</title>

  </head>

 

  <script>

$(function(){

    $("a").addClass("btn btn-default btn-xs");   //bootstrap中用来美化按钮的

});

function del(){             //点击删除后会弹出一个确认框confirm，返回值为true和false，用来判断后续操作是否进行删除

	var d=confirm("确定删除吗？");

	if(d){

		return true;

	}

	else{

		return false;

	}

}

function open_win(){  //打开一个新的窗口，具体属性参考w3school

	window.open("BooksBianjiServlet","_blank","toolbar=yes, location=yes, directories=no, status=no, menubar=yes, scrollbars=yes, resizable=no, copyhistory=yes, width=1300, height=600,left=150,top=100")

} 

</script>

  <body>

  <h1>${xiaoxi}</h1>  <!-- 从上一个servlet中传来的参数为“xiaoxi”的值显示到此处 -->

  <form action="BooksRegister.jsp" method="post" align="center">   <!-- action表示表单提交的动作，以post形式进行数据提交 -->

<input type="submit" value="新建图书" >

</form>

  <form action="BooksSomeSearchServlet" method="post" align="center">

<input type="text" name="num">

<input type="submit" value="搜索图书">

</form>

        <form action="BooksUpdateServlet" method="post"> 

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

     <c:forEach var="B" items="${bookAll}"  >     <!-- 可理解为一个加强型的for循环，重复打印一个表格出来。传过来的数据为bookAll，用B来代替-->

 

       <tr>

	       <td>${B.id}</td>    <!-- 对上一个servlet的页面传过来的参数进行取值 -->

	       <td>${B.num}</td>

	       <td>${B.bookname}</td>

	       <td>${B.publish}</td>

	       <td>${B.author}</td>

	       <td>${B.status}</td>

 

	       <td><a href="BooksDeleteServlet?id=${B.id}" onclick="javascript:return del()">删除</a></td>  

	       <!-- 用onclick事件触发js中的del函数，若返回值为false，则不会进行前一步的链接跳转；若为true，则跳转到BooksDeleteServlet，并将id的值传给它 -->

	       <td><a href="javacript:void(0)" onclick="open_win()">编辑</a></td>

	   </tr>

  

    </c:forEach>  

    

    <tr>

    	<td colspan="8" align="center">

    		<a href="BookesAllSearchServlet?start=0">[首  页]</a>

    		<a href="BookesAllSearchServlet?start=${pre}">[上一页]</a>

    		<a href="BookesAllSearchServlet?start=${next}">[下一页]</a>

    		<a href="BookesAllSearchServlet?start=${last}">[末  页]</a>

    	</td>

    </tr>

    </table>

      </form> 

  </body>

</html>
