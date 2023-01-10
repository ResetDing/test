package bag;

import java.util.Arrays;
import java.util.Random;

public class Bag {
	/**
	 * @author 丁丽媛
	 * 0-1背包问题
	 * @param V	背包容量
	 * @param N	物品种类
	 * @param weight 物品重量
	 * @param value	物品价值
	 * @return
	 */
	public static void main(String[] args) {
		System.out.println("2018143124 丁丽媛");
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
		System.out.println("背包中物品的质量为"+Arrays.toString(w));
		System.out.println("背包中物品的价值为"+Arrays.toString(value));
		String s=ZeroOnePack(v, n, w, value);
		System.out.println(s);
	}
	public static String ZeroOnePack(int V,int N,int[] weight,int[] value){
		
		int[][] dp = new int[N+1][V+1];
		//为了便于理解,将dp[i][0]和dp[0][j]均置为0，从1开始计算
		for(int i=1;i<N+1;i++){
			for(int j=1;j<V+1;j++){
//				System.out.print("当背包容量为"+j+"千克的时候");
				//如果第i件物品的重量大于背包容量j,则不装入背包
				//由于weight和value数组下标都是从0开始,故注意第i个物品的重量为weight[i-1],价值为value[i-1]
//				System.out.println("，此时物品"+i+"的重量为"+weight[i-1]+",价值为"+value[i-1]);
				if(weight[i-1] > j) {
					//System.out.println("此时物品"+i+"的重量大于现在的j:"+j+"千克，所以dp["+i+"]["+j+"]="+"dp["+(i-1)+"]["+j+"]="+dp[i-1][j]);
					dp[i][j] = dp[i-1][j];
				}
				else {
					int s=Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+value[i-1]);
					//System.out.println("此时物品"+i+"的重量小于等于现在的j:"+j+"千克，装得下,然后dp["+i+"]["+j+"]="+s+",dp[i-1][j]="+dp[i-1][j]+",dp[i-1][j-weight[i-1]]+value[i-1]="+dp[i-1][j-weight[i-1]]+"+"+value[i-1]);
					dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+value[i-1]);
				}
					
			}
		}
		//打印动态规划的表格
		System.out.println("矩阵如下：");
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
		//则容量为V的背包能够装入物品的最大值为
		int maxValue = dp[N][V];
		System.out.println("最大的价值为"+maxValue);
		//逆推找出装入背包的所有商品的编号
		int j=V;
		String numStr="";
		for(int i=N;i>0;i--){
			//若果dp[i][j]>dp[i-1][j],这说明第i件物品是放入背包的
			if(dp[i][j]>dp[i-1][j]){
				numStr = i+" "+numStr;
				j=j-weight[i-1];
			}

			if(j==0)
				break;
		}
		numStr="添加顺序为"+numStr;
		return numStr;	
	}
}
