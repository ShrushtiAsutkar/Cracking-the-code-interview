package ConceptPractice;

class Queue{
    int data;
    Queue next;

    public Queue(int Data){
        this.data = Data;
        this.next = null;
    }
}
public class QueueLinkList {
    Queue front;
    Queue rear;

    void enqueue(int Data){
        Queue newNode = new Queue(Data);
        if(rear == null){
            front = rear = newNode;
            return;
        }

        rear.next = newNode; //"take the current rear node (which is 20), and set its next pointer to the new node 30"
        rear = newNode;
    }

    int dequeue(){
     if(isEmpty()){
         System.out.println("nothing to delete");
         return -1;
     }
        int deleted = front.data;
      front = front.next; //move front ahead 
     return deleted;
    }
    boolean isEmpty(){
        return (rear==null) ;
    }

    void display(){
        Queue temp = front;
        System.out.print("front ->");
        while(temp!=null){//cant use rear becoz its last node
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println("<- rear");
    }
    public static void main (String[] args){
        QueueLinkList q = new QueueLinkList();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();
        System.out.println("deleted"+q.dequeue());

    }

}
