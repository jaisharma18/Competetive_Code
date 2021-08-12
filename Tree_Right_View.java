import java.util.*;
public class Tree_Right_View {
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        String[] arr=sc.nextLine().split(" ");
        BinaryTree bt=new BinaryTree(arr);
        
        bt.rightView();
        
    }
}

class BinaryTree
{
	static int max_level;
    private class Node
    {
        int data;
        Node left,right;
        Node(int data)
        {
            this.data=data;
        }
    }

    Node root;

    BinaryTree(String[] arr)
    {
        Queue<Node> queue=new LinkedList<Node>();
        construct(arr,0,queue);
    }

    public void rightView()
    {
        rightView(this.root,1);
    }

   private void rightView(Node root, int level) {
	   if (root == null)
            return;
		
		if(root.data>=0){
			if (max_level < level) {
				System.out.print(root.data+" ");
				max_level = level;
			}
	
			rightView(root.right, level + 1);
			rightView(root.left, level + 1);
		}
	}


    private void construct(String[] arr,int ind,Queue<Node> queue)
    {
        if(ind>=arr.length)
        return;
        if(queue.size()==0)
        {
            Node nn=new Node(Integer.parseInt(arr[ind]));
            this.root=nn;
            queue.add(nn);
        }
        else
        {
            Node parent=queue.peek();
                if(parent.data!=-1){
                if(parent.left==null)
                {
                    parent.left=new Node(Integer.parseInt(arr[ind]));
                    queue.add(parent.left);
                }
                else
                {
                    if(parent.right==null)
                    {
                    parent.right=new Node(Integer.parseInt(arr[ind]));
                    queue.add(parent.right);
                    queue.poll();
                    }
               }
               }
               else
               {
                   queue.poll();
                   ind--;
               }
        }
        construct(arr,ind+1,queue);
    }

    public void display()
    {
        display_tree(this.root);
    }

    private void display_tree(Node root)
    {
        if(root==null)
        return;
        String str=root.data+"";
        if(root.left!=null)
        {
            str=root.left.data+" <= "+str;
        }
        else
        {
            str="END <= "+str;
        }

        if(root.right!=null)
        {
            str=str+" => "+root.right.data;
        }
        else
        {
            str=str+" => END";
        }
        System.out.println(str);
        display_tree(root.left);
        display_tree(root.right);
    }
}
