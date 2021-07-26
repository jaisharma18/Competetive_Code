import java.util.*;
public class Rec_Lexi_Order {
    public static void lexico(int initial, int end) {
		if(initial > end) {
			return;
		}
		
		System.out.print(initial+" ");
		
		int callNumber = 0;
		
		if(initial == 0) {
			callNumber = 1;
		}
		
		while(callNumber <= 9) {
			lexico(initial * 10 + callNumber, end);
			callNumber++;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
		lexico(0,n);
	}
}
