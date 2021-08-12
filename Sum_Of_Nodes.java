import java.util.*;
public class Sum_Of_Nodes {
    static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		Sum_Of_Nodes m = new Sum_Of_Nodes();
		BinaryTree bt = m.new BinaryTree();
		System.out.println(bt.sumOfNodes());
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

		public int sumOfNodes() {
			return this.sumOfNodes(this.root) ;
		}
		
		private int sumOfNodes(Node node) {   

			int sum, sumLeft, sumRight;  
			sum = sumRight = sumLeft = 0;  
			if(node.left != null)  
				sumLeft = sumOfNodes(node.left);  
				
			if(node.right != null)  
				sumRight = sumOfNodes(node.right);  
				
			sum = node.data + sumLeft + sumRight;   
			return sum;  
		}  
	}
}
