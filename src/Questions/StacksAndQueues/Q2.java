package Questions.StacksAndQueues;
import java.util.Stack;

class MinStack {
    Stack<Integer> minStack;
    Stack<Integer> mainStack;

    public MinStack(){
        minStack = new Stack<>();
        mainStack = new Stack<>();
    }

    void push(int x){
      mainStack.push(x);

      if(minStack.isEmpty() || x < minStack.peek()){
          minStack.push(x);
      }
    }

    void pop(){
       int popped = mainStack.pop();

        if(popped == minStack.peek()){
            minStack.pop();
        }
    }

    int getMin(){
        if (minStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return minStack.peek();
    }
}
public class Q2 {

    public static void main (String[] args){
        MinStack stack = new MinStack();
        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.push(2);

        System.out.println("Current min: " + stack.getMin()); // 2
        stack.pop(); // pops 2
        System.out.println("Current min: " + stack.getMin());

    }
}
