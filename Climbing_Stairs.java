import java.util.*;
public class Climbing_Stairs {
    public static int climbStairs(int n) {
        if(n<3) 
			return n;
        int n1 = 1;
        int n2 = 2;
        int sum = 0;
        for(int i = 3; i <= n; i++){
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }
        return sum;
    }
    public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		System.out.print(climbStairs(a));
    }
}
