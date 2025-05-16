/*Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
beginning of the loop.
DEFINITION
Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
as to make a loop in the linked list.
EXAMPLE
Input:A -> B -> C -> D -> E -> C [the same C as earlier]
Output:C */

package Questions.LinkedList;

class NodeQ8 {
    char data;
    NodeQ8 next;

    public NodeQ8(char Data){
        this.data = Data;
        this.next = null;
    }
}
public class Q8 {
    NodeQ8 head;

    void insert(char Data){

        NodeQ8 newNode = new NodeQ8(Data);
        if(head==null){
            head= newNode;
            return;
        }
        NodeQ8 temp = head;
        while(temp.next!=null){
            temp=temp.next;//move

        }
        temp.next = newNode;//assign



    }

    void display(){
        NodeQ8 temp = head ;
        int count = 0;
        while(temp!=null && count < 10){
            System.out.print(temp.data+"->");
            temp = temp.next;
            count++;
        }
        System.out.print("...");
    }

    NodeQ8 findLoopStart(){
        //TODO:check if cycle possible?
        if(head==null || head.next ==null){ //empty list or single node list
            return null;
        }

        NodeQ8 slow = head;
        NodeQ8 fast = head ;

        //TODO:getting the meeting point

        while(fast!=null && fast.next!=null){
        slow = slow.next ;
        fast = fast.next.next ;
        if(slow==fast){
            break;
        }}

        //TODO:check if cycle possible?
        if(fast==null || fast.next == null){
            return null;
        }
        //TODO:get the starting point
        slow = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static  void main(String[] args){
        Q8 q = new Q8();
        q.insert('A');
        q.insert('B');
        q.insert('C');
        q.insert('D');
        q.insert('E');

        NodeQ8 current = q.head;
        NodeQ8 loopNode = null;
        while(current!=null){
            if(current.data == 'C'){
                loopNode = current;
            }
            if(current.data == 'E'){
                current.next = loopNode;
                break;//if not added curent will never be = null
            }
            current = current.next;//will always go to c
        }
        q.display();
        NodeQ8 result = q.findLoopStart();

        if(result!=null){
            System.out.println("Starting node : "+result.data);
        }else {
            System.out.println("no cycle");
        }

    }

}
