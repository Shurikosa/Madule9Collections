package org.example;

public class Main {
    public static void main(String[] args) {

        MyArrayList <String>list = new MyArrayList<>();
        list.add("afas");
        System.out.println(list.get(0));

        MyLinkedList <String> linkedList = new MyLinkedList<>();
        linkedList.add("qwe");
        linkedList.add("gds");
        linkedList.add("bds");
        linkedList.add("tyy");
        linkedList.add("bsz");
        linkedList.remove(2);
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.get(3));

    }
}