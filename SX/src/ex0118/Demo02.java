package ex0118;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * �޸�teacher����ָ��������
 * @author Lenovo
 *
 */

public class Demo02 {
	
	public static void main(String[] args) throws SQLException
	{
		//��
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","root","root");
		java.sql.Statement statement = connection.createStatement();
		
		String tno = "t012";
		
		String sql = "delete from teacher where tno = '" + tno + "'";
		System.out.println(sql);
		
		int effectedRows = statement.executeUpdate(sql);
		
		if(effectedRows >= 1) {
			System.out.println("����ɾ���ɹ�");
		}else {
			System.out.println("����ɾ��ʧ��");
			}
		
	}

}
