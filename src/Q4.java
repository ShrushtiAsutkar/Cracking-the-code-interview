
//Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.

import java.util.Stack;

public class Q4 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    static String STACK_1 = "Stack 1";
    static String STACK_2 = "Stack 2";

    //Initialized or else they would be null : Instance variable
    public Q4() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    //TODO : enqueue in stack 1
    void enqueue(int value) {
        stack1.push(value);
    }

    public Integer dequeue() {
        shift();

        //TODO: dequeue from stack 2 given its not empty
        return stack2.isEmpty() ? null : stack2.pop();
    }

    void shift() {
        //TODO : enqueue stack 2 with stack1 data if empty
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    void display(Stack<Integer> stack, String name) {
        System.out.print(name + ": [ ");
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i));
            if (i > 0) System.out.print(",");
        }
        System.out.print(" ]");
        System.out.println();
    }

    public static void main(String[] args) {
        Q4 q = new Q4();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display(q.stack1, STACK_1);
        System.out.println("Deleted Value " + q.dequeue());
        q.display(q.stack2, STACK_2);
    }
}

