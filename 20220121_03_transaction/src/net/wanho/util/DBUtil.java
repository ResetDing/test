package net.wanho.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
/**
 * 对于数据库连接的管理、资源释放
 * @author liuke
 *
 */
public class DBUtil {

	private static DataSource dataSource;
	
	static {
		try {
			InputStream is = DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
			Properties prop = new Properties();
			prop.load(is);
			dataSource = BasicDataSourceFactory.createDataSource(prop);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取连接
	 * @return
	 */
	public static Connection getConnection() {
		try {
			Connection connection = dataSource.getConnection();
			System.out.println("DBUtil.connection:" + connection.hashCode());
			return connection;
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
			if (con != null && con.getAutoCommit()) {
				con.close(); // 把连接对象归还连接池
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
