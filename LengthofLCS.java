import java.util.*;
public class LengthofLCS {
    public static int sol(String s1, String s2, int n, int m,int[][]dp) {
		if(n == 0 || m == 0) {
			return 0;
		}
		if(dp[n][m] != -1) {
			return dp[n][m];
		}
		int ans;
		if(s1.charAt(n - 1) == s2.charAt(m - 1)) {
			return 1 + sol(s1, s2, n - 1, m - 1,dp);
		}
		else{
			int c1 = sol(s1, s2, n - 1, m,dp);
			int c2 = sol(s1, s2, n, m - 1,dp);
			ans = Math.max(c1, c2);
		}
		dp[n][m]=ans;
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		int n=s1.length();
		int m=s2.length();	
		int[][] dp = new int[n + 1][m + 1];
		for(int[] row : dp) {
			Arrays.fill(row, -1);
		}
		System.out.println(sol(s1, s2, n,m,dp ));
	}
}
