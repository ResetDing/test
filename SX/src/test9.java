
/*��Ǯ��ټ����⣺����һֵǮ�壬��ĸһֵǮ����������ֵǮһ����Ǯ��ټ����ʼ��̡�ĸ��ά�����Σ�*/
public class test9 {

	public static void main(String[] args) {
		 
        int a,b,c;   

      for ( a = 0; a <=100/5; a++){        //����

        for( b=0;b<=100/3;b++){            //��ĸ

           c=100-a-b;             //���Ƽ�ĸ��c��0~100�仯��a+b+c=100

           if(5*a+3*b+c/3==100&&c%3==0){//��������:c��3��ģҪΪ0��c��3Ҫ���þ�

                 System.out.println("������"+a);

                 System.out.println("ĸ����"+b);

                 System.out.println("С����"+c);

                 System.out.println("-------------------");

                   }  
              }   
           }
        }

}
