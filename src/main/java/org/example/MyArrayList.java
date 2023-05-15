package org.example;

import java.util.*;

public class MyArrayList <E>  {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elements;

    private int size;

    ArrayList list = new ArrayList<>();

    public MyArrayList(int initCapacity){
        if (initCapacity <= 0){
            throw new IllegalArgumentException();
        }
        elements = new Object[initCapacity];
    }
    public MyArrayList(){
        this(DEFAULT_CAPACITY);
    }
    public void add( E element) {
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


    public void remove(int index) {
        Objects.checkIndex(index,size);
        System.arraycopy(elements,index+1, elements,index,size-index-1);
        size--;
    }
    public int size() {
        return size;
    }


    public void clear() {
        size = 0;
        elements = new Object[DEFAULT_CAPACITY];
    }


    public E get(int index) {
        Objects.checkIndex(index,size);
        return (E) elements[index];
    }



}
