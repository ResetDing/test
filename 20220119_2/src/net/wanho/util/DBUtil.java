package net.wanho.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/**
 * 对于数据库连接的管理、资源释放
 * @author Lenovo
 *
 */

public class DBUtil {

	private static String url;
	
	private static String user;
	
	private static String password;
	
	static {
		try {
			InputStream is = new FileInputStream("src/jdbc.properties");
			Properties prop = new Properties();
			prop.load(is);
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
			
			System.out.println(url);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(Connection con, Statement st) {
		try {
			if(st != null) {
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection con, Statement st, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(con, st);
	}
}
