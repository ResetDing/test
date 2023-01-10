import java.util.Scanner;
public class test6 {

	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您要查询的年份：");
        int year = scanner.nextInt();
        System.out.println("请输入您要查询的月份：");
        int month =scanner.nextInt();
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println(year+"年"+month+"月共有31天");
                break;
            case 2: //判断是否为闰年
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
                    System.out.println(year+"年"+month+"月共有29天");
                }else {
                    System.out.println(year+"年"+month+"月共有28天");
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println(year+"年"+month+"月共有30天");
                break;
            default:
                break;
        }
	}
}
