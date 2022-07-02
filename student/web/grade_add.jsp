<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加学生成绩</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<style type="text/css">
		body{
			width: 100%;
			height: 100%;
			margin: 0;
			background: #00FFCC;
		} 
		p {
			text-align:center;
		}
		h1 {
			margin-top:100px;
			text-align:center;
		}
		#sub {
			margin: 20px auto; 
			width:100px;
			height:25px;
		}
		a {
			font-size:1.2em;
			color:pink;
		}

	</style>

  </head>
  <%
	  request.setCharacterEncoding("utf-8");
  	  response.setContentType("text/html;charset=UTF-8");
  	  String studentNumStr = request.getParameter("studentNumStr");//获取学号是否重复提示，没有重复就空
	  if ("1".equals(studentNumStr)) {
	  	  studentNumStr = "当前学号已存在，不能重复添加！";
	  } else {
		  studentNumStr = "";
	  }
   %>

  <body>
  	<h1>添加学生成绩</h1>
	<p><label style="color: #ff0000"><%=studentNumStr %></label></p>
  	<form action="servlet/GradeServlet?action=add" method="post">
  		<p>学号：<input required="required" name="studentNum" />
  		<p>姓名：<input required="required" name="fullName" />
		<p>班级：<input required="required" name="className" />
		<p>课程：<input required="required" name="courseName" />
		<p>成绩：<input required="required" name="gradeValue" />
		<p><input id="sub" type="submit" value="添加"></p>
  	</form>
  	<p><a href="grade.jsp">[返回成绩列表]</a></p>
  </body>
</html>
