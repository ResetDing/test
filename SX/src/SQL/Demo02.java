package SQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 鎻掑叆鏁版嵁
 * @author liuke
 *
 */
public class Demo02 {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test"
				+ "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=UTF-8", 
				"root", "1234");
		
		
		Statement statement = connection.createStatement();
		
		String name = "1";
		String dname = "11";
		Integer age = 38;
		String sex = "女";
		String sno = "s012";
		
		String sql = "update student set sname = '" + name + "', dname = '" + dname 
				+ "', sage = '" + age + "', ssex = '" + sex 
				+ "' where sno = '" + sno + "' ";
		
		int effectedRows = statement.executeUpdate(sql);
		
		if (effectedRows >= 1) {
			System.out.println("删除数据成功");
		} else {
			System.out.println("删除数据失败");
		}
	}

}