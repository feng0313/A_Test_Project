package util;

import java.sql.*;

public class DBconn {
	static String url = "jdbc:mysql://localhost:3306/how2java?characterEncoding=utf8";
	static String username = "root";
	static String pwd = "0313";
	static Connection conn = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;

	public static void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, pwd);
		} catch (Exception e) {
			System.out.println("init 数据库驱动初始化失败！");
			e.printStackTrace();
		}
	}

	public static int addUpdDel(String sql) {
		int i = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("数据库增删改异常！");
			e.printStackTrace();
		}
		return i;
	}

	public static ResultSet selectsql(String sql) {
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("数据库查询异常！");
			e.printStackTrace();
		}
		return rs;
	}

	public static void closeConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("数据库关闭异常！");
			e.printStackTrace();
		}
	}
}
