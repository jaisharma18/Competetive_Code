import java.util.*;
public class Min_Path_Sum {
    public static int sol(int[][] grid, int cr, int cc, int er, int ec) {
		if(cr > er || cc > ec) {
			return -1;
		}
		
		if(cr == er && cc == ec) {
			return grid[cr][cc];
		}
		int c1 = sol(grid, cr, cc + 1, er, ec);
		int c2 = sol(grid, cr + 1, cc, er, ec);
        int minAns;
        if(c1<0)
            minAns = c2;
        else if(c2<0)
            minAns = c1;
        else
		    minAns = Math.min(c1, c2);
		return grid[cr][cc] + minAns;
	}
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int arr[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.print(sol(arr,0,0,m-1,n-1)); 
   }
}
