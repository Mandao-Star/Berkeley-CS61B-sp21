package deque;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Comparator;

public class MaxArrayDequeTest {

    @Test
    public void MaxIntegerTest(){
        Comparator<Integer> absComparator = (a, b) -> {return Math.abs(a) - Math.abs(b);};
        MaxArrayDeque<Integer>  mad = new MaxArrayDeque<>(absComparator);

        mad.addLast(1);
        mad.addLast(-100);
        mad.addLast(10);

        assertEquals(Integer.valueOf(-100), mad.max());


        Comparator<Integer> naturalCom = Comparator.naturalOrder();
        assertEquals(Integer.valueOf(10), mad.max(naturalCom));
    }


    @Test
    public void MaxPeopleTest(){
        Comparator<People> ageCom = new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o1.age - o2.age;
            }
        };

        MaxArrayDeque<People> mad = new MaxArrayDeque<>(ageCom);

        People p1 = new People(10, "abc");
        People p2 = new People(12, "efg");
        People p3 = new People(-100, "zz");

        mad.addLast(p1);
        mad.addLast(p2);
        mad.addLast(p3);

        assertEquals(p2, mad.max());

        Comparator<People> nameCom = (a, b) -> {return a.name.compareTo(b.name);};
        assertEquals(p3, mad.max(nameCom));
    }

    private static class People {
        public   int age;
        public   String name;

        public People(int age, String name){
           this.age = age;
           this.name = name;
        }
    }
}
