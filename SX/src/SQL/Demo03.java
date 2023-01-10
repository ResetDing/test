package SQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author liuke
 *
 */
public class Demo03 {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test"
				+ "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=UTF-8", 
				"root", "1234");
		
		
		Statement statement = connection.createStatement();

		String sno = "s012";
		
		String sql = "delete from student where sno = '" + sno + "'";
		
		System.out.println(sql);
		
		int effectedRows = statement.executeUpdate(sql);
		
		if (effectedRows >= 1) {
			System.out.println("删除数据成功");
		} else {
			System.out.println("删除数据失败");
		}
	}

}