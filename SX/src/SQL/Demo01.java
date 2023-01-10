package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Demo01 {

	public static void main(String[] args) throws SQLException {
		//连接数据库需要：主机地址、款口号；用户名、密码
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","root","root");
		
		Statement statement = connection.createStatement();
		
		String sql = "insert into student (sno, sname, dname, sage, ssex) value ('s012', '张三丰', '汉语', '22', '男')";
		
		int effectedRows = statement.executeUpdate(sql);
		
		if(effectedRows >= 1) {
			System.out.println("数据插入成功");
		}else {
			System.out.println("数据插入失败");
		}
		
		
		

	}

}
