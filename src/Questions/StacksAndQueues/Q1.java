package Questions.StacksAndQueues;
import java.util.Arrays;
public class Q1 {
    private int[] bigArray;
    final int numOfStacks = 3;
    private int[] capacityOfEachStack;
    final int stackSize = 5;
 static int STACK_ONE = 0;
 static int STACK_TWO = 1;
 static int STACK_THREE = 2;
    void push(int stackNumber,int value) {

        if(stackNumber < 0 || stackNumber > numOfStacks){
            System.out.println("Invalid stack number");
            return;
        }
        if (isFull(stackNumber)){
            System.out.println("Stack full");
            return;
        }
        int index = stackNumber * stackSize + capacityOfEachStack[stackNumber];

        bigArray[index] = value;
        capacityOfEachStack[stackNumber]++;
    }

    int pop(int stackNumber){
        if(isEmpty(stackNumber)){
         return -1;
        }
//    int top = capacityOfEachStack[stackNumber]; //this is just how many value arre present not index
        int top = (stackNumber * stackSize) +(capacityOfEachStack[stackNumber]-1);
    int popped = bigArray[top];
    bigArray[top]=0;
    capacityOfEachStack[stackNumber]--;
    return popped;
    }

    void display(int stackNumber){
        if(isEmpty(stackNumber)){
            System.out.println("Nothing to show");
            return;
        }
        int start = stackNumber * stackSize;
        int end = start + capacityOfEachStack[stackNumber];
        System.out.print("Stack"+stackNumber+":");
        for(int i = start; i <end;i++){
         System.out.print(bigArray[i]+" ");
        }
        System.out.println();
    }

    boolean isEmpty(int stackNumber){
     return capacityOfEachStack[stackNumber]==0;
    }

    boolean isFull(int stackNumber){
        return  capacityOfEachStack[stackNumber] == stackSize;
    }

    void formBigArray(){
         bigArray = new int[stackSize * numOfStacks]; //15
         capacityOfEachStack = new int[numOfStacks]; //[0,0,0]
    }
    public static void main (String[] args){
        Q1 q = new Q1();
        q.formBigArray();

        q.push(STACK_TWO,1);
        q.push(STACK_TWO,2);
        q.push(STACK_TWO,3);
        q.push(STACK_TWO,4);
        q.push(STACK_TWO,5);
        q.push(STACK_TWO,6);
        q.push(STACK_TWO,7);
        q.push(STACK_ONE,10);
        q.display(STACK_TWO);
        q.display(STACK_ONE);

        q.pop(STACK_ONE);

        q.display(STACK_ONE);
        q.display(STACK_THREE);

    }

}
