/*List 1:  1 → 2 → 3 → 4 (represents 1234)
List 2:  5 → 6 → 7 (represents 567)

add 0 before 5
List 3:  1 → 8 → 0 → 1 (represents 1801)

*/
package Questions.LinkedList;




class NodeQ6_2 {
    NodeQ6_2 next ;
    int data;

    public NodeQ6_2(int Data){
        this.data = Data ;
        this.next = null ;
    }
}
class partialsSum{
    int carry;
    NodeQ6_2 sumNode ;

         public partialsSum(){
             this.sumNode = null;
             this.carry = 0;
    }
}
public class Q6_2 {
     NodeQ6_2 head;

     void insert(int Data){
        NodeQ6_2 newnode = new NodeQ6_2(Data);
        if(head == null){
            head = newnode;
            return;
        }

        NodeQ6_2 temp = head ;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newnode;
    }

     void display(){
        NodeQ6_2 temp = head ;
        while(temp!=null){

            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

     void padding(int difference){
//        NodeQ6_2 temp = head;
        for(int i =0;i <difference;i++){
            NodeQ6_2 newNode = new NodeQ6_2(0);
            newNode.next = head ;
            head = newNode;
        }
         System.out.println("After padding");display();

    }

     int getLength(){
        int length = 0 ;

        NodeQ6_2 temp = head ;
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        return length;

    }

     static partialsSum addList(NodeQ6_2 l1 , NodeQ6_2 l2){
         if(l1 == null && l2 ==null){
             return new partialsSum();
         }

         partialsSum partial = addList(l1.next, l2.next);


         int sum = l1.data + l2.data + partial.carry;

         int carry = sum / 10;

         int digit = sum % 10;

         //create new nodes
         NodeQ6_2 newNode = new NodeQ6_2(digit);
         newNode.next = partial.sumNode;  //assigning sum variable of partial class(Link it to previous sum list) to result

         partialsSum result = new partialsSum();
         result.carry = carry;
         result.sumNode = newNode;

         return result;

    }

    public static void main (String[] args){
        Q6_2 q1 = new Q6_2();
        Q6_2 q2 = new Q6_2();

        q1.insert(1);
        q1.insert(2);
        q1.insert(3);
        q1.insert(4);

        q2.insert(5);
        q2.insert(6);
        q2.insert(7);

        q1.display();
        q2.display();

        int l1 =q1.getLength();
        int l2 = q2.getLength();
        if(l1 > l2 ){
            q2.padding(l1-l2);
        }else if(l2 > l1){
            q1.padding(l2-l1);
        }

        // Perform addition
        partialsSum sumResult = addList(q1.head, q2.head);

        if (sumResult.carry > 0) {
            NodeQ6_2 newNode = new NodeQ6_2(sumResult.carry);
            newNode.next = sumResult.sumNode;//(head)
            sumResult.sumNode = newNode;
        }

        System.out.println("result");
        Q6_2 resultList = new Q6_2();
        resultList.head = sumResult.sumNode;
        resultList.display();
    }

}
