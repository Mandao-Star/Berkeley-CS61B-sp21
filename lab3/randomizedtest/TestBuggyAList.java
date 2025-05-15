package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove(){

        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> buggy = new BuggyAList<>();

        correct.addLast(4);
        correct.addLast(5);
        correct.addLast(6);

        buggy.addLast(4);
        buggy.addLast(5);
        buggy.addLast(6);

        assertEquals(buggy.removeLast(), correct.removeLast());
        assertEquals(buggy.removeLast(), correct.removeLast());
        assertEquals(buggy.removeLast(), correct.removeLast());
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> bugger = new BuggyAList<>();

        int N = 5000;

        for(int i = 0; i < N; i++){
            int operationNumber = StdRandom.uniform(0, 4);
            if(operationNumber == 0){
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                bugger.addLast(randVal);
            } else if (operationNumber == 1){
                int correctSize = correct.size();
                int buggySize = bugger.size();
                assertEquals(correctSize, buggySize);
            } else if (operationNumber == 2 || operationNumber == 3){
                if(correct.size() > 0) {
                    if(operationNumber == 2){
                        int correctLast = correct.getLast();
                        int buggyLast = bugger.getLast();
                        assertEquals(correctLast, buggyLast);
                    } else {
                        int  correctRemoved = correct.removeLast();
                        int buggyRemoved = bugger.removeLast();
                        assertEquals(correctRemoved, buggyRemoved);
                    }
                }

            }
        }
    }
}

