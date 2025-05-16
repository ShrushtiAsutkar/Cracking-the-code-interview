package ConceptPractice;

class Node{
    int data; //stores value
    Node next; //stores pointer

    public Node(int Data){
        this.data = Data;
        this.next = null;
    }
}

 class LinkedList {
    Node head;

    //insert
    void  insertData(int Data){
        Node newNode = new Node(Data);  //create new node with data

        // check if head is empty
        if(head==null){
         head = newNode;
         return;
        }

        //if head is not empty check for next null node
        Node temp = head;  //temp points where head is at
        while(temp.next!=null){
            temp = temp.next;  //assign temp to next pointer
        }
        temp.next = newNode; //attach new node to last node

        System.out.println("insert");
        display();
    }

    void deleteData(int Key){

        //present at head
      if(head.data == Key){
          head = head.next;
      }

      //present in between    1--2--3

        Node temp = head ;
        Node prev = null;

        if(temp.data!=Key){
            prev = temp;
            temp = temp.next;
        }

        if (temp==null) return; //no data found to delete
        prev.next = temp.next; //skip the key
        System.out.println("delete key");
        display();
    }

    void deleteLast(){
        Node temp = head ;
        Node prev = null;
        while(temp.next != null){
            prev = temp;
            temp = temp.next;
        }

        prev.next = null;
        System.out.println("delete last");
        display();
    }


    void display(){
        Node temp = head ;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args){
        LinkedList ls = new LinkedList();
        ls.insertData(1);
        ls.insertData(2);
        ls.insertData(3);
        ls.insertData(4);

        ls.deleteData(2);
        ls.deleteLast();
    }


}

