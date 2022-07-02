<%@ page language="java" import="java.util.*"
         contentType="text/html; charset=utf-8" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
          + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">

  <title>学生成绩管理系统</title>
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">

  <!-- <link rel="stylesheet" type="text/css" href="styles.css"> -->
  <style type="text/css">
    p,input,label,select,button{
      font-size:20px;
    }
    html{
      width: 100%;
      height: 100%;
      overflow: hidden;
      font-style: sans-serif;
    }
    body{
      width: 100%;
      height: 100%;
      margin: 0;
      background: #00FFCC;
    }
    #login {
      width:400px;
      margin:100px auto;
      /*	color:red;
           border:1px solid #F00; */
      background-color:#666666;
      padding:10px 0;
    }
    h1 {
      padding:20px 0px 0 0;
      text-align: center;
      color:black;
    }
    label {
      color:#FFFF00;
    }
    .input {
      border:0px;
      width:100%;
      border-radius:3px;
      padding:5px;
    }
    button {
      width:40%;
      border:0;
      border-radius: 5px;
      padding: 5px;
    }
    p {
      padding: 0px 30px 5px 30px;
    }
  </style>
</head>

<body>
<div id="login">
  <h1>欢迎登录</h1>
  <form action="login_handle.jsp" method="get">
    <!-- required表示该字段必填 -->
    <p><input class="input" type="text" placeholder="用户名" required="required" name="username"  /></p>
    <p><input class="input" type="password" placeholder="密码" required="required" name="password" /></p>
    <p id="button"><button type="submit">登录</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <button type="reset">重置</button>
    </p>
  </form>
</div>
</body>
</html>