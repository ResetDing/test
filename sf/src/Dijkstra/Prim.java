package Dijkstra;

import java.util.Arrays;

/*
 * ��С������prim�㷨ʵ��
 * ��ʽ���ǰѳ�ʼ��0���ŵ�S�У�ʣ�µĲ�����V-S
 * Ȼ��ɨ��S�еĽ�㣬�ҳ�ÿһ�������V-S���ڽӽ���Ȩֵ����Ȩֵ��С�ģ�Ȼ��Ѷ�Ӧ��V-S�е��Ǹ��������С���������������ظ�����
 */
public class Prim {
	public static void main(String[] args) {
		int v=10;
		int [][]g=new int[v][v];
		for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                g[i][j] = 9999;
            }
        }
		g[0][1]=1;
		g[0][2]=3;
		g[0][3]=3;
		g[0][4]=5;
		g[0][5]=4;
		g[0][6]=6;
		g[0][7]=9;
		g[0][8]=8;
		g[0][9]=7;
		g[1][2]=7;
		g[1][3]=5;
		g[3][5]=11;
		g[5][7]=13;
		g[5][9]=7;
		g[7][9]=5;
		g[9][8]=9;
		g[8][6]=11;
		g[6][4]=10;
		g[6][2]=14;
		g[4][2]=5;
		for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                g[j][i] = g[i][j];
            }
        }
//		g[0][1]=6;
//		g[0][3]=5;
//		g[0][2]=1;
//		g[1][2]=5;
//		g[1][4]=3;
//		g[1][0]=6;
//		g[2][0]=1;
//		g[2][1]=5;
//		g[2][3]=5;
//		g[2][4]=6;
//		g[2][5]=4;
//		g[3][0]=5;
//		g[3][2]=5;
//		g[3][5]=2;
//		g[4][1]=3;
//		g[4][2]=6;
//		g[4][5]=6;
//		g[5][2]=4;
//		g[5][3]=2;
//		g[5][4]=6;
		int a[]=new int[v];
		a=prim(g, 0);
		System.out.println(Arrays.toString(a));
	}

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
			System.out.println("��ʱ��С����"+Arrays.toString(mst));
			while(mst[i]!=10000) {//ѭ������һ�������ҵ���V-S�н��Ȩֵ��С���Ǹ���
				for(int j=0;j<g.length;j++) {
					System.out.println("���ڱ�������"+mst[i]+"��"+j+"���");
					if(visited[j]==0&&g[mst[i]][j]<min&&g[mst[i]][j]!=9999) {//����������û������С�����棬Ȼ��Ȩֵ��С�ͱ���
						System.out.println("�˽�����Ҫ�����·����"+min+"����Ϊ"+g[mst[i]][j]);
						min=g[mst[i]][j];
						index=j;
					}else {
						System.out.println("�����ʻ��߲���ͨ");
					}
				}
				//����forѭ������֮�󣬻�õ�һ����С��minȨֵ�Լ���Ӧ�Ķ�����˭��Ȼ��ѭ���꼯����С�������е����е�Ȩֵ���ҵ���С��
				i++;
			}

				System.out.println("�ɵ���С�������������,��V-S����S�����һ�����"+index+"��������С��������");
				mst[i]=index;	
				visited[index]=1;
		
		}
		return mst;
	}
	
}
