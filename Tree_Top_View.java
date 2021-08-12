import java.util.*;
public class Tree_Top_View {
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in));
        String[] arr=sc.nextLine().split(" ");
        BinaryTree bt=new BinaryTree(arr);
        
        bt.topview();
        
    }
}

class BinaryTree
{
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
	static TreeMap<Integer, pair> map = new TreeMap<>();

    BinaryTree(String[] arr)
    {
        Queue<Node> queue=new LinkedList<Node>();
        construct(arr,0,queue);
    }

	static class pair {
       int data, lvl;
       pair(int i, int j)
       {
           data = i;
           lvl = j;
       }
   }

    public void topview()
    {
        verticalTraversalTop(this.root);
    }
	
   static void fillMap(Node root, int d, int l)
   {
       if (root == null)
           return;

       if (map.get(d) == null) {
           map.put(d, new pair(root.data, l));
       }
       else if (map.get(d).lvl > l) {
           map.put(d, new pair(root.data, l));
       }

       fillMap(root.left, d - 1, l + 1);
       fillMap(root.right, d + 1, l + 1);
   }

  private void verticalTraversalTop(Node root) {
	   fillMap(root, 0, 0);

       for (Map.Entry<Integer, pair> e :map.entrySet()) {
           if(e.getValue().data != -1){
				System.out.print(e.getValue().data + " ");
			}
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
