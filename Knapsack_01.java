import java.util.*;
public class Knapsack_01 {
    private static int sol(int[] weight, int[] cost, int n, int bagC, int[][] dp) {
		if(bagC == 0 || n == 0) {
			return 0;
		}
		if(dp[n][bagC] != -1) {
			return dp[n][bagC];
		}
		int inc = 0, exc = 0;	
		if(weight[n - 1] <= bagC) {
			inc = cost[n - 1] + sol(weight, cost, n - 1, bagC - weight[n - 1], dp);
		}
		exc = sol(weight, cost, n - 1, bagC, dp);
		return dp[n][bagC] =  Math.max(inc, exc);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
		int[] weight = new int[m];
		int[] cost = new int[m];
        for(int i=0;i<m;i++){
            weight[i]=sc.nextInt();
        }
		for(int i=0;i<m;i++){
            cost[i]=sc.nextInt();
        }
		int[][] dp = new int[m + 1][n + 1];
		for(int[] row : dp) {
			Arrays.fill(row, -1);
		}
		System.out.println(sol(weight, cost, m, n, dp));
	}
}
