/*Sum Lists: You have two numbers represented by a linked list, where each node contains a single
digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
function that adds the two numbers and returns the sum as a linked list.
EXAMPLE
Input: (7-> 1 -> 6) + (5 -> 9 -> 2).Thatis,617 + 295.
Output: 2 -> 1 -> 9. That is, 912.
FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem.
EXAMPLE
lnput:(6 -> 1 -> 7) + (2 -> 9 -> 5).Thatis,617 + 295.
Output: 9 -> 1 -> 2. That is, 912. */

package Questions.LinkedList;

class NodeQ6{
    NodeQ6_2 next ;
    int data;

    public NodeQ6(int Data){
        this.data = Data;
        this.next = null;
    }
}
public class Q6 {
    NodeQ6_2 head;

    public static  Q6 addList(Q6 list1, Q6 list2) {
        NodeQ6_2 l1 = list1.head;
        NodeQ6_2 l2 = list2.head;
        int carry = 0;
        Q6 result = new Q6();
        NodeQ6_2 dummy = new NodeQ6_2(0); //store head
        NodeQ6_2 current = dummy;

        while (l1 != null || l2 != null) {

            int sum = carry;

            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            carry = sum / 10;
            current.next = new NodeQ6_2(sum % 10);
            current = current.next;

            if (carry > 0) { //if digit are 0 and carry are 1 we create new node
                current.next = new NodeQ6_2(carry);
            }
        }


        result.head = dummy.next;

        return result;
    }

    void insert1(int Data ){
        NodeQ6_2 newNode = new NodeQ6_2(Data);

        if(head==null){
            head = newNode;
            return;
        }

        NodeQ6_2 temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void insert2(int Data ){
        NodeQ6_2 newNode = new NodeQ6_2(Data);
        if(head==null){
            head = newNode;
            return;
        }

        NodeQ6_2 temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void display(){
        NodeQ6_2 temp = head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args){
        Q6 list1 = new Q6();
        Q6 list2 = new Q6();

        list1.insert1(7);
        list1.insert1(1);
        list1.insert1(6);
        System.out.print("list 1: ");
        list1.display();

        list2.insert2(5);
        list2.insert2(9);
        list2.insert2(2);
        System.out.print("list 2: ");
        list2.display();

        Q6 sumList = addList(list1,list2);
        System.out.print("sum: ");
        sumList.display();
    }
}
