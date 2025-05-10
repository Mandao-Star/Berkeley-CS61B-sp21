package deque;

public class ArrayDeque<T> {
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
        int tmp = head;
        for(int i = 0; i <= index; i++){
            tmp = plusOne(tmp);
        }
        return items[tmp];
    }

    public T removeFirst(){
        head = plusOne(head);
        T tmp = items[head];

        if(size() < items.length / 4 && items.length >= 16){
            resize(items.length / 2);
        }

        return tmp;
    }

    public T removeLast(){
        tail = minusOne(tail);
        T tmp = items[tail];

        if(size() < items.length / 4 && items.length >= 16){
            resize(items.length / 2);
        }

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
}
