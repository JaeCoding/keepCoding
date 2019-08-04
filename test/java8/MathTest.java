package java8;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MathTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void calculate() throws Exception {
        assertEquals(120, new Math().calculate(5));
    }
}