package geo.imp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/** Tests for Vector. */
public class VectorTest {

    private static final double DELTA = 1e-9;

    @Test
    public void testValueConstructor() {
        Vector v = new Vector(5, 3);
        assertEquals(5, v.getX(), DELTA);
        assertEquals(3, v.getY(), DELTA);
    }

    @Test
    public void testCopyConstructor() {
        Vector v = new Vector(new Vector(1, 3));
        assertEquals(1, v.getX(), DELTA);
        assertEquals(3, v.getY(), DELTA);
    }

    @Test
    public void testStretchConstructor() {
        Vector v = new Vector(new Point(1, 1), new Point(2, 3));
        assertEquals(1, v.getX(), DELTA);
        assertEquals(2, v.getY(), DELTA);
    }

    @Test
    public void testGetter() {
        Vector v = new Vector(3, 4);
        assertEquals(3, v.getX(), DELTA);
        assertEquals(4, v.getY(), DELTA);
        assertEquals(5, v.getLength(), DELTA);
    }

    @Test
    public void testSetLength() {
        Vector v = new Vector(0, 0);
        v.setLength(3);
        assertEquals(3, v.getLength(), DELTA);
    }

    @Test
    public void testRotateAndAngle() {
        Vector v = new Vector(1, 0);
        v.rotate(0.25 * Math.PI);
        assertEquals(0.25 * Math.PI, v.getAngle(), DELTA);

        v.rotate(-1.5 * Math.PI);
        assertEquals(0.75 * Math.PI, v.getAngle(), DELTA);

        v.rotate(6.5 * Math.PI);
        assertEquals(1.25 * Math.PI, v.getAngle(), DELTA);
    }

    @Test
    public void testToString() {
        Vector v = new Vector(2, 3);
        assertEquals("<2.000|3.000>", v.toString());
    }

    /*
    @Test
    public void dotProduct() {
        IVector u = INJECTOR.getInstance(IVector.class);
        u.set(3, 4);
        IVector v = INJECTOR.getInstance(IVector.class);
        v.set(-2, 1);
        assertEquals(-2, u.dotProduct(v), DELTA);
    } */



}
