package org.example;

import java.util.*;

public class MyArrayList <E> implements MyList<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elements;

    private int size;

    public MyArrayList(int initCapacity){
        if (initCapacity <= 0){
            throw new IllegalArgumentException();
        }
        elements = new Object[initCapacity];
    }
    public MyArrayList(){
        this(DEFAULT_CAPACITY);
    }


    public void add(Object element) {
        resizeIfNeeded();
        elements[size] = element;
        size++;
    }

    private void resizeIfNeeded(){
        if(elements.length == size){
            Object[] newArray = new Object[size * 2];
            System.arraycopy(elements, 0, newArray, 0 , size);
            elements = newArray;
        }
    }

    @Override
    public void remove(int index) {
        Objects.checkIndex(index,size);
        System.arraycopy(elements,index+1, elements,index,size-index-1);
        size--;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index,size);
        return (E) elements[index];
    }



}
