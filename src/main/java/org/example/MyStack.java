package org.example;

public class MyStack <E> {

    private int size;

    private Node<E> tail;
    private Node<E> head;

    public void push(E item) {
        Node<E> last = head;
        final Node<E> firsToAddNode = new Node<>(last, item, null);
        final Node<E> newNode = new Node<>(null, item, last);
        if (last == null) {
            head = tail = firsToAddNode;
        } else {
            head.setPrev(newNode);
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }

    public void remove(int index) {
        Node<E> prev = (getNodeByIndex(index - 1));
        prev.setNext(prev.getNext().getNext());
        prev.setPrev(prev.getPrev());
        size--;

    }

    private Node<E> getNodeByIndex(int index) {
        if (index == 0) {
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

    public E pop(){
        E toReturn = head.getItem();
        head = head.getNext();
        size--;
        return toReturn;
    }
}
