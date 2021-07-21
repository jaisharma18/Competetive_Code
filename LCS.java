import java.util.*;
public class LCS {
    public static int lengthOfLIS(int[] nums) {
		int[][] dp = new int[nums.length + 1][nums.length + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		return recursive(nums, 0, -1, nums.length, dp);
	}

	private static int recursive(int[] nums, int curr, int prev, int n, int[][] dp) {
		if (curr == n) {
			return 0;
		}
		if (dp[curr][prev + 1] != -1) {
			return dp[curr][prev + 1];
		}
		int inc = 0, exc = 0;
		if (prev == -1 || nums[curr] > nums[prev]) {
			inc = 1 + recursive(nums, curr + 1, curr, n, dp);
		}
		exc = recursive(nums, curr + 1, prev, n, dp);
		return dp[curr][prev + 1] = Math.max(inc, exc);
	}
    public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		System.out.print(lengthOfLIS(arr));
    }
}
