package deque;

import jh61b.junit.In;

import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T> {
    private static class Node<T>{
        private T item;
        private Node<T> prev;
        private Node<T> next;

        private Node(T item, Node<T> prev, Node<T> next){
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private final Node<T> sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new Node<>(null, null, null);
        size = 0;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void addFirst(T item){
        Node<T> newNode = new Node<>(item, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    public void addLast(T item){
        Node<T> newNode = new Node<>(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        T tmp = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return tmp;
    }

    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        T tmp = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return tmp;
    }

    public void printDeque(){
        Node<T> ptr = sentinel.next;
        while(ptr != sentinel){
            System.out.print(ptr.item + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    public  T get(int index){
        if(index >= size() || index < 0 || isEmpty())
            return null;

        Node<T> ptr = sentinel.next;

        while(index != 0){
            ptr = ptr.next;
            index--;
        }

        return ptr.item;
    }

    public T getRecursive(int index){
        if(index >= size() || index < 0 || isEmpty()){
            return null;
        }

        Node<T> ptr = sentinel.next;
        return getRecursiveHelper(ptr, index);
    }

    private  T getRecursiveHelper(Node<T> ptr, int index){
        if(index == 0){
            return ptr.item;
        }

        return getRecursiveHelper(ptr.next, index - 1);
    }

    private class LinkedListDequeIterator implements Iterator<T> {
        private int pos;

        public LinkedListDequeIterator(){
            pos = 0;
        }

        @Override
        public boolean hasNext(){
            return pos < size;
        }

        @Override
        public T next(){
            if(!hasNext())
                return null;

            T tmp = get(pos);
            pos++;
            return tmp;
        }
    }


    @Override
    public Iterator<T> iterator(){
        return new LinkedListDequeIterator();
    }

    @Override
    public boolean equals(Object other){
        if(other == null || !(other instanceof LinkedListDeque)){
            return false;
        }

        LinkedListDeque<?> o =( LinkedListDeque<?> )other;

        if(o.size() != size)
            return false;

        for(int i = 0; i < size; i++){
            if(o.get(i) != get(i)){
                return false;
            }
        }
        return true;
    }

}
