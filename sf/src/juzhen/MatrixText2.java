package juzhen;

import java.util.Random;

/**
 * @author 李犇
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
//		System.out.print("您输入的矩阵为：");
//		for (int i = 0; i < n - 1; i++) {
//			System.out.print("A" + (i + 1) + "[" + p[i] + "]" + "[" + p[i + 1] + "]" + "  ");
//		}
		System.out.println("2018143114 李犇");
		int[][] m = new int[n][n];
		int[][] s = new int[n][n];
		//这个是用递归的方法实现
		int l=1,jj=n-1;
		int ss=diGui(p, l, jj, s);
		System.out.println("使用分治的代码运行结果，从矩阵"+l+"到矩阵"+jj+"连乘最小乘次为"+ss+"，断点在矩阵"+s[l][jj]);
		System.out.println("-------分-------界-------线-------");
		l=1;
		jj=n-1;
		System.out.println("下面是备忘录的运行结果：");
		int sss=bwl(l,jj, p,m, s);
		System.out.println("使用备忘录的代码运行结果，从矩阵"+l+"到矩阵"+jj+"连乘最小乘次为"+sss+"，断点在矩阵"+s[l][jj]);
		System.out.println("-------分-------界-------线-------");
		System.out.println("下面是动态规划的运行结果：");
		matrixChain(p, m, s);
		System.out.println("使用备忘录的代码运行结果，从矩阵"+l+"到矩阵"+jj+"连乘最小乘次为"+m[l][jj]+"，断点在矩阵"+s[l][jj]);
		// 打印m矩阵
//		System.out.println("打印m["+(n-1)+"]["+(n-1)+"] 矩阵：");
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
//		// 打印s矩阵
//		System.out.println("打印s["+(n-1)+"]["+(n-1)+"] 矩阵：");
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
		System.out.println("矩阵连乘加括号方式为：");
		OptimalParens(s, 1, n - 1);

	}

/**
 * @author 李犇
 *动态规划的方法
 */
	public static void matrixChain(int[] p, int[][] m, int[][] s) {
		int n = p.length - 1;// 求出矩阵的个数
		// 给m矩阵主对角线赋值为0
		for (int i = 1; i <= n; i++) {
			m[i][i] = 0;
		}
		for (int r = 2; r <= n; r++) {
			//System.out.println("外层大循环开始，r="+r);
			for (int i = 1; i <= n - r + 1; i++) {
				
				int j = i + r - 1;
				//System.out.println("第二大循环开始，i="+i+",j="+j);
				// 给矩阵设置一个超大值，为后面的比较做准备
				m[i][j] = 999999999;
				
	
				for (int k = i; k < j; k++) {//k是个断点，然后就是k从它自身开始，一个一个往后挪，
					//System.out.println("最内层循环开始，k="+k);
					// 计算相乘的次数

					int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
					
					//System.out.println("此时i是"+i+",j是"+j+",r是"+r+",t是"+t+"，k是"+k+",m["+i+"]["+k+"]("+m[i][k]+")+m["+(k+1)+"]["+j+"]("+m[k + 1][j]+")+"+p[i - 1]+"(p[i - 1])*"+ p[k]+"(p[k])*"+p[j]+"(p[j])");
					if (t < m[i][j]) {
						// 给m和s矩阵赋值
						m[i][j] = t;
						//System.out.println("t为"+t);
						s[i][j] = k;
					}
				}
			}
		}
	}

/**
 * @author 李犇
 *	递归的方法
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
	 * @author 李犇
	 *	备忘录的方法
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
	 * @see 打印加括号的最优解方案
	 * @param s：最优解矩阵所取得k值的矩阵
	 * @param i：矩阵的第一个A1
	 * @param j：矩阵的最后一个A(n-1)
	 */
	public static void OptimalParens(int[][] s, int i, int j) {
		if (i == j) {
			System.out.print("A" + i);
		} else if (i + 1 == j) {
			System.out.print(" (A" + i + " A" + j + ") ");
		} else {
			System.out.print(" (");
			// 递归调用
			OptimalParens(s, i, s[i][j]);
			OptimalParens(s, s[i][j] + 1, j);
			System.out.print(") ");
		}
	}
}