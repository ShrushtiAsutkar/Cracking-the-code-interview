package Questions.TreesAndGraphs;
/*List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
at each depth (e.g., if you have a tree with depth D, you'll have D linked lists). */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNodeQ3{
    int data ;
    TreeNodeQ3 left;
    TreeNodeQ3 right;

    public TreeNodeQ3(int value){
        this.data = value;
        left = null ;
        right = null;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
public class Q3 {

    static List<LinkedList<TreeNodeQ3>> checkDepth(TreeNodeQ3 node){
        List<LinkedList<TreeNodeQ3>> result = new ArrayList<>();
        Queue<TreeNodeQ3> queue = new LinkedList<>();

        if(node==null) return new ArrayList<>();

        queue.add(node);

        while(!queue.isEmpty()){
           int numOfNodeInLevel = queue.size();
           //create a new list for every level
           LinkedList<TreeNodeQ3> linkedList = new LinkedList<>();


           for ( int i = 0 ; i < numOfNodeInLevel;i++){
               //add every element of the level to linkedlist
               TreeNodeQ3 current = queue.poll();
               linkedList.add(current);

               if(current.left!=null) queue.add(current.left);
               if(current.right!=null) queue.add(current.right);


           }
            result.add(linkedList);
        }


        return result;
    }

    public static void main (String[] args){
        TreeNodeQ3 rootnode = new TreeNodeQ3(1);
        rootnode.left = new TreeNodeQ3(2);
        rootnode.right = new TreeNodeQ3(3);
        rootnode.left.left = new TreeNodeQ3(4);
        rootnode.left.right = new TreeNodeQ3(5);
        rootnode.right.left = new TreeNodeQ3(6);

        List<LinkedList<TreeNodeQ3>> listOfLinkedLists =  checkDepth(rootnode);

        int level = 0 ;
        for ( List<TreeNodeQ3> list : listOfLinkedLists){
            System.out.println("Level: "+level);
            for (TreeNodeQ3 val : list){
                System.out.print(val + " -> ");
            }
            System.out.println("null");
            level++;
        }


    }

}
