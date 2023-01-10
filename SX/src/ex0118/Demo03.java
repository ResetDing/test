package ex0118;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 删除teacher表中指定的数据
 * @author Lenovo
 *
 */

public class Demo03 {
	
	public static void main(String[] args) throws SQLException{
		// 连接数据库需要：主机地址、端口号；用户名、密码
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","root","root");
		java.sql.Statement statement = connection.createStatement();
	    
		String name = "张三疯";
	    String dname = "中文";
	    Integer age =38;
	    String sex ="女";
	    String sno = "s012";
	    
		String sql = "update student set sname ='"+ name +"',dname = '"+ dname +"',sage = '"+ age +"',ssex = '"+ sex +"'where sno = '"+  sno   + "'";
	    
	    int effectedRows = ((java.sql.Statement) statement).executeUpdate(sql);
	    
	    if(effectedRows >=1) {
	    	System.out.println("数据修改成功");
	    }else {
	    	System.out.println("数据修改失败");
	    }
				

	}

}


