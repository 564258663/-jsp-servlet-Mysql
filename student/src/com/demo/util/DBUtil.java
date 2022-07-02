package com.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * jdbc 连接数据库
 */
public class DBUtil {
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://hanyy1022.mysql.rds.aliyuncs.com:3306/hanyy_zy?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
	private static final String username = "hanyy_zy";
	private static final String password = "Hanyy_1022";

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
