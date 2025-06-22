package Questions.StacksAndQueues;

import java.util.LinkedList;

/** 3.6 Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first
out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
        that type). They cannot select which specific animal they would like. Create the data structures to
maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
and dequeueCat. You may use the built-in Linked list data structure.**/

abstract class Animal{
    protected String name ;
    int order ;
    //not adding order because it is not user input
    public Animal(String n ){ //must be overriden in subclass
        this.name = n;
    }

    public void setOrder(int o){
        this.order = o ;
    }

    public String getName(){
        return name;
    }

    public int getOrder(){
        return order;
    }

    public boolean isOlderThan(Animal a){
    return this.order < a.getOrder(); //this.order refers to the order value of the current object —
        // the animal you are calling the method on
    }
}

 class Dog extends Animal{
    public Dog(String s){
        super(s);
    }
}

class Cat extends Animal{
    public Cat(String s){
        super(s);
    }
}
public class Q6 {
    String DOG = "dog";
    String CAT = "cat";

    LinkedList<Dog> dogList = new LinkedList<>();
    LinkedList<Cat> catList = new LinkedList<>();
    private int order =0 ;

    //TODO: enqueue dog and  cat
    void enqueue(Animal animal){
        animal.setOrder(order++);

        //check animal is of what object
        if(animal instanceof Dog){
            dogList.add((Dog) animal);
        }else if (animal instanceof Cat){
            catList.addLast((Cat) animal);
        }
    }


    //TODO: Dequeue any animal :oldest one
     Animal dequeueAny(){
        if(dogList.isEmpty()){
            return dequeueCat();
        }

        if(catList.isEmpty()){
            return dequeueDog();
        }

        Dog oldestDog = dogList.peek();
        Cat oldestCat = catList.peek();

        if(oldestDog.isOlderThan(oldestCat)){
            return dequeueDog();
        }else{
            return dequeueCat();
        }
     }

    //TODO Dequeue Dog
     Dog dequeueDog(){
       return dogList.poll();
    }

    //TODO : dequeu cat
    Cat dequeueCat() {
       return catList.poll();
    }

   void display(){
        System.out.println("Dogs: ");
            for (Dog d : dogList)   System.out.println("Name: " + d.getName()+ " | " + " Order: " + d.getOrder());
       System.out.println();
       System.out.println("Cats ");
          for (Cat c : catList)   System.out.println("Name: " + c.getName() + " | " + " Order: " + c.getOrder());
       System.out.println();
   }
    public static void main (String[] args){
        Q6 q = new Q6();

        q.enqueue(new Dog("Rex"));
        q.enqueue(new Cat("Milo"));
        q.enqueue(new Cat("Momo"));
        q.enqueue(new Dog("Roger"));

        q.display();
        System.out.println("Dequeue Dog: "+ q.dequeueDog().getName());
        System.out.println("Dequeue Cat: "+ q.dequeueCat().getName());
        System.out.println("Dequeue Any: "+ q.dequeueAny().getName());
        q.display();

       q.dequeueAny();
    }

}
