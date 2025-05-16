package ConceptPractice;
//
//class Stack{
//    int data;
//    Stack next ;
//
//    public Stack(int Data){
//        this.data = Data;
//        this.next = null;
//    }
//
//}
//class StackLinkedList{
//    private Stack top ;
//
//    public StackLinkedList(){
//        this.top = null;
//    }
//
//    void insert(int Data){
//      Stack newNode = new Stack(Data);
//      newNode.next = top;  //link top and new node
//      top = newNode;  //update top to new node
//    }
//
//    int pop(){
//        if(isEmpty()){
//            System.out.println("Empty");
//            return -1;
//        }
//        int popedData = top.data;
//        top = top.next; //move pointer to next node
//        return popedData;
//    }
//
//    int peek(){
//        if(isEmpty()){
//            System.out.println("Empty");
//            return -1;
//        }
//       return top.data;
//    }
//
//    public boolean isEmpty(){
//        return top == null;
//    }
//
//    void display(){
//        if(isEmpty()){
//            System.out.println("Empty");
//            return;
//        }
//        Stack temp = top;
//        System.out.println("Stack");
//        while(temp!=null){
//            System.out.print(temp.data+" -> ");
//            temp = temp.next;
//        }
//        System.out.println("null");
//    }
//
//}
//public class StackLinkedListDemo {
//    public static void main(String[] args) {
//    StackLinkedList s = new StackLinkedList();
//
//    s.insert(10);
//    s.insert(20);
//    s.insert(30);
//    s.insert(40);
//
//    s.display();
//    System.out.println("peek data "+ s.peek());
//    System.out.println("poped data "+ s.pop());
//    System.out.println("peek data "+ s.peek());
//    }
//}

class Stack{
    int data ;
    Stack next;

    public Stack(int Data){
        this.data = Data;
        this.next = null;
    }
}
public class StackLinkedListDemo{
    Stack top;
    void push(int Data){
    Stack newNode = new Stack(Data);
    newNode.next =top;
    top = newNode;
    }
    int pop(){
        if(isEmpty()){
            return -1;
        }

        int popped = top.data;
        top = top.next;
        return popped;
    }
    int peek(){
        return top.data;
    }

    boolean isEmpty(){
        return top == null;
    }

    void display(){
        if(isEmpty()){
            System.out.println("empty");
            return;
        }
        Stack stack = top;
        while(stack!=null){
            System.out.print(stack.data+"->");
            stack = stack.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args){
        StackLinkedListDemo s = new StackLinkedListDemo();
        s.push(10);
        s.push(20);
        s.push(30);

        s.display();

        System.out.println("popped "+s.pop());
        System.out.println(s.peek());
    }
}
