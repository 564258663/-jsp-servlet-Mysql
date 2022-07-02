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
 * �ɼ���������
 * ҳ������߼���������װ��ɾ�����޸ĵ�ҳ��ĵ���
 * hyy 0615
 */
public class GradeServlet extends HttpServlet {

	/**
	 * Servlet��
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
	 * ����get����
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
		//��ȡpost�������
		String action = request.getParameter("action");
		/*String path = request.getContextPath();
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();*/
		//�ɼ�Dao
		GradeDao gradeDao = new GradeDao();
		if ("delete".equals(action)) {
			// ����idɾ���ɼ�
			gradeDao.deleteById(Integer.parseInt(request.getParameter("id")));
			//ˢ�³ɼ�ҳ��
	  		response.sendRedirect("../grade.jsp");
		} else if ("update".equals(action)) {
			// ���³ɼ�
			Grade grade = new Grade();
			grade.setId(Integer.parseInt(request.getParameter("id")));
			grade.setGradeValue(Float.parseFloat(request.getParameter("gradeValue") != null ? request.getParameter("gradeValue") : "0"));
			gradeDao.update(grade);
	  		response.sendRedirect("../grade.jsp");
		} else if ("add".equals(action)) {//���������
			//�ж�id�Ƿ�Ϊ��
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
	 * ��ʼ�����ط���
	 * @throws ServletException
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
