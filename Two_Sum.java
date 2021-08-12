import java.util.*;
public class Two_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
		int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
		int target = sc.nextInt();
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < arr.length; i++) {
			map.put(arr[i], i);
		}
        int a=0;
		for(int i = 0; i < arr.length; i++) {
			int searchInMap = target - arr[i]; 
			
			if(map.containsKey(searchInMap) && i != map.get(searchInMap)) {
				int[] pair = new int[2];
				pair[0] = i;
				pair[1] = map.get(searchInMap); 
				if(pair[0]<pair[1]){
                    System.out.print(pair[0]+1);
                    System.out.print(" ");
                    System.out.print(pair[1]+1);
                    break;
                }
			}
		}
    }
}
