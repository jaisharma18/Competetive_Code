import java.util.*;
public class Mazepath_D2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        solve(n - 1, n - 1, 0, 0, "");
        System.out.println("\n" + solve(n - 1, n - 1, 0, 0));
    }

    public static void solve(int er,int ec,int cr,int cc,String ans){
        if(cr == er && cc == ec){
            System.out.print(ans + " ");
            return;
        }

        if(cr > er || cc > ec){
            return;
        }

        solve(er, ec, cr + 1, cc, ans + "V");
        solve(er, ec, cr, cc + 1, ans + "H");
        if(cr == cc || cr + cc == er)
            solve(er, ec, cr + 1, cc + 1, ans + "D");
    }

    public static int solve(int er,int ec,int cr,int cc){
        if(cr == er && cc == ec){
            return 1;
        }

        if(cr > er || cc > ec){
            return 0;
        }
        int d = 0;
        int v = solve(er, ec, cr + 1, cc);
        int h = solve(er, ec, cr, cc + 1);
        if(cr == cc || cr + cc == er)
            d = solve(er, ec, cr + 1, cc + 1);
        return v + h + d;
    }
}
