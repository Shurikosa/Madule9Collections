package org.example;

public interface MyList<E> {

    void add(E item);

    void clear();

    void remove(int index);

    int size();

    public E get(int index);
}
