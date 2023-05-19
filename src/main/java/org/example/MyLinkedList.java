package org.example;

public class MyLinkedList <E> implements MyList<E>{

    private int size;

    private Node<E> tail;
    private Node<E> head;

    public MyLinkedList(){
    }

    @Override
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

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public void remove(int index) {
        Node<E> prev = (getNodeByIndex(index - 1));
        prev.setNext(prev.getNext().getNext());
        prev.setPrev(prev.getPrev());
        size--;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {

        if (index == 0){
            return head.getItem();
        }
        Node<E> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getItem();
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

}
