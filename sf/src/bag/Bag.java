package bag;

import java.util.Arrays;
import java.util.Random;

public class Bag {
	/**
	 * @author ������
	 * 0-1��������
	 * @param V	��������
	 * @param N	��Ʒ����
	 * @param weight ��Ʒ����
	 * @param value	��Ʒ��ֵ
	 * @return
	 */
	public static void main(String[] args) {
		System.out.println("2018143124 ������");
		Random r= new Random();

				
		int v=60;
		int n=20;
		int [] w=new int[n];
		int [] value=new int[n];
		for(int i=0;i<n;i++) {
			w[i]=r.nextInt(6)+1;
			value[i]=r.nextInt(11)+10;
		}
		w[0]=14;
		System.out.println("��������Ʒ������Ϊ"+Arrays.toString(w));
		System.out.println("��������Ʒ�ļ�ֵΪ"+Arrays.toString(value));
		String s=ZeroOnePack(v, n, w, value);
		System.out.println(s);
	}
	public static String ZeroOnePack(int V,int N,int[] weight,int[] value){
		
		int[][] dp = new int[N+1][V+1];
		//Ϊ�˱������,��dp[i][0]��dp[0][j]����Ϊ0����1��ʼ����
		for(int i=1;i<N+1;i++){
			for(int j=1;j<V+1;j++){
//				System.out.print("����������Ϊ"+j+"ǧ�˵�ʱ��");
				//�����i����Ʒ���������ڱ�������j,��װ�뱳��
				//����weight��value�����±궼�Ǵ�0��ʼ,��ע���i����Ʒ������Ϊweight[i-1],��ֵΪvalue[i-1]
//				System.out.println("����ʱ��Ʒ"+i+"������Ϊ"+weight[i-1]+",��ֵΪ"+value[i-1]);
				if(weight[i-1] > j) {
					//System.out.println("��ʱ��Ʒ"+i+"�������������ڵ�j:"+j+"ǧ�ˣ�����dp["+i+"]["+j+"]="+"dp["+(i-1)+"]["+j+"]="+dp[i-1][j]);
					dp[i][j] = dp[i-1][j];
				}
				else {
					int s=Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+value[i-1]);
					//System.out.println("��ʱ��Ʒ"+i+"������С�ڵ������ڵ�j:"+j+"ǧ�ˣ�װ����,Ȼ��dp["+i+"]["+j+"]="+s+",dp[i-1][j]="+dp[i-1][j]+",dp[i-1][j-weight[i-1]]+value[i-1]="+dp[i-1][j-weight[i-1]]+"+"+value[i-1]);
					dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+value[i-1]);
				}
					
			}
		}
		//��ӡ��̬�滮�ı��
		System.out.println("�������£�");
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<V+1;j++) {
				if(dp[i][j]<10)
				System.out.print("0"+dp[i][j]+" ");
				else {
					System.out.print(dp[i][j]+" ");
				}
			}
			System.out.println();
		}
		//������ΪV�ı����ܹ�װ����Ʒ�����ֵΪ
		int maxValue = dp[N][V];
		System.out.println("���ļ�ֵΪ"+maxValue);
		//�����ҳ�װ�뱳����������Ʒ�ı��
		int j=V;
		String numStr="";
		for(int i=N;i>0;i--){
			//����dp[i][j]>dp[i-1][j],��˵����i����Ʒ�Ƿ��뱳����
			if(dp[i][j]>dp[i-1][j]){
				numStr = i+" "+numStr;
				j=j-weight[i-1];
			}

			if(j==0)
				break;
		}
		numStr="���˳��Ϊ"+numStr;
		return numStr;	
	}
}
