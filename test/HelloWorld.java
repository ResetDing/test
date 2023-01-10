public class HelloWorld{
	public static void main(String[] args) {
		String xuehao="201814312";
		String bj="18信息1";
		String name="丁丽媛";	
		System.out.println("学号"+xuehao);
		System.out.println("班级"+bj);
		System.out.println("姓名"+name);
		int Java = 0;//0代表没有Java课，1代表有Java课
		int Jiaoshi = 0;//0代表实验课，1代表理论课
		System.out.println("不上课");
        if (Java==0 )
        System.out.println("去图书馆！");
        System.out.println("有课");
        	if(Jiaoshi==0)
        		System.out.println("理论课，去59-308");
        	else 
        		System.out.println("实验课，去60-122");
	}
}