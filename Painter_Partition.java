import java.util.*;
public class Painter_Partition {
    public static boolean isPossible(ArrayList<Integer>arr,int n,int mid)
    {
        int sum=0;
        int count=1;
       for(int i=0;i<arr.size();i++){
           sum=sum+arr.get(i);
           if(sum>mid){
               sum=arr.get(i);
               count++;
           }
       }
       if(count<=n){
           return true;
       }
       return false;
              
    }

    public static int paint(int A, int B, ArrayList<Integer> C) {
        int n = C.size();
        int l=0,r=0;
        for(Integer i : C){
            l = Math.max(l,(int)i);
            r+=(int)i;
        }
        int mid;
        while(l<r)
        {
            mid=(l+(r-l)/2);
            if(isPossible(C,A,mid))
            {
                r=mid;
            }
            else
            {
                l=mid+1;
            }
            
        }
        return (int)((long)l*(long)B % 10000003);
        
    }
    
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
		int n = sc.nextInt();
        int b=1;
        ArrayList<Integer> arr= new ArrayList<Integer>();
        while (sc.hasNextInt()) {
            int i = sc.nextInt();
            arr.add(i);
        }
        System.out.println(paint(a,b,arr));
    }
}
