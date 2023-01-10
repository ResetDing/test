package Dijkstra;

import java.util.Arrays;
import java.util.Random;

/*
 * 最小生成树prim算法实现
 * 方式就是把初始的0结点放到S中，剩下的部分是V-S
 * 然后扫描S中的结点，找出每一个结点与V-S中邻接结点的权值，找权值最小的，然后把对应的V-S中的那个结点拉最小生成树里面来，重复遍历
 */
/**
 * @author 李犇
 *
 */
public class Prim2 {
	public static int[] prim(int g[][],int source) {
		int[] visited=new int[g.length];
		visited[0]=1;//0号已经遍历过，起始节点嘛,等于1说明他在最小树里面了已经
		int mst[]=new int[g.length];
		for(int i=0;i<mst.length;i++) {
			mst[i]=10000;//1w
		}
		mst[0]=0;//0号已经在最小生成树里面
		for(int m=1;m<g.length;m++) {
			int i=0;
			int min=Integer.MAX_VALUE;
			int index=0;	
			
			while(mst[i]!=10000) {//循环遍历一整个树找到和V-S中结点权值最小的那个。
				for(int j=0;j<g.length;j++) {
					
					if(visited[j]==0&&g[mst[i]][j]<min&&g[mst[i]][j]!=9999) {//如果这个顶点没有在最小树里面，然后权值更小就保存
						
						min=g[mst[i]][j];
						index=j;
					}else {
						
					}
				}
				//上面for循环结束之后，会得到一个最小的min权值以及对应的顶点是谁。然后循环完集合最小生成树中的所有的权值，找到最小的
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
		System.out.println("丁丽媛2018143124");
		System.out.println("顶点数量"+v);
		int g[]=new int[v];
		long t1=System.currentTimeMillis();
		g=prim(a, 0);
		long t2=System.currentTimeMillis();
		System.out.println("生成树顺序"+Arrays.toString(g));
		System.out.println("普利姆算法时间"+(t2-t1));
	}
}
