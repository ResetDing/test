package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo05 {

	public static void main(String[] args) {
		Scanner scanner  = new Scanner(System.in);
		System.out.println("请输入要删除的sno：");
		String input = scanner.nextLine();
		
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "root");
			statement = connection.createStatement();
			String sql = "delete from student where sno = '" + input + "'";
			int rows = statement.executeUpdate(sql);
			if (rows >= 1) {
				System.out.println("删除成功");
			} else {
				System.out.println("删除失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
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