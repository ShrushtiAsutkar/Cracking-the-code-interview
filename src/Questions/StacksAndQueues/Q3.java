/*Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
        Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
        threshold. Implement a data structure SetOfStacks that mimics this. SetO-fStacks should be
        composed of several stacks and should create a new stack once the previous one exceeds capacity.
        SetOfStacks. push() and SetOfStacks. pop() should behave identically to a single stack
        (that is, pop () should return the same values as it would if there were just a single stack).
        FOLLOW UP
        Implement a function popAt ( int index) which performs a pop operation on a specific sub-stack.*/


        package Questions.StacksAndQueues;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class Q3 {
    List<Stack<Integer>> setOFStack = new ArrayList<>();
   int capacity;

   public Q3(int capacity){
       if ( capacity < 1 ) throw new IllegalArgumentException("Enter atleast 1 item");
       this.capacity = capacity;
   }

   void push(int Data){
       Stack<Integer> last = getLastStack();
     //TODO CHECK IF LAST IS EMPTY
       if(last!=null && last.size() < capacity){
           // TODO :IF YES THEN PUSH
           last.push(Data);
       }else{
           //TODO: ELSE   CREATE NEW
        Stack<Integer> newStack = new Stack<>();
        newStack.push(Data);
        setOFStack.add(newStack);
       }

    }

    int pop(){
        Stack<Integer> last = getLastStack();
        if(last==null)throw  new EmptyStackException();

        int popped = last.pop();
        if(last.isEmpty()){
            setOFStack.remove(setOFStack.size()-1);
        }
        return popped;
    }

    int popAt(int stackIndex ){
       if(stackIndex < 0 || stackIndex > setOFStack.size()-1) throw new IllegalArgumentException("Invalid stack index");

       if(setOFStack.get(stackIndex).isEmpty())throw new EmptyStackException();

       int popped = setOFStack.get(stackIndex).pop();
       return popped;

    }
    Stack<Integer> getLastStack(){
       if (setOFStack.isEmpty()) return null;
       return (setOFStack.get(setOFStack.size()-1));

    }

    public static void main (String[] args){
       // Stack<Integer> stack = new Stack<>(); //single stack is maintained
         Q3 stack = new Q3(2); //creates new stack

        stack.push(1);
        stack.push(2);
        stack.push(30);//new stack
        stack.push(40);
        stack.push(500);//new stack


        System.out.println("Value deleted : "+stack.pop() + " from stack " + stack.setOFStack.size());



        System.out.println("Value deleted : " +  stack.popAt(1) + " from stack " + stack.setOFStack.size());

        //printing stack : big box having setofstack which knows the number of towers
        //+ setOFStack.get(i).size(); will give number of plates in tower
        for(int i = 0 ; i < stack.setOFStack.size();i++){
            System.out.println("Stack " + i + ": " + stack.setOFStack.get(i));

        }
    }
}
