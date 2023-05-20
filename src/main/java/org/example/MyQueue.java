package org.example;



public class MyQueue<E> {

    private int size;

    private Node<E> tail;
    private Node<E> head;

    public void add(E item) {
        Node<E> last = tail;
        final Node<E> newNode = new Node<>(last,item,null);
        if(last == null){
            head = tail = newNode;
        }else{
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    private Node <E> getNodeByIndex(int index){
        if (index == 0){
            return head;
        }
        Node<E> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }
    public int size() {
        return size;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public E peek(){
        return head.getItem();
    }

    public E poll(){
        E toReturn = head.getItem();
        head = head.getNext();
        size--;
        return toReturn;

    }
}
