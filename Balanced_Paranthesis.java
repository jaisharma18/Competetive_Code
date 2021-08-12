import java.util.*;
public class Balanced_Paranthesis {
    public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		String str = s.next();
		int stack = str.length();
		if (isBalanced(str, stack)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

	public static boolean isBalanced(String str, int stack) throws Exception {
		Stack<Character> s = new Stack<>();
		for(int i = 0; i < stack; i++) {
			char ci = str.charAt(i);
			
			if(ci == '[' || ci == '{' || ci == '(') {
				s.push(ci);
			} 
			else if(ci == ')' || ci == '}' || ci == ']'){
				
				if(s.isEmpty()) {
					return false;
				} 
				
				char topCh = s.pop();
				
				if(topCh == '(' && ci == ')') {
					continue;
				} 
				
				if(topCh == '{' && ci == '}') {
					continue;
				} 
				
				if(topCh == '[' && ci == ']') {
					continue;
				}
				
				return false; 
			}
		}
		
		if(s.isEmpty()) {
			return true;
		} 
		else {
			return false;
		}
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
	}
}
