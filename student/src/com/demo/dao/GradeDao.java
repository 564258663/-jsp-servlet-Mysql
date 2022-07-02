package com.demo.dao;

import com.demo.model.Grade;
import com.demo.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * hyy 20220615
 * 数据访问层，记录访问后台数据库的操作方法
 */
public class GradeDao {


	/**
	 * 查询所有人的成绩列表
	 * @param orderType
	 * @return
	 */
	public ArrayList<Grade> getAll(int orderType) {
		
		ArrayList<Grade> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from grade";
			if (orderType == 2) {
				sql = sql + " order by student_num desc ";
			} else if (orderType == 3) {
				sql = sql + " order by grade_value asc ";
			} else if (orderType == 4) {
				sql = sql + " order by grade_value desc ";
			} else {
				sql = sql + " order by student_num asc ";
			}

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs != null && rs.next()) {
				Grade grade = new Grade();
				grade.setId(rs.getInt(1));
				grade.setStudentNum(rs.getString(2));
				grade.setFullName(rs.getString(3));
				grade.setClassName(rs.getString(4));
				grade.setCourseName(rs.getString(5));
				grade.setGradeValue(rs.getFloat(6));
				list.add(grade);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}


	/**
	 * 根据id查询详情接口
	 * @param id
	 * @return
	 */
	public Grade getById(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from grade where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				Grade grade = new Grade();
				grade.setId(rs.getInt(1));
				grade.setStudentNum(rs.getString(2));
				grade.setFullName(rs.getString(3));
				grade.setClassName(rs.getString(4));
				grade.setCourseName(rs.getString(5));
				grade.setGradeValue(rs.getFloat(6));
				return grade;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

	/**
	 * 添加学生成绩数据
	 * @param grade
	 */
	public void add(Grade grade) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into grade(student_num, full_name, class_name, course_name, grade_value) " +
					" values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, grade.getStudentNum());
			pstmt.setString(2, grade.getFullName());
			pstmt.setString(3, grade.getClassName());
			pstmt.setString(4, grade.getCourseName());
			pstmt.setFloat(5, grade.getGradeValue());
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 更新学生成绩
	 * @param grade
	 */
	public void update(Grade grade) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "update grade set grade_value=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setFloat(1, grade.getGradeValue());
			pstmt.setInt(2, grade.getId());
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 通过id删除数据
	 * @param id
	 */
	public void deleteById(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from grade where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}


	/**
	 * 根据学号查询详情接口
	 * @param studentNum
	 * @return
	 */
	public int getByStudentNum(String studentNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int id = 0;
		try {
			conn = DBUtil.getConnection();
			String sql = "select id from grade where student_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, studentNum);
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				id = rs.getInt(1);
			}
			return id;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return id;
	}
}
