package Questions.LinkedList;

class NodeQ7{
    NodeQ7 next;
    int data;

    public NodeQ7(int Data){
        this.data = Data;
        this.next = null;
    }

}

class Result{
    NodeQ7 tail;
    int length;

    public Result(NodeQ7 tail,int length){
        this.tail = tail;
        this.length = length;

    }
}
public class Q7 {
     NodeQ7 head ;
     void insert(int Data){

         NodeQ7 newNode = new NodeQ7(Data);

         if(head==null){
             head = newNode;
             return;
         }

         NodeQ7 temp = head;
         while(temp.next!=null){
             temp = temp.next;
         }
         temp.next = newNode;
     }

     void display(){
         NodeQ7 temp = head;

         while(temp!=null){
             System.out.print(temp.data + " ->");
             temp = temp.next;
         }
         System.out.println("null");
     }

      Result getLengthAndTail(NodeQ7 head){
         int length = 0;
         while(head!=null){
             length++;
             head = head.next;
         }
         return new Result(head,length);
     }

     NodeQ7 getAdvancedHead(NodeQ7 head,int difference){
         NodeQ7 current = head ;

         while(current!=null && difference > 0  ){
             current = current.next;
             difference--;
         }
         return current;
     }

     NodeQ7 findIntersection(NodeQ7 headA, NodeQ7 headB){
          Result result1 = getLengthAndTail(headA);
          Result result2 = getLengthAndTail(headB);

          //check if intersected
         if(result1.tail!=result2.tail){
             return null;
         }

         //intercepted node : shorter or longer
         NodeQ7 shorter = result1.length < result2.length ? headA : headB;
         NodeQ7 longer = result1.length > result2.length ? headA : headB;

         longer = getAdvancedHead(longer,Math.abs(result1.length- result2.length));

         while(shorter!=longer){
             shorter = shorter.next;
             longer = longer.next;

         }
         return longer;


     }
     public static void main(String[] args){
         Q7 listA = new Q7();

         listA.insert(1);
         listA.insert(2);
         listA.insert(3);
         listA.display();

         Q7 listB = new Q7();

         listB.insert(4);
         listB.insert(5);
         listB.display();

         NodeQ7 intersection = new NodeQ7(100);
         intersection.next = new NodeQ7(200);

         NodeQ7 tempA = listA.head;
         while(tempA.next!=null) {tempA = tempA.next;}
         tempA.next = intersection;

         NodeQ7 tempB = listB.head;
         while(tempB.next!=null) {tempB = tempB.next;}
         tempB.next = intersection;

         listA.display();
         listB.display();


         NodeQ7 intersectedNode = listA.findIntersection(listA.head,listB.head);
         if(intersectedNode!=null){
             System.out.println("Intersected node "+intersectedNode.data);
         }else{
             System.out.println("No intersection");
         }
     }
}
