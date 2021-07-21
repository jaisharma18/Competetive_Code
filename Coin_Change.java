import java.util.*;
public class Coin_Change {
    private static int coinChange(int[] coins, int n, int amount, int[][] dp) {
		if(amount == 0) {
			return 1; 
		}
		if(n == 0) {
			return 0;
		}
		if(dp[n][amount] != -1) {
			return dp[n][amount];
		}
		int inc = 0, exc = 0;
		if(coins[n - 1] <= amount) {
			inc = coinChange(coins, n, amount - coins[n - 1], dp);
		}
		exc = coinChange(coins, n - 1, amount, dp);
		return dp[n][amount] = inc + exc;
	}
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		int[][] dp = new int[n + 1][m + 1];
		for(int[] row : dp) {
			Arrays.fill(row, -1);
		}
		System.out.print(coinChange(arr,n,m,dp));  
    }
}
