import org.junit.Test;

import static org.junit.Assert.*;


public class TriangleTest {

    @Test
    public void testSJX1ValidTriangle() {
        assertEquals(true, TriangleUtils.SJX1(3, 4, 5));
    }

    @Test
    public void testSJX1InvalidTriangle() {
        assertEquals(false, TriangleUtils.SJX1(1, 2, 3));
    }

    @Test
    public void testDengyaoIsIsosceles() {
        assertEquals(true, TriangleUtils.dengyao(3, 3, 4));
    }

    @Test
    public void testDengyaoIsNotIsosceles() {
        assertEquals(false, TriangleUtils.dengyao(3, 4, 5));
    }

    @Test
    public void testDengbianIsEquilateral() {
        assertEquals(true, TriangleUtils.dengbian(5, 5, 5));
    }

    @Test
    public void testDengbianIsNotEquilateral() {
        assertEquals(false, TriangleUtils.dengbian(3, 4, 5));
    }
}
