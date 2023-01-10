package ex0110;

import java.time.LocalDate;

public class Demo {

	public static void main(String[] args) {
		try {
			int i=computeAge(2050);
			System.out.println(i);
		}catch(BirthYearLatterThanCurrentYear e) {
			e.printStackTrace();
		}
	}
	
	public static int computeAge(int birthYear) throws BirthYearLatterThanCurrentYear{
		LocalDate today=LocalDate.now();
		int currentYear=today.getYear();
		if(birthYear>currentYear) {
			throw new BirthYearLatterThanCurrentYear("出生年份有误：birthYear="+birthYear);
		}else {
			return currentYear-birthYear;
		}
	}

}
