
package sf;
import java.util.Arrays;
import java.util.Scanner;

public class kuaisu {

	void quickSort(int[] a, int left, int  right){//left������ߵ���ţ�right���෴��
		int f,t;
		int r,l;
		l=left;//����ָ��l���ʼָ������ߵ�
		r=right;//ͬ��
		f=a[(left+right)/2]; //���м���Ǹ�������������
		while(l<r) {		//��ߵ�С���ұ߾�һֱ��
			while(a[l]<f) { //�Ҵ��ڵ����������ֵ��Ǹ�����
				++l;
			}
			while(a[r]>f) {//��С�ڵ����������ֵ��Ǹ�����
				--r;
			}
			int h1=l;
			int h2=r;
			if(l<=r) {  //����ͣ�£�Ȼ�󽻻�λ�ã�������֮�����
				t=a[l];
				a[l]=a[r];
				a[r]=t;
				--r;	
				++l;	//ÿһ��Ҫ�ж������while���������ǲ��ǻ��Ƿ���
				System.out.println(Arrays.toString(a)+"��ʱ�ǽ������ǵ�"+(h1+1)+"λ��"+a[h1]+"�������"+(h2+1)+"λ��"+a[h2]);
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
		System.out.println("�����µ�ѧ�ſ�������");
		int arr[]={2,0,1,8,1,4,3,1,2,4};
		System.out.println(Arrays.toString(arr));
		kuaisu k =new kuaisu();
		k.quickSort(arr, 0,9);
	}
}