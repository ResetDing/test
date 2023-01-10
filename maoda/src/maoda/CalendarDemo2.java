package maoda;

import java.util.Calendar;

public class CalendarDemo2
{

	public static void main(String args[]) // 有趣的一个例子，求2007年2月份有多少天,,
	{
		System.out.println(GetDayCountFromYearMonth(2007, 2));
	}

	static int GetDayCountFromYearMonth(int nYear, int nMonth)
	{
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, nYear);
		c.set(Calendar.MONTH, nMonth - 1);

		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

}
