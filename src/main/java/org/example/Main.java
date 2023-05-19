package org.example;

public class Main {
    public static void main(String[] args) {

       MyQueue myQueue = new MyQueue();

       myQueue.add("gsafa");
       myQueue.add("zxnz");
       myQueue.add("mbnlig");
       myQueue.add("gGvv");
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());


    }
}