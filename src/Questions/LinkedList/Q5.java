/* Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
before all nodes greater than or equal to x. If xis contained within the list, the values of x only need
to be after the elements less than x (see below). The partition element x can appear anywhere in the
"right partition"; it does not need to appear between the left and right partitions.
EXAMPLE
Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
*/

package Questions.LinkedList;

class NodeQ5 {
    int data;
    NodeQ5 next;

    public NodeQ5(int Data){
        this.data = Data;
        this.next = null;
    }
}
public class Q5 {
    NodeQ5 head;

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

    void rearrange(int Data){
        NodeQ5 current = head;
        NodeQ5 beforeStart = null ,beforeEnd = null;
        NodeQ5 afterStart = null ,afterEnd = null;

        if (head == null || head.next == null) return; //check if list is empty

        while(current !=null){   //🚂(Engine) → 🔴(3) → 🔵(5) → 🟢(8)  → null

            NodeQ5 next = current.next;  //save next train reference current = 🔴(3)  (The car you're holding)
                                                    //            next    = 🔵(5)  (The next car in line)

            current.next = null;   //detach from original list   🔴(3)   🔵(5) → 🟢(8)  → null

            if(current.data <= Data){
            //smaller value
                if(beforeStart==null){
                    beforeStart = current;
                    beforeEnd = beforeStart;
                }else{
                    beforeEnd.next = current; //attach current dabba
                    beforeEnd = current; //this is the last dabba
                }
            }
            else{
            //larger value
                if(afterStart==null){
                    afterStart = current;
                    afterEnd = afterStart;
                }
                else{
                    afterEnd.next = current;
                    afterEnd = current;
                }
            }
            current = next ;  //now u want to move the next car : current moves to 🔵(5).
        }
        //no smaller
        if (beforeStart ==null){
            head = afterStart;
            return;
        }
        //if no greater are present
        if (afterStart ==null){
           head = beforeStart;
           return;
        }
        beforeEnd.next = afterStart;
        head = beforeStart ; //update head
    }
    public static void main(String[] args){
        Q5 q = new Q5();
        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.insert(4);
        q.insert(6);
        q.insert(7);
        q.insert(8);

        q.display();
       q.rearrange(1);
        q.display();
    }
}
