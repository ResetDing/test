package juzhen;

import java.util.Random;

/**
 * @author ���
 *
 */
public class MatrixText2 {
	public static void main(String agrs[]) {
		int [] p = new int[20];
		Random r=new Random();
		for(int i=0;i<p.length;i++) {
			p[i]=r.nextInt(29)+1;
		}
		int n = p.length;
//		System.out.print("������ľ���Ϊ��");
//		for (int i = 0; i < n - 1; i++) {
//			System.out.print("A" + (i + 1) + "[" + p[i] + "]" + "[" + p[i + 1] + "]" + "  ");
//		}
		System.out.println("2018143114 ���");
		int[][] m = new int[n][n];
		int[][] s = new int[n][n];
		//������õݹ�ķ���ʵ��
		int l=1,jj=n-1;
		int ss=diGui(p, l, jj, s);
		System.out.println("ʹ�÷��εĴ������н�����Ӿ���"+l+"������"+jj+"������С�˴�Ϊ"+ss+"���ϵ��ھ���"+s[l][jj]);
		System.out.println("-------��-------��-------��-------");
		l=1;
		jj=n-1;
		System.out.println("�����Ǳ���¼�����н����");
		int sss=bwl(l,jj, p,m, s);
		System.out.println("ʹ�ñ���¼�Ĵ������н�����Ӿ���"+l+"������"+jj+"������С�˴�Ϊ"+sss+"���ϵ��ھ���"+s[l][jj]);
		System.out.println("-------��-------��-------��-------");
		System.out.println("�����Ƕ�̬�滮�����н����");
		matrixChain(p, m, s);
		System.out.println("ʹ�ñ���¼�Ĵ������н�����Ӿ���"+l+"������"+jj+"������С�˴�Ϊ"+m[l][jj]+"���ϵ��ھ���"+s[l][jj]);
		// ��ӡm����
//		System.out.println("��ӡm["+(n-1)+"]["+(n-1)+"] ����");
//		for (int i = 1; i < m.length; i++) {
//			for (int j = 1; j < m.length; j++) {
//				if (i > j) {
//					System.out.print("0" + "\t");
//				} else {
//					System.out.print(m[i][j] + "\t");
//				}
//			}
//			System.out.println();
//		}
//		System.out.println();
//		// ��ӡs����
//		System.out.println("��ӡs["+(n-1)+"]["+(n-1)+"] ����");
//		for (int i = 1; i < s.length; i++) {
//			for (int j = 1; j < s.length; j++) {
//				if (i > j) {
//					System.out.print("0" + "\t");
//				} else {
//					System.out.print(s[i][j] + "\t");
//				}
//			}
//			System.out.println();
//		}
//		System.out.println();
		System.out.println("�������˼����ŷ�ʽΪ��");
		OptimalParens(s, 1, n - 1);

	}

/**
 * @author ���
 *��̬�滮�ķ���
 */
	public static void matrixChain(int[] p, int[][] m, int[][] s) {
		int n = p.length - 1;// �������ĸ���
		// ��m�������Խ��߸�ֵΪ0
		for (int i = 1; i <= n; i++) {
			m[i][i] = 0;
		}
		for (int r = 2; r <= n; r++) {
			//System.out.println("����ѭ����ʼ��r="+r);
			for (int i = 1; i <= n - r + 1; i++) {
				
				int j = i + r - 1;
				//System.out.println("�ڶ���ѭ����ʼ��i="+i+",j="+j);
				// ����������һ������ֵ��Ϊ����ıȽ���׼��
				m[i][j] = 999999999;
				
	
				for (int k = i; k < j; k++) {//k�Ǹ��ϵ㣬Ȼ�����k��������ʼ��һ��һ������Ų��
					//System.out.println("���ڲ�ѭ����ʼ��k="+k);
					// ������˵Ĵ���

					int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
					
					//System.out.println("��ʱi��"+i+",j��"+j+",r��"+r+",t��"+t+"��k��"+k+",m["+i+"]["+k+"]("+m[i][k]+")+m["+(k+1)+"]["+j+"]("+m[k + 1][j]+")+"+p[i - 1]+"(p[i - 1])*"+ p[k]+"(p[k])*"+p[j]+"(p[j])");
					if (t < m[i][j]) {
						// ��m��s����ֵ
						m[i][j] = t;
						//System.out.println("tΪ"+t);
						s[i][j] = k;
					}
				}
			}
		}
	}

/**
 * @author ���
 *	�ݹ�ķ���
 */
	public static int diGui(int[] p,int i,int j,int[][] s) {
		if(i==j)
			return 0;
		int u=diGui(p,i,i,s)+diGui(p,i+1,j,s)+p[i-1]*p[i]*p[j];
		s[i][j]=i;
		for(int k=i+1;k<j;k++) {
			int t=diGui(p,i,k,s)+diGui(p,k+1,j,s)+p[i-1]*p[k]*p[j];
			if(t<u) {
				u=t;
				s[i][j]=k;
			}
		}
		return u;
	}
	/**
	 * @author ���
	 *	����¼�ķ���
	 */
	public static int bwl(int i,int j,int[] p,int [][]m,int[][] s) {
		if(m[i][j]>0) {
			return m[i][j];
		}
		if(i==j) {
			return 0;
		}
		int u=bwl(i, i, p, m, s)+bwl(i+1, j, p ,m, s)+p[i-1]*p[i]*p[j];
		s[i][j]=i;
		for(int k=i+1;k<j;k++) {
			int t=bwl(i, k, p, m, s)+bwl(k+1, j, p ,m, s)+p[i-1]*p[k]*p[j];
			if(t<u) {
				u=t;
				s[i][j]=k;
			}
		}
		m[i][j]=u;
		return u;
	}

	/**
	 * @see ��ӡ�����ŵ����Žⷽ��
	 * @param s�����Ž������ȡ��kֵ�ľ���
	 * @param i������ĵ�һ��A1
	 * @param j����������һ��A(n-1)
	 */
	public static void OptimalParens(int[][] s, int i, int j) {
		if (i == j) {
			System.out.print("A" + i);
		} else if (i + 1 == j) {
			System.out.print(" (A" + i + " A" + j + ") ");
		} else {
			System.out.print(" (");
			// �ݹ����
			OptimalParens(s, i, s[i][j]);
			OptimalParens(s, s[i][j] + 1, j);
			System.out.print(") ");
		}
	}
}