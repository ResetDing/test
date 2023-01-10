/**
 * 
 * 逆序依次输出数组里的每一个数
 *
 */
public class test16 {

	public static void main(String[] args) {
		int[][] arr= {
				{1,2,3},
				{10,20,30},
				{100,200,300}
		};
		for(int i=0;i<arr.length;i++) {
			for(int j=arr[i].length-1;j>=0;j--) {
				System.out.print(arr[i][j]+"\t");
			}System.out.println();
		}

	}

}
