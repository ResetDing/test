package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Demo06 {

	public static void main(String[] args) {
		Scanner scanner  = new Scanner(System.in);
		System.out.println("请输入要删除的sno：");
		
		String input = scanner.nextLine();
		
		Connection connection = null;
		PreparedStatement pstm = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "root");
			String sql = "delete from student where sno = ?";
			pstm = connection.prepareStatement(sql);
			
			pstm.setString(1, input);
			
			int rows = pstm.executeUpdate();
			
			if (rows >= 1) {
				System.out.println("删除成功");
			} else {
				System.out.println("删除失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
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
