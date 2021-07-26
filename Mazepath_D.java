import java.util.*;
public class Mazepath_D {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        solve(n1, n2, 0, 0, "");
        System.out.println("\n" + solve(n1, n2, 0, 0));
    }

    public static void solve(int er,int ec,int cr,int cc,String ans){
        if(cr == er - 1 && cc == ec - 1){
            System.out.print(ans + " ");
            return;
        }

        if(cr > er || cc > ec){
            return;
        }

        solve(er, ec, cr + 1, cc, ans + "V");
        solve(er, ec, cr, cc + 1, ans + "H");
        solve(er, ec, cr + 1, cc + 1, ans + "D");
    }

    public static int solve(int er,int ec,int cr,int cc){
        if(cr == er - 1 && cc == ec - 1){
            return 1;
        }

        if(cr > er || cc > ec){
            return 0;
        }

        int v = solve(er, ec, cr + 1, cc);
        int h = solve(er, ec, cr, cc + 1);
        int d = solve(er, ec, cr + 1, cc + 1);
        return v + h + d;
    }
}
