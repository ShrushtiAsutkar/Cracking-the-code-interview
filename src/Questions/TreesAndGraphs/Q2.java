package Questions.TreesAndGraphs;
/*Minimal Tree: Given a sorted (increasing order) array with unique integer elements,
write an algorithm to create a binary search tree with minimal height*/


// TODO: Create TreeNode class with int data, TreeNode left, and TreeNode right
class TreeNode{
    int data ;
    TreeNode left;
    TreeNode right;

    public TreeNode(int Data){
        this.data = Data;
    }
}
public class Q2 {
   // TODO: Create method TreeNode createMinBST(int[] arr)

    static TreeNode createMinBST(int[] array){
        return createMinBST(array,0,array.length-1);
    }

    // TODO: Create helper method TreeNode createMinBST(int[] arr, int start, int end)
     static TreeNode createMinBST(int[] array,int start,int end){
        if (start>end)
        {
            return null;
        }
         // TODO: In helper, find mid index = (start + end) / 2
         int mid = (start+end)/2;

        // TODO: Create new TreeNode with value arr[mid]
         TreeNode node = new TreeNode(array[mid]);


        // TODO: Set left node
         node.left = createMinBST(array,start,mid-1);

        // TODO: Set right node
         node.right = createMinBST(array,mid+1,end);

        // TODO: Return the node

        return node;
    }

    // TODO: (Optional) Write method to print tree (e.g., in-order or pre-order)
    static void printTree(TreeNode node , String indent, boolean isLeft) {
        if(node==null){
            return;
        }

        printTree(node.right,indent+(isLeft? "|  " : "  "),false);
        System.out.println(indent+(isLeft? "|__" : "|--")+node.data);
        printTree(node.left,indent+(isLeft?"  ":"|  "),true);
    }

    public static void main(String[] args){
        // TODO: Create sorted array
        int[] arr = {1,2,3,4,5,6};

        TreeNode node =  createMinBST(arr);

        printTree(node," ",false);

    }

}
