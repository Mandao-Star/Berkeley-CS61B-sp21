package deque;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void addFirstTest(){
        System.out.println("加入8个元素， 未扩容");
        ArrayDeque<Integer> ad = new ArrayDeque<>();

        ad.addFirst(1);
        ad.addFirst(2);
        ad.addFirst(3);
        ad.addFirst(4);
        ad.addFirst(5);
        ad.addFirst(6);
        ad.addFirst(7);
        ad.addFirst(8);
        assertEquals(Integer.valueOf(8), ad.get(0));
    }

    @Test
    public void addLastTest(){
        System.out.println("尾巴加入8个元素， 未扩容");

        ArrayDeque<Integer> ad = new ArrayDeque<>();

        ad.addLast(1);
        ad.addLast(2);
        ad.addLast(3);
        ad.addLast(4);
        ad.addLast(5);
        ad.addLast(6);
        ad.addLast(7);
        ad.addLast(8);

        assertEquals("tail, index = 7, except = 7", Integer.valueOf(8), ad.get(7));
    }

    @Test
    public void removeTest(){
        System.out.println("删除元素");

        ArrayDeque<Integer> ad = new ArrayDeque<>();

        ad.addLast(1);
        ad.addLast(2);
        ad.addLast(3);
        ad.addLast(4);
        ad.addLast(5);
        ad.addLast(6);
        ad.addLast(7);
        ad.addLast(0);

        assertEquals(Integer.valueOf(1), ad.removeFirst());
        assertEquals(Integer.valueOf(0), ad.removeLast());
    }

    @Test
    public void emptyTest(){
        System.out.println("空队列");

        ArrayDeque<Integer> ad = new ArrayDeque<>();

        assertEquals(0, ad.size());
//        assertEquals(ture, ad.isEmpty());
    }

    @Test
    public void reSizeAddLastTest(){
        System.out.println("加入10个元素， 必须扩容为两倍");

        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for(int i = 1; i <= 10; i++){
            ad.addLast(i);
        }

        assertEquals(Integer.valueOf(10), ad.get(9));
    }

    @Test
    public void reSizeAddFirst(){
        System.out.println("头加入32个元素");

        ArrayDeque<Integer> ad = new ArrayDeque<>();

        for(int i = 1; i <= 32; i++){
            ad.addFirst(i);
        }

        assertEquals(Integer.valueOf(1), ad.get(31));
    }


    @Test
    public  void reSizeRemoveFirst(){
        System.out.println("头加入33个元素, 头删掉25个");


        ArrayDeque<Integer> ad = new ArrayDeque<>();

        for(int i = 1; i <= 33; i++){
            ad.addFirst(i);
        }

        for(int i = 1; i <= 25; i++) {
            ad.removeFirst();
        }

        assertEquals(Integer.valueOf(8), ad.get(0));
    }

    @Test
    public  void reSizeRemoveLast(){
        System.out.println("尾加入33个元素, 尾删掉25个");


        ArrayDeque<Integer> ad = new ArrayDeque<>();

        for(int i = 1; i <= 33; i++){
            ad.addLast(i);
        }

        for(int i = 1; i <= 25; i++) {
            ad.removeLast();
        }

        assertEquals(Integer.valueOf(8), ad.get(7));
    }


//    @Test
//    public void printDequeTest(){
//        ArrayDeque<Integer> ad = new ArrayDeque<>();
//
//        ad.addLast(1);
//        ad.addLast(2);
//        ad.addLast(3);
//
//        assertEquals("1 2 3\n", ad.printDeque());
//    }


    @Test
    public void equalsTest(){
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.addLast(1);
        ad.addLast(2);

        ArrayDeque<Integer> other = new ArrayDeque<>();
        other.addLast(1);
        other.addLast(2);

        assertEquals(true, ad.equals(other));

        other.addLast(3);
        assertEquals(false, ad.equals(other));
    }

}