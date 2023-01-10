
public class test13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a=new int[] {20,19,21,19};
		System.out.println(a.length);
		System.out.println(a[a.length-1]);
		
		int[] b= {1,2,3,4,5};
		
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+",");
		}System.out.println();
		
		
		int sum=0;
		float ave;
		for(int j=0;j<b.length;j++) {
			sum+=b[j];
			
		}
		ave=(float)sum/b.length;
		System.out.println(ave);
		
		
	}

}
