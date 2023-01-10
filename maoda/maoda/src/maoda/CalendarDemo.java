package maoda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public class CalendarDemo
{
	public static void main(String[] args) throws ParseException
	{
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getClass().getSuperclass().getSuperclass());
		System.out.println(cal.getClass().getSuperclass());
		System.out.println(cal.getClass());
//		System.out.println(cal.getSuperclass());
		int year =cal.get(Calendar.YEAR);
		int month =cal.get(Calendar.MONTH)+1;
		int day=cal.get(Calendar.DATE);
		int hour=cal.get(Calendar.HOUR);
		int minute=cal.get(Calendar.MINUTE);
		int second =cal.get(Calendar.SECOND);
		int milliSecond =cal.get(Calendar.MILLISECOND);
		System.out.println("当前时间：");
		String strTime = String.format("%d-%02d-%02d %d-%d-%d:%s", 
				year, month, day, hour, minute, second, milliSecond
				);//02d就是2个宽度，如果没有2个宽度时用0来填。
		System.out.println(strTime);
		//为日历对象设定时间
		cal.set(2012, 5, 12, 14, 28, 4);
		System.out.println("不加格式的日历"+cal);//乱糟糟
		Date date =cal.getTime(); //转换为说人话的日期类型
		System.out.println("默认老外格式"+date);					//老外格式
		System.out.println("本地格式"+date.toLocaleString());//本地格式
		//日期格式化类
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");//定制自己喜欢的日期格式
		String strDate =format.format(date);
		System.out.println("格式化后日历形式"+strDate);
		//将字符串转化为Date类型
		Date newDate=format.parse("2017-12-30 24:59:59:999");
		System.out.println("本地的制式"+newDate.toLocaleString());
		System.out.println("老外的制式"+newDate.toString());
		System.out.println("格林威治制式"+newDate.toGMTString());
		
		
		Calendar cal2=new GregorianCalendar(2017,(2-1),10);//要注意国外月份从0开始。。
		long diff =Math.abs(cal.getTimeInMillis()-cal2.getTimeInMillis());//毫秒数相减
		int diffDays =(int)(diff/1000/60/60/24);//毫秒到秒是1000，秒到分钟60，分钟到。。。长整型转换为整型
		System.out.println("相差"+diffDays+"天");
		System.out.println((int)(24/5));//上面除以24换算时候如果是多1天，其实是多了1.几天了。要注意。
		System.out.println("获取日期"+cal.getTime());
		System.out.println("获取毫秒"+cal.getTimeInMillis());
		
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));//做出来算我输
		cal.add(Calendar.DAY_OF_MONTH, 777);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
	
		
//		System.out.print(cal.getActualMaximum(Calendar.YEAR));//
//		System.out.print(cal.getActualMaximum(Calendar.DAY_OF_MONTH));//之前设定的当前月份最大月
		System.out.print(cal2.getActualMaximum(Calendar.DAY_OF_MONTH));
	
//		 public static void main (String args[])	//有趣的一个例子，求2007年2月份有多少天,,
//	        {
//	     	System.out.println(GetDayCountFromYearMonth(2007,2));
//	}
//
//	 static int GetDayCountFromYearMonth(int nYear, int nMonth)
//	 {
//	     	Calendar c= Calendar.getInstance();
//	     	c.set(Calendar.YEAR, nYear);
//	     	c.set(Calendar.MONTH, nMonth -1);
//	     	
//	     	return c.getActualMaximum(Calendar.DAY_OF_MONTH);
//	 }

	
	}
	
		
}
