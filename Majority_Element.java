import java.util.*;
public class Majority_Element {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = sc.nextInt();
		}
		Map<Integer, Integer> freqMap = new HashMap<>();
		
		for(int e : arr) {
			
			int value = freqMap.getOrDefault(e, 0);
			value++;
			freqMap.put(e, value);
		}
		
		int minVal =  n / 2;
		
		for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			if(entry.getValue() > minVal)
			System.out.println(entry.getKey());
		}
	}
}
