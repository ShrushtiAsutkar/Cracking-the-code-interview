package Questions.LinkedList;


/*Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
that node.
EXAMPLE
lnput:the node c from the linked lista->b->c->d->e->f
Result: nothing is returned, but the new linked list looks like a->b->d->e->f */

class NodeQ3 {
    int data;
    NodeQ5 next;

    public NodeQ3(int Data){
        this.data = Data;
        this.next = null;
    }
}

public class Q3 {
    NodeQ5 head;

    NodeQ5 getNodePosition(int k ){
       NodeQ5 temp = head;
       int count =0;
        while(temp.next!=null){
            if(count==k) return temp;
            count++;
            temp = temp.next;
        }
    return  null;
    }


   void  deleteNode(NodeQ5 nodeToDelete){
        nodeToDelete.data = nodeToDelete.next.data;
        nodeToDelete.next = nodeToDelete.next.next;
   }


    void insert(int Data){
        NodeQ5 newNode = new NodeQ5(Data);

        if(head==null){head = newNode;return;}

        NodeQ5 temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;


    }
    void display(){
        NodeQ5 temp = head;

        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args){
        Q3 q = new Q3();
        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.insert(4);
        q.insert(5);
        q.insert(6);

        q.display();

        NodeQ5 nodeToDelete =  q.getNodePosition(3);

        if (nodeToDelete !=null && nodeToDelete.next!=null){
            q.deleteNode(nodeToDelete);
        }

        q.display();
    }
}
