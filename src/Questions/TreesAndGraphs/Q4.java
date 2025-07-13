package Questions.TreesAndGraphs;
/*Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
node never differ by more than one. 6.49*/

class TreeNodeQ4{
    int data;
    TreeNodeQ4 left;
    TreeNodeQ4 right;

    public TreeNodeQ4(int value){
        this.data = value ;
        left = null;
        right = null;
    }
}
public class Q4 {
    static boolean isBalanced(TreeNodeQ4 rootNode){
        return checkBalance(rootNode)!=-1;
    }

    static int checkBalance(TreeNodeQ4 rootNode){
        if(rootNode==null) return 0;

        int leftHeight = checkBalance(rootNode.left);
        if(leftHeight==-1) return -1;

        int rightHeight = checkBalance(rootNode.right);
        if(rightHeight==-1) return -1;

        //check if current node height
        if (Math.abs(leftHeight-rightHeight)>1) return -1;

        //final height of node
        return 1 + Math.max(leftHeight,rightHeight ) ;
    }
    public static void main (String[] args){
        TreeNodeQ4 root = new TreeNodeQ4(1);
        root.left = new TreeNodeQ4(2);
        root.right = new TreeNodeQ4(3);
        root.left.left = new TreeNodeQ4(4);
        root.left.right = new TreeNodeQ4(5);

        System.out.println("Is tree balance : "+ isBalanced(root));

        root.left.left.left = new TreeNodeQ4(6);

        System.out.println("Is tree balance : "+ isBalanced(root));
    }
}
