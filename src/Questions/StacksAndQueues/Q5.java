package Questions.StacksAndQueues;

//Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use
//        an additional temporary stack, but you may not copy the elements into any other data structure
//        (such as an array). The stack supports the following operations: push, pop, peek, and is Empty

//THINKING - 1 HR
//CODING 46 MIN
import java.util.Stack;

public class Q5
{
    //TODO : introduce two stacks

    Stack<Integer> mainStack;
    Stack<Integer> tempStack;
    String TEMP_STACK = "Temp Stack";
    String MAIN_STACK = "Main Stack";
    public Q5(){
        mainStack = new Stack<>();
        tempStack = new Stack<>();
    }

    //TODO : enqueue mainStack
    void push(int data){
        mainStack.push(data);


    }

    //TODO : sorting logic

    void sortStack(){
        while(!mainStack.isEmpty()) {
            int tmp = mainStack.pop();

            while (!tempStack.isEmpty() && tempStack.peek() > tmp) {
                mainStack.push(tempStack.pop());
            }
            tempStack.push(tmp);

        }

        reverse();
    }
    //TODO: reversing logic

    Stack<Integer> reverse(){
        while(!tempStack.isEmpty()){
         mainStack.push(tempStack.pop());}
        return mainStack;
    }

    //TODO : pop mainStack
     Integer pop(){
        return mainStack.isEmpty() ? null : mainStack.pop();
     }

    //TODO : peek mainStack
    void peek(){
        System.out.print(mainStack.peek());
    }

    //TODO : Display stack
    void display(Stack<Integer> stack,String name){
        System.out.print(name+"[ ");
        for (int i = stack.size()-1 ; i >= 0 ; i--){
            System.out.print(stack.get(i));
            if (i>0){
                System.out.print(",");
            }
        }
        System.out.println(" ]");
    }

    public static void main (String[] args){
        Q5 q = new Q5();

        q.push(2);
        q.push(4);
        q.push(1);
        q.push(5);
        q.push(3);

        System.out.println("Before sorting:");
        q.display(q.mainStack, q.MAIN_STACK);

        q.sortStack();

        System.out.println("After sorting:");
        q.display(q.mainStack, q.MAIN_STACK);

        q.peek();
    }
}
