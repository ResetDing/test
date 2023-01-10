package ex0118;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 查询teacher表中的所有数据，并输出
 * @author Lenovo
 *
 */

public class Demo04 {
	
	public static void main(String[] args) throws SQLException
	{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test"
					+ "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=UTF-8", 
					"root", "1234");
		
			java.sql.Statement statement1 = connection.createStatement();
			
			String sql = "select tno, tname, dname, sal, age, tsex from teacher";
//		    System.out.println(sql);
			
			resultSet = statement1.executeQuery(sql);
			
			while (resultSet.next()) {
				String tno = resultSet.getString("tno");
				String tname = resultSet.getString("tname");
				String dname = resultSet.getString("dname");
				int sal = resultSet.getInt("sal");
				int age = resultSet.getInt("age");
				String tsex = resultSet.getString("tsex");
				System.out.print(tno + ", " + tname + ", " + dname + ", " + sal + ", " + age + "," + tsex);
				
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
					((Connection) statement).close();
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



