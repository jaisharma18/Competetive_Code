import java.util.*;
public class Distinct_Subs {
    private static int sol(String source, String target, int n, int m, int[][] dp) {
		if(m == -1) {
			return 1; 
		}
		if(n == -1) {
			return 0;
		}
		if(dp[n][m] != -1) {
			return dp[n][m];
		}
		int inc = 0, exc = 0;
		if(source.charAt(n) == target.charAt(m)) {
			inc = sol(source, target, n - 1, m - 1,  dp);
		}
		exc = sol(source, target, n - 1, m, dp);
		return dp[n][m] = inc + exc;
	}
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        for(int i=0;i<x;i++){
            String source = sc.next();
		    String target = sc.next();
            int n = source.length();
            int m = target.length();
            int[][] dp = new int[n + 1][m + 1];
            for(int[] row : dp) {
                Arrays.fill(row, -1);
            }	
            System.out.println(sol(source, target, n-1, m-1, dp));
        }
	}
}
