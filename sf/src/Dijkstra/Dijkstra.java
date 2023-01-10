package Dijkstra;

import java.util.Scanner;

public class Dijkstra {
    //不能设置为Integer.MAX_VALUE，否则两个Integer.MAX_VALUE相加会溢出导致出现负权
    public static int MaxValue = 100000;
    
    public static void main(String[] args) {
        System.out.println("2018143124 丁丽媛");
        //顶点数
        int vertex = 10;
        //边数
        int edge = 20;
 
        int[][] matrix = new int[vertex][vertex];
        //初始化邻接矩阵
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                matrix[i][j] = MaxValue;
            }
        }
        for (int i = 0; i < edge; i++) {
        	matrix[2][7] = 2028143114;
        	matrix[1][7] = 2028143114;
        	matrix[3][7] = 2028143114;
            matrix[0][1] = 39;
            matrix[0][2] = 30;
            matrix[0][3] = 42;
            matrix[1][4] = 32;
            matrix[1][5] = 13;
            matrix[2][6] = 16;
            matrix[0][7] = 2018143114;
            matrix[2][8] = 31;
            matrix[3][9] = 61;
            matrix[3][4] = 1;
            matrix[3][5] = 13;
            matrix[3][6] = 14;
            matrix[6][4] = 13;
            matrix[6][8] = 21;
            matrix[3][9] = 41;
            matrix[0][9] = 131;
            matrix[8][9] = 21;
            matrix[5][0] = 13;
            matrix[5][6] = 61;
            matrix[1][8] = 41;
        }
 
        //单源最短路径，源点
        int source = 0;
        //调用dijstra算法计算最短路径
        dijstra(matrix, source);
    }
 
    public static void dijstra(int[][] matrix, int source) {
        //最短路径长度
        int[] shortest = new int[matrix.length];
        //判断该点的最短路径是否求出
        int[] visited = new int[matrix.length];
        //存储输出路径
        String[] path = new String[matrix.length];
 
        //初始化输出路径
        for (int i = 0; i < matrix.length; i++) {
            path[i] = new String(source + "->" + i);
        }
 
        //初始化源节点
        shortest[source] = 0;
        visited[source] = 1;
  /*
   * 自己写的      
   */
        for(int i=0;i<matrix.length;i++) {
        	int min=Integer.MAX_VALUE;
        	int index = 0;
        	for(int j=0;j<matrix.length;j++) {
        		if(visited[j]==0&&matrix[source][j]<min) {
        			min=matrix[source][j];
        			index=j;
        		}
        	}
        	//此时已经找到一条S集合中的最小路径
       	visited[index]=1;
       	shortest[index]=min; //只有在S中获得的最小路径才能判断成最小路径
        	//从此节点往后接着找V-S中相连的结点
        	for(int m=1;m<matrix.length;m++) {
        		if(visited[m]== 0&& matrix[source][index]+matrix[index][m]<matrix[source][m]) {
        			matrix[source][m]=matrix[source][index]+matrix[index][m];
        			path[m] = path[index] + "->" + m;
        		}
        	}
        }
        
       //打印
        for(int i=1;i<matrix.length;i++) {
        	if(matrix[source][i]==MaxValue) {
        		System.out.println("该路径不存在");
        	}else {
        		System.out.println(i+"的最短路径为"+path[i]+"，最短长度为"+shortest[i]);
        	}
       }
        
        
        
  
        //需要遍历n-1遍，因为不能因为A-B比A-C短就能说明A-B-D比A-C-D短！
        for (int i = 1; i < matrix.length; i++) {
            int min = 1000000; 
            System.out.println("第"+i+"轮的min为"+min);
            int index = -1;
            //结点没被遍历过然后
            for (int j = 0; j < matrix.length; j++) {
            	if(matrix[source][j]>=100000) {
            		System.out.println("源节点目前无法直接或间接到"+j);
            	}else {
            		System.out.println( "源节点0到"+j+"的路径长度为"+matrix[source][j] );
            	}
                //已经求出最短路径的节点不需要再加入计算并判断加入节点后是否存在更短路径
                if (visited[j] == 0 && matrix[source][j] < min) { 
                	System.out.println("因为"+j+"未被彻底检查过，而且源点到其路径长度比上一个最小值"+min+"更小，满足条件");
                    min = matrix[source][j];
                    System.out.println("min改变为"+min);
                    index = j;
                }
            }
      System.out.println("此时"+index+"已经是被检查过的最小路径的，对应的visited数组值设为1");
 
            //更新最短路径
            shortest[index] = min;
            visited[index] = 1;
 
            //更新从index跳到其它节点的较短路径
            for (int m = 0; m < matrix.length; m++) {
            	
            	//如果从原点到index的权值加上index到m的权值小于原点直接到m的权值，就直接替换掉该点的最小路径长度
                if (visited[m] == 0 && matrix[source][index] + matrix[index][m] < matrix[source][m]) {//如果index到m不能连通，那么肯定就大于了，因为都是不连通都是100000
                	System.out.println("源点到结点"+index+"的最小路径"+matrix[source][index]+"然后加上该结点到"+m+"的路径"+matrix[index][m]+"<源点到"+m+"的路径"+ matrix[source][m]+",所以替换，源节点也可以间接到达"+m+",长度为"+(matrix[source][index] + matrix[index][m]));
                    matrix[source][m] = matrix[source][index] + matrix[index][m];
                    path[m] = path[index] + "->" + m;//一开始时候已经对path赋值
                }
            }
 
        }
 
        //打印最短路径
        for (int i = 1; i < matrix.length; i++) {
                if (shortest[i] == MaxValue) {
                    System.out.println(source + "到" + i + "不可达");
                } else {
                    System.out.println(source + "到" + i + "的最短路径为：" + path[i] + "，最短距离是：" + shortest[i]);
                }
        }
    }
}