import java.util.*;
public class Root_To_Leaf {
    static Scanner sc= new Scanner(System.in);
	public static void main(String args[]) {
        
        Bt node = inputTree();
        int target = sc.nextInt();
        List<Integer> l = new ArrayList<>();
        print(node, target, l);
    }

    static class Bt{
        Bt left;
        Bt right;
        int val;
    }
    
    static Bt inputTree(){

       int val = sc.nextInt();
       Bt node = new Bt();
       node.val = val;

       boolean x = sc.nextBoolean();
       if(x == true)
            node.left = inputTree();

        x = sc.nextBoolean();
        if(x == true)
            node.right = inputTree();

        return node;
    }

    static boolean print(Bt root, int target, List<Integer> l){
        target = target - root.val;
        l.add(root.val);

        if(root.left == null && root.right == null){
            if(target == 0){
                for(int x : l)
                    System.out.print(x + " ");
            }
            
            return false;
        }
        
        boolean left = false, right = false;
        if(root.left != null)
            left = print(root.left, target, l);
        if(root.right != null)
            right = print(root.right, target, l);

        l.remove(0);
        
        return (left || right);
    }
}
