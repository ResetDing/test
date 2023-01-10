package ex0110;

public class Demo02 {

	public static void main(String[] args) {
		
		int a=1;
		int b=0;
		
		try {
			int c=a/b;
			if(a==1) {
				throw new Exception();
			}
			if(a==2) {
				throw new RuntimeException();
			}
			
		}catch(RuntimeException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			System.out.println("最后一步");
		}
		
		
	}

}
