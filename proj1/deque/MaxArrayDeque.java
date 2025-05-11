package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> implements Deque<T> {
    private ArrayDeque<T> de;
    private Comparator<T> defaultComparator;

    public MaxArrayDeque(Comparator<T> c){
        de = new ArrayDeque<T>();
        defaultComparator = c;
    }

    public T max(){
        return max(defaultComparator);
    }

    public T max(Comparator<T> c){
        if(de == null){
            return null;
        }

        T maxValue = get(0);
        for(int i = 0; i < size(); i++){
            if(c.compare(get(i), maxValue ) > 0){
                maxValue = get(i);
            }
        }
        return maxValue;
    }

    public int size(){
        return de.size();
    }

    @Override
    public void printDeque() {
        de.printDeque();
    }

    @Override
    public T removeFirst() {
        return de.removeFirst();
    }

    @Override
    public T removeLast() {
        return de.removeLast();
    }

    public T get(int index){
        return de.get(index);
    }

    @Override
    public void addFirst(T item) {
        de.addFirst(item);
    }

    public void addLast(T item){
        de.addLast(item);
    }
}

