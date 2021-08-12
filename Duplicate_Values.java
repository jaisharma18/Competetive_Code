import java.util.*;
public class Duplicate_Values {
    public static void main(String []as){
        Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            int a = sc.nextInt();
    
            int c=0;
            for(int i = 0; i < n; i++) {
                for(int j=i+1;j<n;j++){
                    if(arr[i]==arr[j])
                    {
                        if(Math.abs(i-j)==a)
                        {    System.out.print("true");
                            c=1;
                            break;
                        }
                    }
                }
                if(c==1){
                    break;
                }
            }
            if(c==0)
                System.out.print("false");
        }
}
