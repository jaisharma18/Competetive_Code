import java.util.*;
public class ArrayList_Of_Lev {
	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList_Of_Lev m = new ArrayList_Of_Lev();
		BinaryTree bt1 = m.new BinaryTree();
		bt1.lvlOrder();
	}

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;
		}

		private Node root;
		private int size;

		public BinaryTree() {
			this.root = this.takeInput(null, false);
		}

		public Node takeInput(Node parent, boolean ilc) {

			int cdata = scn.nextInt();
			Node child = new Node();
			child.data = cdata;
			this.size++;

			// left
			boolean hlc = scn.nextBoolean();

			if (hlc) {
				child.left = this.takeInput(child, true);
			}

			// right
			boolean hrc = scn.nextBoolean();

			if (hrc) {
				child.right = this.takeInput(child, false);
			}

			// return
			return child;
		}

		public void lvlOrder() {
		this.lvlOrder(this.root);
		}
	
		private void lvlOrder(Node root) {
			
			Queue<Node> bfs = new LinkedList<>();
			
			bfs.add(root);
			List<List<Integer>> ans = new ArrayList<>();
			while(!bfs.isEmpty()) {
				
				List<Integer> currLvl = new ArrayList<>();
				int numNodesAtCurrLvl = bfs.size();//2
				
				for(int i = 0; i < numNodesAtCurrLvl; i++) {//0, 1
					Node front = bfs.poll();
					currLvl.add(front.data);
					
					if(front.left != null) {
						bfs.add(front.left);
					}
					
					if(front.right != null) {
						bfs.add(front.right);
					}
				}
				
				ans.add(currLvl);
			}
			System.out.println(ans);
		}
	}
}
