import java.util.*;
public class Stock_Span {
    public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		int N=s.nextInt();
		int[] prices=new int[N];
		for(int i=0;i<N;i++){
			prices[i]=s.nextInt();
		}
		int[] ans=StockSpanUsingStacks(prices, N);
		for(int i=0;i<ans.length;i++){
			System.out.print(ans[i]+" ");
		}
		System.out.println("END");

	}

	public static int[] StockSpanUsingStacks(int[] prices, int stack) throws Exception {
		int[] res = new int[stack];
		res[0] = 1;
		Stack<Integer> st = new Stack<>();
		st.push(0);
		for(int curr = 1; curr < stack; curr++) {
			while(!st.isEmpty() && prices[curr] > prices[st.peek()]) {
				st.pop();
			}	
			res[curr] =  st.isEmpty() ?  curr + 1: curr - st.peek();
			st.push(curr);
		}
		return res;
	}

	private class StacksUsingArrays {
		private int[] data;
		private int tos;

		public static final int DEFAULT_CAPACITY = 10;

		public StacksUsingArrays() throws Exception {
			// TODO Auto-generated constructor stub
			this(DEFAULT_CAPACITY);
		}

		public StacksUsingArrays(int capacity) throws Exception {
			if (capacity <= 0) {
				System.out.println("Invalid Capacity");
			}
			this.data = new int[capacity];
			this.tos = -1;
		}

		public int size() {
			return this.tos + 1;
		}

		public boolean isEmpty() {
			if (this.size() == 0) {
				return true;
			} else {
				return false;
			}
		}
	}
}
