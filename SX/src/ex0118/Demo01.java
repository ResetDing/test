package ex0118;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * �������ݵ�teacher��
 * @author Lenovo
 *
 */

public class Demo01 {
	
	public static void main(String[] args) throws SQLException{
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","root","root");
		java.sql.Statement statement = connection.createStatement();
		String sql = "INSERT INTO teacher (tno,tname,dname,sal,age,tsex) VALUES ('t012','������','��ѧ',4500,33,'��')";
		
		int effectedRows = statement.executeUpdate(sql);
		
		if(effectedRows >= 1) {
			System.out.println("���ݲ���ɹ�");
		}else {
			System.out.println("���ݲ���ʧ��");
		}
		
	}
}
