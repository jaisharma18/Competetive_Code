import java.util.*;
public class K_Order_LCS {
    private static int lcsKorder(int[] arr1,int[] arr2,int n,int m,int k,int[][][] d){
		if(k<0){
			return -1;
		}
		if(n<0 || m<0){
			return 0;
		}
		
		if(d[n][m][k]!=-1){
			return d[n][m][k];		
			}
		try
		{
			d[n][m][k]=Math.max(lcsKorder(arr1,arr2,n-1,m,k,d),lcsKorder(arr1,arr2,n,m-1,k,d));
			if(arr1[n-1]==arr2[m-1]){
				d[n][m][k]=Math.max(d[n][m][k],1+lcsKorder(arr1,arr2,n-1,m-1,k,d));
			}
			d[n][m][k]=Math.max(d[n][m][k],1+lcsKorder(arr1,arr2,n-1,m-1,k-1,d));
		}	
		catch (Exception e){ }
		return d[n][m][k];
	}
    public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int k=sc.nextInt();
		int[] arr1=new int[n];
		int[] arr2= new int[m];
		for(int i=0;i<n;i++){
			arr1[i]=sc.nextInt();

		}
		for(int j=0;j<m;j++){
			arr2[j]=sc.nextInt();
		}
		int[][][] d= new int[n+1][m+1][k+1];
		for(int[][] row : d){
			for(int[] rowColumn:row){
				Arrays.fill(rowColumn,-1);
			}
		}
		System.out.println(lcsKorder(arr1,arr2,n,m,k,d));
		

    }
}
