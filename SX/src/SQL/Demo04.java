package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Demo04 {

	public static void main(String[] args) {
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test"
					+ "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=UTF-8", 
					"root", "root");
		
			statement = connection.createStatement();
			
			String sql = "select sno, sname as student_name, dname, sage, ssex from student";
//		    System.out.println(sql);
			
			resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				String sno = resultSet.getString("sno");
				String studentName = resultSet.getString("STUDENT_NAME");
				String dname = resultSet.getString("dname");
				int sage = resultSet.getInt("sage");
				String ssex = resultSet.getString("ssex");
				System.out.print(sno + ", " + studentName + ", " + dname + ", " + sage + ", " + ssex);
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
}