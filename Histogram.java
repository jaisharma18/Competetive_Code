import java.util.*;
public class Histogram {
    static void areaHist(int[] heights,int n){
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        left[0] = 0;
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                left[i] = stack.pop();
            }
            left[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }
        stack.clear();

        right[n-1] = n - 1;
        stack.push(n-1);
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                right[i] = stack.pop();
            }
            right[i] = stack.isEmpty() ? heights.length - 1 : stack.peek() - 1;
            stack.push(i);
        }
        long maxArea = 0;
        for (int i = 0; i < n; i++) {
            long area = (long) heights[i] * (right[i] - left[i] + 1);
            maxArea = Math.max(area,maxArea);
        }
        System.out.println(maxArea);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        areaHist(arr,n);
    }
}
