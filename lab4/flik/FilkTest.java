package flik;
import static org.junit.Assert.*;
import org.junit.Test;

public class FilkTest {
    @Test
    public void TestIsSameNumber(){
        assertTrue(Flik.isSameNumber(128, 128));
        assertTrue(Flik.isSameNumber(500, 500));
    }
}
