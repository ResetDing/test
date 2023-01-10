package ex0110;

import java.time.LocalDate;

public class Demo01 {

	public static void main(String[] args) throws Exception {
		Integer age=null;
		try {
			age=computeAge(2020);
		}catch(Exception e){
			System.out.println("�����쳣��");
			e.printStackTrace();
		}
		System.out.println("���������ǣ�"+age);
	}
	
	public static int computeAge(int birthYear) throws Exception {
		LocalDate today=LocalDate.now();
		int currentYear=today.getYear();
		if(birthYear>currentYear) {
			throw new Exception();
		}else {
			return currentYear-birthYear;
		}
	}

}
