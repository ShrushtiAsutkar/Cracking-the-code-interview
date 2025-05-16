/*Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list. */


package Questions.LinkedList;

class NodeQ2 {
    int data;
    NodeQ5 next;

    public NodeQ2(int Data){
        this.data = Data;
        this.next = null;
    }
}

public class Q2 {
    NodeQ5 head;

    int getKthLastElement(int k ){
        NodeQ5 fast = head ;
        NodeQ5 slow = head;

        for(int i = 0 ; i < k;i++){
            if(fast==null) return '\0';
            fast = fast.next;
        }

        while(fast!=null){ //keeping moving till end is reached
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;

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
        Q2 q = new Q2();
        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.insert(4);
        q.insert(5);
        q.insert(6);

        q.display();

        System.out.println(q.getKthLastElement(4));
    }
}
