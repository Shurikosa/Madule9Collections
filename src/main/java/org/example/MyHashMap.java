package org.example;


import java.util.Objects;

public class MyHashMap<K,V> {

   private static final int DEFAULT_CAPACITY = 16;
   private static final double DEFAULT_LOAD_FACTOR = 0.75;
   private Node<K,V>[] table;
   private int size;

   public MyHashMap(){
       table = new Node[DEFAULT_CAPACITY];
   }

   private int hash(Object key){
       int hash = 31;
       hash = hash * 17 + key.hashCode();
       return hash % table.length;
   }

   public void put(K key, V value){

       Node<K,V> newNode = new Node<>(hash(key),key,value,null);
           resizeIfNeeded();
       if (table[newNode.hash] == null){
           table[newNode.hash] = newNode;
       }else{
            Node<K,V> currentNode = table[newNode.hash];
            while(currentNode != null){
                if(Objects.equals(currentNode.key,key)){
                    return;
                }
                if(currentNode.next == null){
                    break;
                }
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
       }
       size++;
   }

    private void resizeIfNeeded() {
        if (size > table.length * DEFAULT_LOAD_FACTOR) {
            Node<K,V>[] newTable =new Node[table.length * 2];
            System.arraycopy(table, 0, newTable, 0, table.length);
            table = newTable;
        }
    }

    public V getValue(K key) {
        int index = hash(key);
        Node<K, V> currentNode = table[index];
        while (currentNode != null) {
            if (Objects.equals(currentNode.key, key)) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }
        return null;
    }
    public boolean remove(K key){
        int index = hash(key);
        if(table[index] == null){
            return false;
        }
        if (table[index].next == null){
            table[index] = null;
            size--;
            return true;
        }
        Node<K, V> currentNode = table[index];
        while (currentNode != null) {
            if (Objects.equals(currentNode.key, key)) {
                table[index] = null;
                return true;
            }
            currentNode = currentNode.next;
        }
        size--;
        return false;
    }

    public void clear(){
       Node<K,V>[] newTable = new Node[DEFAULT_CAPACITY];
       table = newTable;
       size = 0;
    }
    public int size() {
        return size;
    }



    static class Node<K,V>{
       final int hash;
       final K key;
       V value;
       Node<K,V> next;

        Node(int hash, K key, V value,Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }


    }
}
