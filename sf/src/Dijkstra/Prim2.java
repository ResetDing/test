package Dijkstra;

import java.util.Arrays;
import java.util.Random;

/*
 * ��С������prim�㷨ʵ��
 * ��ʽ���ǰѳ�ʼ��0���ŵ�S�У�ʣ�µĲ�����V-S
 * Ȼ��ɨ��S�еĽ�㣬�ҳ�ÿһ�������V-S���ڽӽ���Ȩֵ����Ȩֵ��С�ģ�Ȼ��Ѷ�Ӧ��V-S�е��Ǹ��������С���������������ظ�����
 */
/**
 * @author ���
 *
 */
public class Prim2 {
	public static int[] prim(int g[][],int source) {
		int[] visited=new int[g.length];
		visited[0]=1;//0���Ѿ�����������ʼ�ڵ���,����1˵��������С���������Ѿ�
		int mst[]=new int[g.length];
		for(int i=0;i<mst.length;i++) {
			mst[i]=10000;//1w
		}
		mst[0]=0;//0���Ѿ�����С����������
		for(int m=1;m<g.length;m++) {
			int i=0;
			int min=Integer.MAX_VALUE;
			int index=0;	
			
			while(mst[i]!=10000) {//ѭ������һ�������ҵ���V-S�н��Ȩֵ��С���Ǹ���
				for(int j=0;j<g.length;j++) {
					
					if(visited[j]==0&&g[mst[i]][j]<min&&g[mst[i]][j]!=9999) {//����������û������С�����棬Ȼ��Ȩֵ��С�ͱ���
						
						min=g[mst[i]][j];
						index=j;
					}else {
						
					}
				}
				//����forѭ������֮�󣬻�õ�һ����С��minȨֵ�Լ���Ӧ�Ķ�����˭��Ȼ��ѭ���꼯����С�������е����е�Ȩֵ���ҵ���С��
				i++;
			}

			
				mst[i]=index;	
				visited[index]=1;
		
		}
		return mst;
	}
	public static void main(String[] args) {
		int v=10000;
		int [][]a=new int[v][v];
		Random r=new Random();
		for(int i=0;i<v;i++) {
			for(int j=0;j<v;j++) {
				a[i][j]=r.nextInt(20)+1;			
			}
		}
		for(int i=0;i<v;i++) {
			for(int j=0;j<v;j++) {
				if(a[i][j]==6||a[i][j]==12||a[i][j]==18) {
					a[j][i]=9999;
					a[i][j]=9999;
				}
				a[i][j]=a[j][i];
			}
		}
//		for(int i=0;i<v;i++) {
//			for(int j=0;j<v;j++) {
//				if(a[i][j]<10) {
//					System.out.print("0"+a[i][j]+" ");
//				}
//				else {
//					System.out.print(a[i][j]+" ");
//				}
//			}
//			System.out.println();
//		}
		System.out.println("������2018143124");
		System.out.println("��������"+v);
		int g[]=new int[v];
		long t1=System.currentTimeMillis();
		g=prim(a, 0);
		long t2=System.currentTimeMillis();
		System.out.println("������˳��"+Arrays.toString(g));
		System.out.println("����ķ�㷨ʱ��"+(t2-t1));
	}
}
