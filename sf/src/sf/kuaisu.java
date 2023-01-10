
package sf;
import java.util.Arrays;
import java.util.Scanner;

public class kuaisu {

	void quickSort(int[] a, int left, int  right){//left是最左边的序号，right是相反的
		int f,t;
		int r,l;
		l=left;//辅助指针l，最开始指向最左边的
		r=right;//同上
		f=a[(left+right)/2]; //让中间的那个数当特殊数字
		while(l<r) {		//左边的小于右边就一直动
			while(a[l]<f) { //找大于等于特殊数字的那个数字
				++l;
			}
			while(a[r]>f) {//找小于等于特殊数字的那个数字
				--r;
			}
			int h1=l;
			int h2=r;
			if(l<=r) {  //上面停下，然后交换位置，交换完之后继续
				t=a[l];
				a[l]=a[r];
				a[r]=t;
				--r;	
				++l;	//每一步要判断上面的while条件看看是不是还是符合
				System.out.println(Arrays.toString(a)+"此时是交换的是第"+(h1+1)+"位的"+a[h1]+"和上面第"+(h2+1)+"位的"+a[h2]);
			}
		}
		if(l==r) {
			l++;
		}
		if(left<r) {
			quickSort(a, left, l-1);
		}
		if(l<right) {
			quickSort(a, r+1, right);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("丁丽媛的学号快速排序");
		int arr[]={2,0,1,8,1,4,3,1,2,4};
		System.out.println(Arrays.toString(arr));
		kuaisu k =new kuaisu();
		k.quickSort(arr, 0,9);
	}
}