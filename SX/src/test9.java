
/*百钱买百鸡问题：鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一，百钱买百鸡，问鸡翁、母、维各几何？*/
public class test9 {

	public static void main(String[] args) {
		 
        int a,b,c;   

      for ( a = 0; a <=100/5; a++){        //鸡翁

        for( b=0;b<=100/3;b++){            //鸡母

           c=100-a-b;             //控制鸡母数c在0~100变化，a+b+c=100

           if(5*a+3*b+c/3==100&&c%3==0){//设置条件:c的3的模要为0，c除3要除得尽

                 System.out.println("鸡翁有"+a);

                 System.out.println("母鸡有"+b);

                 System.out.println("小鸡有"+c);

                 System.out.println("-------------------");

                   }  
              }   
           }
        }

}
