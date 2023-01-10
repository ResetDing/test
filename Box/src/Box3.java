public class Box3 {
	
	public static void main(String[] args) {
		int [] A= {3,2,1};
		
		int [][] a=new int[2][3];
		a[1][2]=5;
		
		int [][] b=new int[3][];
		b[0]=new int [3];
		b[0][2]=5;
		
		int [][] c=new int [][] {
			{1,2,3},
			{4,5},
			{6,7,8}
		};
		 int [][] num=new int [3][4];
		 num[0]=new int[2];
		 num[1]=new int[] {7,6,5};
		 num[2]=new int[] {4,3,1,1};
		 
		 num[0][0]=9;
		 num[0][1]=8;
		 
		 for(int A1:A) {
			 System.out.print(A1+" ");
		 }
		 System.out.println();
		 System.out.println("***************");
		 
		 for(int[] Uarry1:c) {
			 for(int Uarry2:Uarry1) {
				 System.out.print(Uarry2+" ");
			 }
			 System.out.println();
		 }
	}
}