package geo.imp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for Point.
 */
public class PointTest {

    private static final double DELTA = 1e-9;

    @Test
    public void testValueConstructor() {
        Point p = new Point(3, 5);
        assertEquals(3, p.getX(), DELTA);
        assertEquals(5, p.getY(), DELTA);
    }

    @Test
    public void testCopyConstructor() {
        Point p = new Point(new Point(7, 5));
        assertEquals(7, p.getX(), DELTA);
        assertEquals(5, p.getY(), DELTA);
    }

    @Test
    public void testGetter() {
        Point p = new Point(3, 4);
        assertEquals(3, p.getX(), DELTA);
        assertEquals(4, p.getY(), DELTA);
    }

    @Test
    public void testMove() {
        Vector v = new Vector(2, 5);
        Point p = new Point(1, 2);
        p.move(v);
        assertEquals(3, p.getX(), DELTA);
        assertEquals(7, p.getY(), DELTA);
    }

    @Test
    public void testRotate() {
        Point q = new Point(1, 1);
        Point p = new Point(0, 0);

        p.rotate(q, 0.5 * Math.PI);
        assertEquals(2, p.getX(), DELTA);
        assertEquals(0, p.getY(), DELTA);

        p.rotate(q, 2.5 * Math.PI);
        assertEquals(2, p.getX(), DELTA);
        assertEquals(2, p.getY(), DELTA);

        p.rotate(q, -3.5 * Math.PI);
        assertEquals(0, p.getX(), DELTA);
        assertEquals(2, p.getY(), DELTA);
    }

    @Test
    public void testParents() {
        Point mid = new Point(7, 5);
        Circle c = new Circle(mid, 1);
        c.move(new Vector(1, -2));
        assertEquals(c.getXMax(), 9, DELTA);
    }

    @Test
    public void testDistance() {
        Point p = new Point(1, 1);
        Point q = new Point(4, 5);
        assertEquals(5, p.distanceTo(q), DELTA);
        assertEquals(25, p.squareDistanceTo(q), DELTA);
    }

    @Test
    public void testToString() {
        Point p = new Point(7, 8);
        assertEquals("(7.000|8.000)", p.toString());
    }

}
