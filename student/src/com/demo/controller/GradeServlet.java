package com.demo.controller;


import com.demo.dao.GradeDao;
import com.demo.model.Grade;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 成绩管理主类
 * 页面调用逻辑，包含新装，删除，修改等页面的调用
 * hyy 0615
 */
public class GradeServlet extends HttpServlet {

	/**
	 * Servlet类
	 */
	public GradeServlet() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * 调用get请求
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取post请求参数
		String action = request.getParameter("action");
		/*String path = request.getContextPath();
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();*/
		//成绩Dao
		GradeDao gradeDao = new GradeDao();
		if ("delete".equals(action)) {
			// 根据id删除成绩
			gradeDao.deleteById(Integer.parseInt(request.getParameter("id")));
			//刷新成绩页面
	  		response.sendRedirect("../grade.jsp");
		} else if ("update".equals(action)) {
			// 更新成绩
			Grade grade = new Grade();
			grade.setId(Integer.parseInt(request.getParameter("id")));
			grade.setGradeValue(Float.parseFloat(request.getParameter("gradeValue") != null ? request.getParameter("gradeValue") : "0"));
			gradeDao.update(grade);
	  		response.sendRedirect("../grade.jsp");
		} else if ("add".equals(action)) {//如果是新增
			//判断id是否为空
			int id = gradeDao.getByStudentNum(request.getParameter("studentNum"));
			if (id != 0) {
				response.sendRedirect("../grade_add.jsp?studentNumStr=1");
			} else {
				Grade grade = new Grade();
				grade.setStudentNum(request.getParameter("studentNum"));
				grade.setFullName(request.getParameter("fullName"));
				grade.setClassName(request.getParameter("className"));
				grade.setCourseName(request.getParameter("courseName"));
				grade.setGradeValue(Float.parseFloat(request.getParameter("gradeValue")));
				gradeDao.add(grade);

				response.sendRedirect("../grade.jsp");
			}
		} 
	}

	/**
	 * 初始化加载方法
	 * @throws ServletException
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
