package geo;

import static org.junit.Assert.assertEquals;
import geo.basic.IPoint;
import geo.basic.IVector;
import geo.imp.Point;
import geo.imp.Vector;

import org.junit.Before;
import org.junit.Test;

public class VectorTest {

    private static final double DELTA = 1e-9;

    IVector v = new Vector();
    IVector u = new Vector();

    @Before
    public void setUp() {
        v.set(3, 4);
        u.set(5, 4);
    }

    @Test
    public void get() {
        assertEquals(3, v.getX(), DELTA);
        assertEquals(4, v.getY(), DELTA);
    }

    @Test
    public void length() {
        v.setLength(3);
        assertEquals(3, v.getLength(), DELTA);
    }

    @Test
    public void angle() {
        v.setAngle(0, 1);
        assertEquals(0, v.getAngle(), DELTA);

        v.setAngle(-270, 1);
        assertEquals(90, v.getAngle(), DELTA);

        v.setAngle(360, 1);
        assertEquals(0, v.getAngle(), DELTA);
    }

    @Test
    public void swap() {
        v.setAngle(90, 1);
        v.swap();
        assertEquals(270, v.getAngle(), DELTA);
    }

    @Test
    public void copy() {
        v.copy(u);
        assertEquals(5, v.getX(), DELTA);
        assertEquals(4, v.getY(), DELTA);
    }

    @Test
    public void toStringTest() {
        assertEquals("<3.000|4.000>", v.toString());
    }

    @Test
    public void rotate() {
        v.setAngle(0, 1);
        v.rotate(90);
        assertEquals(90, v.getAngle(), DELTA);
    }

    @Test
    public void stretchBetween() {
        IPoint p = new Point();
        p.set(-1, -1);
        IPoint q = new Point();
        q.set(2, 1);
        v.stretchBetween(p, q);

        assertEquals(3, v.getX(), DELTA);
        assertEquals(2, v.getY(), DELTA);

    }
}
