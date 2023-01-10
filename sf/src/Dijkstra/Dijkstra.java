package Dijkstra;

import java.util.Scanner;

public class Dijkstra {
    //��������ΪInteger.MAX_VALUE����������Integer.MAX_VALUE��ӻ�������³��ָ�Ȩ
    public static int MaxValue = 100000;
    
    public static void main(String[] args) {
        System.out.println("2018143124 ������");
        //������
        int vertex = 10;
        //����
        int edge = 20;
 
        int[][] matrix = new int[vertex][vertex];
        //��ʼ���ڽӾ���
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
 
        //��Դ���·����Դ��
        int source = 0;
        //����dijstra�㷨�������·��
        dijstra(matrix, source);
    }
 
    public static void dijstra(int[][] matrix, int source) {
        //���·������
        int[] shortest = new int[matrix.length];
        //�жϸõ�����·���Ƿ����
        int[] visited = new int[matrix.length];
        //�洢���·��
        String[] path = new String[matrix.length];
 
        //��ʼ�����·��
        for (int i = 0; i < matrix.length; i++) {
            path[i] = new String(source + "->" + i);
        }
 
        //��ʼ��Դ�ڵ�
        shortest[source] = 0;
        visited[source] = 1;
  /*
   * �Լ�д��      
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
        	//��ʱ�Ѿ��ҵ�һ��S�����е���С·��
       	visited[index]=1;
       	shortest[index]=min; //ֻ����S�л�õ���С·�������жϳ���С·��
        	//�Ӵ˽ڵ����������V-S�������Ľ��
        	for(int m=1;m<matrix.length;m++) {
        		if(visited[m]== 0&& matrix[source][index]+matrix[index][m]<matrix[source][m]) {
        			matrix[source][m]=matrix[source][index]+matrix[index][m];
        			path[m] = path[index] + "->" + m;
        		}
        	}
        }
        
       //��ӡ
        for(int i=1;i<matrix.length;i++) {
        	if(matrix[source][i]==MaxValue) {
        		System.out.println("��·��������");
        	}else {
        		System.out.println(i+"�����·��Ϊ"+path[i]+"����̳���Ϊ"+shortest[i]);
        	}
       }
        
        
        
  
        //��Ҫ����n-1�飬��Ϊ������ΪA-B��A-C�̾���˵��A-B-D��A-C-D�̣�
        for (int i = 1; i < matrix.length; i++) {
            int min = 1000000; 
            System.out.println("��"+i+"�ֵ�minΪ"+min);
            int index = -1;
            //���û��������Ȼ��
            for (int j = 0; j < matrix.length; j++) {
            	if(matrix[source][j]>=100000) {
            		System.out.println("Դ�ڵ�Ŀǰ�޷�ֱ�ӻ��ӵ�"+j);
            	}else {
            		System.out.println( "Դ�ڵ�0��"+j+"��·������Ϊ"+matrix[source][j] );
            	}
                //�Ѿ�������·���Ľڵ㲻��Ҫ�ټ�����㲢�жϼ���ڵ���Ƿ���ڸ���·��
                if (visited[j] == 0 && matrix[source][j] < min) { 
                	System.out.println("��Ϊ"+j+"δ�����׼���������Դ�㵽��·�����ȱ���һ����Сֵ"+min+"��С����������");
                    min = matrix[source][j];
                    System.out.println("min�ı�Ϊ"+min);
                    index = j;
                }
            }
      System.out.println("��ʱ"+index+"�Ѿ��Ǳ���������С·���ģ���Ӧ��visited����ֵ��Ϊ1");
 
            //�������·��
            shortest[index] = min;
            visited[index] = 1;
 
            //���´�index���������ڵ�Ľ϶�·��
            for (int m = 0; m < matrix.length; m++) {
            	
            	//�����ԭ�㵽index��Ȩֵ����index��m��ȨֵС��ԭ��ֱ�ӵ�m��Ȩֵ����ֱ���滻���õ����С·������
                if (visited[m] == 0 && matrix[source][index] + matrix[index][m] < matrix[source][m]) {//���index��m������ͨ����ô�϶��ʹ����ˣ���Ϊ���ǲ���ͨ����100000
                	System.out.println("Դ�㵽���"+index+"����С·��"+matrix[source][index]+"Ȼ����ϸý�㵽"+m+"��·��"+matrix[index][m]+"<Դ�㵽"+m+"��·��"+ matrix[source][m]+",�����滻��Դ�ڵ�Ҳ���Լ�ӵ���"+m+",����Ϊ"+(matrix[source][index] + matrix[index][m]));
                    matrix[source][m] = matrix[source][index] + matrix[index][m];
                    path[m] = path[index] + "->" + m;//һ��ʼʱ���Ѿ���path��ֵ
                }
            }
 
        }
 
        //��ӡ���·��
        for (int i = 1; i < matrix.length; i++) {
                if (shortest[i] == MaxValue) {
                    System.out.println(source + "��" + i + "���ɴ�");
                } else {
                    System.out.println(source + "��" + i + "�����·��Ϊ��" + path[i] + "����̾����ǣ�" + shortest[i]);
                }
        }
    }
}