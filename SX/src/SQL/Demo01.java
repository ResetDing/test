package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Demo01 {

	public static void main(String[] args) throws SQLException {
		//�������ݿ���Ҫ��������ַ����ںţ��û���������
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","root","root");
		
		Statement statement = connection.createStatement();
		
		String sql = "insert into student (sno, sname, dname, sage, ssex) value ('s012', '������', '����', '22', '��')";
		
		int effectedRows = statement.executeUpdate(sql);
		
		if(effectedRows >= 1) {
			System.out.println("���ݲ���ɹ�");
		}else {
			System.out.println("���ݲ���ʧ��");
		}
		
		
		

	}

}
