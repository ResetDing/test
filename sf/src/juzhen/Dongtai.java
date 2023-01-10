package juzhen;
import java.util.Random;

public class Dongtai {

    public int LookupM(int i,int j,int[] p,int[][] m,int[][] s)
    {
        if (m[i][j] > 0) return m[i][j];
        if (i == j) return 0;
        int u = LookupM(i,i,p,m,s) + LookupM(i+1,j,p,m,s) + p[i-1]*p[i]*p[j];
        s[i][j] = i;
        for (int k = i+1; k < j; k++) {
            int t = LookupM(i,k,p,m,s) + LookupM(k+1,j,p,m,s) + p[i-1]*p[k]*p[j];
            if (t < u) { u = t; s[i][j] = k;}
        }
        m[i][j] = u;
        return u;
    }
    public int M(int i ,int j,int[] p,int[][] m,int[][] s){
        if(i==j) return 0;
        int u=M(i,i,p,m,s)+M(i+1,j,p,m,s)+p[i-1]*p[i]*p[j];
        s[i][j]=i;
        for(int k =i+1;k<j;k++){
            int t=M(i,k,p,m,s)+M(k+1,j,p,m,s)+p[i-1]*p[k]*p[j];
            if(t<u){u=t;s[i][j]=k;}
        }
        return u;
    }
    public int martixChain(int n,int[] p,int[][] m,int[][] s) {
        int dongtai=0;
        for (int i = 1; i <= n; i++)
            m[i][i] = 0;
        for (int r = 2; r <= n; r++) {
            for (int i = 1; i <= n - r+1; i++) {
                int j = i + r - 1;
                m[i][j] = m[i + 1][j] + p[i] * p[i - 1] * p[j];
                dongtai=m[i][j];
                s[i][j] = i;
                for (int k = i + 1; k < j; k++) {
                    int t = m[i][k] + m[k + 1][j] + p[i-1] * p[k ] * p[j];
                    if (t < m[i][j]) {
                        m[i][j] = t;
                        dongtai=m[i][j];
                        s[i][j] = k;
                    }
                }
            }
        }
        return  dongtai;
    }
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

    public static void main(String[] args) {
        System.out.println("2018143124-丁丽媛");
        int size=24;
        System.out.println("矩阵个数:"+size);
        int[] p=new int[size];
        int[][] m=new int[size][size];
        int[][] s=new int[size][size];
        Random r=new Random();
        for(int i=0;i<p.length;i++) {
            p[i]=r.nextInt(29)+1;
        }
        Dongtai dt=new Dongtai();
        long startTime1 = System.currentTimeMillis();
        int bwl=dt.LookupM(1,size-1,p,m,s);
        long endTime1 = System.currentTimeMillis();
        System.out.println("备忘录运行结果:");
        System.out.println(bwl);
        System.out.println("备忘录程序运行时间：" + (endTime1 - startTime1) + "ms");
        long startTime2 = System.currentTimeMillis();
        //int fenzhi=dt.M(1,size-1,p,m,s);
        long endTime2 = System.currentTimeMillis();
        System.out.println("分治法运行结果:");
        //System.out.println(fenzhi);
        System.out.println("分治法程序运行时间：" + (endTime2 - startTime2) + "ms");
        long startTime3 = System.currentTimeMillis();
        int dongtai=dt.martixChain(size-1,p,m,s);
        long endTime3 = System.currentTimeMillis();
        System.out.println("动态规划运行结果:");
        System.out.println(dongtai);
        System.out.println("动态规划程序运行时间：" + (endTime3 - startTime3) + "ms");
        System.out.println("最优加括号方式:");
        dt.OptimalParens(s,1,size-1);
    }

}
