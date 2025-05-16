/*R�mov� Dups! Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?*/

package Questions.LinkedList;

import java.util.HashSet;

class Node{
    char data;
    Node next;

    public Node(char Data ){
        this.data = Data;
        this.next = null;
    }

}

public class Q1 {
    Node head;


    void insert(char Data){
        Node newNode = new Node(Data);   //create new node

        if(head==null){
            head = newNode;  //check if list is empty :YES
            return;
        }

        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;

    }

    void display(){
        Node temp = head ;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    void removeDuplicateUsingHash(){

        //hashset : store unique values
        HashSet<Character> seen = new HashSet<>();

        Node temp = head ;
        Node prev = null ;
        while(temp!=null) {
            if (seen.contains(temp.data)) {
            prev.next = temp.next;   //skipping
        } else {
            seen.add(temp.data);
            prev = temp;
        }
            temp = temp.next;
    }
    }

    void removeDuplicateUsingPointer(){

        Node current = head ;

        while(current!= null){
            Node runner = current;

            while(runner.next!=null){
            if ( runner.next.data == current.data){
                runner.next = runner.next.next;
            }else{
                runner = runner.next;
            }
        }
            current = current.next;
        }
    }
    public static void main(String[] args){
        Q1 q = new Q1();
        q.insert('F');
        q.insert('O');
        q.insert('L');
        q.insert('L');
        q.insert('O');
        q.insert('W');
        q.display();

       // q.removeDuplicateUsingHash();
        //q.display();
        q.removeDuplicateUsingPointer();
        q.display();

    }

}
