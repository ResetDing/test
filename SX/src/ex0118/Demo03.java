package ex0118;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ɾ��teacher����ָ��������
 * @author Lenovo
 *
 */

public class Demo03 {
	
	public static void main(String[] args) throws SQLException{
		// �������ݿ���Ҫ��������ַ���˿ںţ��û���������
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","root","root");
		java.sql.Statement statement = connection.createStatement();
	    
		String name = "������";
	    String dname = "����";
	    Integer age =38;
	    String sex ="Ů";
	    String sno = "s012";
	    
		String sql = "update student set sname ='"+ name +"',dname = '"+ dname +"',sage = '"+ age +"',ssex = '"+ sex +"'where sno = '"+  sno   + "'";
	    
	    int effectedRows = ((java.sql.Statement) statement).executeUpdate(sql);
	    
	    if(effectedRows >=1) {
	    	System.out.println("�����޸ĳɹ�");
	    }else {
	    	System.out.println("�����޸�ʧ��");
	    }
				

	}

}


