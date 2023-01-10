package Dijkstra;

import java.util.Arrays;

/*
 * 最小生成树prim算法实现
 * 方式就是把初始的0结点放到S中，剩下的部分是V-S
 * 然后扫描S中的结点，找出每一个结点与V-S中邻接结点的权值，找权值最小的，然后把对应的V-S中的那个结点拉最小生成树里面来，重复遍历
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
			System.out.println("此时最小树有"+Arrays.toString(mst));
			while(mst[i]!=10000) {//循环遍历一整个树找到和V-S中结点权值最小的那个。
				for(int j=0;j<g.length;j++) {
					System.out.println("现在遍历的是"+mst[i]+"和"+j+"结点");
					if(visited[j]==0&&g[mst[i]][j]<min&&g[mst[i]][j]!=9999) {//如果这个顶点没有在最小树里面，然后权值更小就保存
						System.out.println("此结点符合要求，最短路径由"+min+"更改为"+g[mst[i]][j]);
						min=g[mst[i]][j];
						index=j;
					}else {
						System.out.println("不合适或者不连通");
					}
				}
				//上面for循环结束之后，会得到一个最小的min权值以及对应的顶点是谁。然后循环完集合最小生成树中的所有的权值，找到最小的
				i++;
			}

				System.out.println("旧的最小生成树遍历完成,将V-S中离S最近的一个结点"+index+"放入新最小生成树中");
				mst[i]=index;	
				visited[index]=1;
		
		}
		return mst;
	}
	
}
