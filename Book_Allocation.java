import java.util.*;
public class Book_Allocation {
    private static boolean canReadForCapacity(int[] pages, int numSt, int maxCap) {
		int stNum = 1;
		int pagesRead = 0;
		int bookNum = 0;
		while(bookNum < pages.length) {
			if(pages[bookNum] + pagesRead <= maxCap) {
				pagesRead += pages[bookNum];
				bookNum++;
			} else {
				stNum++;
				pagesRead = 0;
			}
			if(stNum > numSt) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		for(int x=1;x<=a;x++){
			int n = sc.nextInt();
			int numSt = sc.nextInt();
			int[] pages = new int[n];
			int sum = 0;
			for(int i=0;i<n;i++){
				pages[i] = sc.nextInt();
				sum = sum+pages[i];
			}
			
			
			int l = 0, r = sum;
			
			while(r > l + 1) {
				int mid = (l + r) / 2; 
				if(canReadForCapacity(pages, numSt, mid)) {
					r = mid;
				} else {
					l = mid;
				}
			}
			System.out.println(r);
		}
	}
}
