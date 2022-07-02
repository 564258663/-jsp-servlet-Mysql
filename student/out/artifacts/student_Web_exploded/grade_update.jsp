<%@ page language="java" import="java.util.*,com.demo.model.Grade" contentType="text/html; charset=utf-8"%>
<%@ page import="com.demo.model.Grade" %>
<jsp:useBean id="gradeDao" class="com.demo.dao.GradeDao" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<style type="text/css">
		body {
			width: 100%;
			height: 100%;
			margin: 0;
			background: #00FFCC;
		}
		form {
			text-align:center;
			margin:30px auto;
			width:400px;
			border:1px solid #000;
		}

	</style> 

  </head>
  
  <body>
  	<%
  		request.setCharacterEncoding("utf-8"); 
  		response.setContentType("text/html;charset=UTF-8");
  		int id = Integer.parseInt(request.getParameter("id"));
  		Grade grade = gradeDao.getById(id);
  	 %>
  	<form action="servlet/GradeServlet?action=update&id=<%=id %>" method="post">
  		<p><h2>修改成绩</h2></p>
  		<p><label>原来的成绩：</label>
  		<input type="text" value="<%=grade.getGradeValue() %>"></p>
		<p><label>修改后的成绩：</label>
			<input type="text" name="gradeValue" ></p>
  		<p><input type="submit" value="更新"></p>
  	</form>
     
  </body>
</html>
