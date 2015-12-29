package geo.imp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for Circle.
 */
public class CircleTest {

    private static final double DELTA = 1e-9;

    @Test
    public void testValueConstructor() {
        Circle c = new Circle(new Point(4, 5), 2);
        assertEquals(4, c.getMid().getX(), DELTA);
        assertEquals(5, c.getMid().getY(), DELTA);
        assertEquals(2, c.getRadius(), DELTA);
    }

    @Test
    public void testCopyConstructor() {
        Circle c = new Circle(new Circle(new Point(2, 3), 4));
        assertEquals(2, c.getMid().getX(), DELTA);
        assertEquals(3, c.getMid().getY(), DELTA);
        assertEquals(4, c.getRadius(), DELTA);
    }

    @Test
    public void testGetter() {
        Point m = new Point(5, 2);
        Circle c = new Circle(m, 3);
        assertEquals(m, c.getMid());
        assertEquals(3, c.getRadius(), DELTA);
    }

    @Test
    public void testUpdateXYMinMax() {
        Circle c = new Circle(new Point(4, 7), 2);
        assertEquals(2, c.getXMin(), DELTA);
        assertEquals(6, c.getXMax(), DELTA);
        assertEquals(5, c.getYMin(), DELTA);
        assertEquals(9, c.getYMax(), DELTA);
    }

    @Test
    public void move() {
        Circle c = new Circle(new Point(1, 2), 3);
        c.move(new Vector(1, 3));

        assertEquals(2, c.getMid().getX(), DELTA);
        assertEquals(5, c.getMid().getY(), DELTA);
    }

    @Test
    public void rotate() {
        Circle c = new Circle(new Point(1, 2), 3);
        c.rotate(new Point(0, 0), Math.PI);

        assertEquals(-1, c.getMid().getX(), DELTA);
        assertEquals(-2, c.getMid().getY(), DELTA);
    }

    @Test
    public void testToString() {
        Circle c = new Circle(new Point(8, 5), 7);
        assertEquals("<(8.000|5.000)r=7.000>", c.toString());
    }

}
