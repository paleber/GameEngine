package geo.imp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCircle {

    private static final Circle c = new Circle();
    private static final double DELTA = 1e-9;

    @Test
    public void testMidAndRadius() {
        c.init(2, 3, 4);
        assertEquals(2, c.getMid().getX(), DELTA);
        assertEquals(3, c.getMid().getY(), DELTA);
        assertEquals(4, c.getRadius(), DELTA);
    }

    @Test
    public void testBoundingBox() {
        c.init(2, 3, 4);
        assertEquals(-2, c.getXMin(), DELTA);
        assertEquals(6, c.getXMax(), DELTA);
        assertEquals(-1, c.getYMin(), DELTA);
        assertEquals(7, c.getYMax(), DELTA);
    }

    @Test
    public void move() {
        c.init(1, 2, 3);

        Vector v = new Vector();
        v.init(1, 3);
        c.move(v);

        assertEquals(2, c.getMid().getX(), DELTA);
        assertEquals(5, c.getMid().getY(), DELTA);
    }

    @Test
    public void rotate() {
        c.init(1, 2, 2);
        Point p = new Point(0, 0);

        c.rotate(p, Math.PI);
        assertEquals(-1, c.getMid().getX(), DELTA);
        assertEquals(-2, c.getMid().getY(), DELTA);
    }

    @Test
    public void string() {
        c.init(4, 5, 2);
        assertEquals("<(4.000|5.000)r=2.000>", c.toString());
    }

}
