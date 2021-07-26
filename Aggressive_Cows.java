import java.util.*;
public class Aggressive_Cows {
    private static boolean isPlaced(int[] stalls, int cows, int mid) {
		int placedPos = stalls[0];
		int numPlaced = 1;
		
		for(int stallNum = 1; stallNum < stalls.length; stallNum++) {
			if(numPlaced == cows) {
				return true;
			}
			int currStall = stalls[stallNum];
			if(currStall - placedPos >= mid) {
				numPlaced++;
				placedPos = currStall;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] stalls = new int[n];
		for(int i=0;i<n;i++)
			stalls[i] = sc.nextInt();
		Arrays.sort(stalls);
		int l = 0, r = stalls[n - 1] - stalls[0]; 
		while(r > l + 1) {
			int mid = l + (r - l) / 2; 
			if(isPlaced(stalls, m, mid)) {
				l = mid;
			} else {
				r = mid;
			}
		}
		
		System.out.println(l);
	}
}
