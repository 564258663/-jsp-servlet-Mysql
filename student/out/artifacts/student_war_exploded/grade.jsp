<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="com.demo.model.*" %>
<jsp:useBean id="courseDao" class="com.demo.dao.GradeDao" />
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>成绩列表</title>

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
        h1,form {
            text-align:center;
        }
        table {
            border-collapse:collapse;
            margin:0px auto;
            text-align:center;
            font-size:1.2em;
        }
        p {
            font-size:1.2em;
            text-align:center;
        }
        .input {
            border:0px;
            width:120px;
            border-radius:3px;
            padding:5px;
        }
    </style>

</head>

<body>
<%
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=UTF-8");
%>


<table border="1px" cellspacing="10px" width="600px" bgcolor="#87ceeb" >
    <tr><td colspan="7"><h3>学生成绩管理系统</h3></td></tr>
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>所在班级</td>
        <td>课程名</td>
        <td>成绩</td>
        <td>更新</td>
        <td>删除</td>
    </tr>

    <%
        //String[] color = {"#87ceeb", "green"};
        int orderType = 1;//默认按照学号从小到大
        if (request.getParameter("orderType") != null) {
            orderType = Integer.parseInt(request.getParameter("orderType"));//获取排序字段
        }
        ArrayList<Grade> list = courseDao.getAll(orderType);

        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Grade grade = list.get(i);
    %>
    <%-- <tr bgcolor="<%=color[i%2] %>" >  --%>
    <tr>
        <td><%=grade.getStudentNum() %></td>
        <td><%=grade.getFullName() %></td>
        <td><%=grade.getClassName() %></td>
        <td><%=grade.getCourseName() %></td>
        <td><%=grade.getGradeValue() %></td>

        <td><a href="grade_update.jsp?id=<%=grade.getId() %>">更新</a></td>
        <td><a href="servlet/GradeServlet?action=delete&id=<%=grade.getId() %>">删除</a></td>
    </tr>

    <%
            }
        }
    %>
</table>

<p>
<form action="grade.jsp" method="post">
    <select name="orderType" style="height: 30px; width: 120px" >
        <option value="1">学号从小大</option>
        <option value="2">学号从大到小</option>
        <option value="3">成绩从小到大</option>
        <option value="4">成绩从大到小</option>
    </select>
    &nbsp;&nbsp;
    <input id="sub" class="input" type="submit" value="根据选择字段排序">

    &nbsp;&nbsp;&nbsp;&nbsp;
    <a href="grade_add.jsp" >添加成绩</a>

    &nbsp;&nbsp;&nbsp;&nbsp;
    <a href="login.jsp" >退出登录</a>
</form>

</p>
</body>
</html>
