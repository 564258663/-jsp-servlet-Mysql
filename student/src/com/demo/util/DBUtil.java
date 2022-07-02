package com.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * jdbc 连接数据库
 */
public class DBUtil {
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://xxxxxx:3306/test?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
	private static final String username = "root";
	private static final String password = "123456";

	private static Connection conn;

	static {
		try {
			Class.forName(driver);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		if (conn == null) {
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		}
		return conn;
	}
}
