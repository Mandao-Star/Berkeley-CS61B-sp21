package deque;

import java.util.Iterator;

public class ArrayDeque<T>  implements Iterable<T>{
    private int size;
    private static final int CAPACITY = 8;
    private int head;
    private int tail;
    private T[] items;

    public ArrayDeque(){
        size = 0;
        head = 0;
        tail = 1;
        items = (T[]) new Object[CAPACITY];
    }

    public int minusOne(int index){
        return (index - 1 + items.length) % items.length;
    }

    public int plusOne(int index){
        return  (index + 1) % items.length;
    }

    public void addFirst(T item){
        if(size() == items.length){
            resize(2 * size);
        }
        items[head] = item;
        head = minusOne(head);
        size++;
    }

    public void addLast(T item){
        if(size() == items.length){
            resize(2 * size);
        }
        items[tail] = item;
        tail = plusOne(tail);
        size++;
    }

    public T get(int index){
        if(index >= size() || index < 0 || isEmpty()){
            return null;
        }


        int tmp = head;
        for(int i = 0; i <= index; i++){
            tmp = plusOne(tmp);
        }
        return items[tmp];
    }

    public T removeFirst(){
        if(isEmpty()){
            return null;
        }

        head = plusOne(head);
        T tmp = items[head];

        if(size() < items.length / 4 && items.length >= 16){
            resize(items.length / 2);
        }
        size--;
        return tmp;
    }

    public T removeLast(){
        if(isEmpty()){
            return null;
        }

        tail = minusOne(tail);
        T tmp = items[tail];

        if(size() < items.length / 4 && items.length >= 16){
            resize(items.length / 2);
        }

        size--;
        return  tmp;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void resize(int capcity){
        T[] newItems = (T[]) new Object[capcity];
        for(int i = 0, ptr = plusOne(head); i < size(); i++, ptr = plusOne(ptr)){
            newItems[i] = items[ptr];
        }

        head = capcity - 1;
        tail = size;
        items = newItems;
    }

    public void printDeque(){
        for(int i = 0; i < size(); i++){
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object other){
        if(other == null)
            return false;
        if(!(other instanceof ArrayDeque))
            return false;

        ArrayDeque<?> o = (ArrayDeque<?>) other;
        if(o.size() != size)
            return false;

        for(int i = 0; i < size; i++){
            if(o.get(i) != get(i))
                return false;
        }
        return true;
    }



    private class ArrayDequeIterator implements Iterator<T>{
        private int pos;

        public ArrayDequeIterator(){
            pos = 0;
        }

        @Override
        public boolean hasNext(){
            return pos < size;
        }

        @Override
        public T next(){
            if(!hasNext()){
                return null;
            }

            T tmp = items[pos];
            pos++;
            return tmp;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }
}
