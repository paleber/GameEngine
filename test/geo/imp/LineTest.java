package geo.imp;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Tests for Line.
 */
public class LineTest {

    private static final double DELTA = 1e-9;

    @Test
    public void testValueConstructor() {
        Line l = new Line(new Point(1, 2), new Point(4, 3));

        assertEquals(1, l.getStart().getX(), DELTA);
        assertEquals(2, l.getStart().getY(), DELTA);
        assertEquals(4, l.getEnd().getX(), DELTA);
        assertEquals(3, l.getEnd().getY(), DELTA);
    }

    @Test
    public void testCopyConstructor() {
        Line l = new Line(new Line(new Point(5, 7), new Point(1, 4)));

        assertEquals(5, l.getStart().getX(), DELTA);
        assertEquals(7, l.getStart().getY(), DELTA);
        assertEquals(1, l.getEnd().getX(), DELTA);
        assertEquals(4, l.getEnd().getY(), DELTA);
    }

    @Test
    public void testGetter() {
        Point p = new Point(1, 3);
        Point q = new Point(4, 2);
        Line l = new Line(p, q);

        assertEquals(l.getStart(), p);
        assertEquals(l.getEnd(), q);
    }

    @Test
    public void testUpdateXYMinMax() {
        Line l = new Line(new Point(5, 6), new Point(7, 3));
        assertEquals(5, l.getXMin(), DELTA);
        assertEquals(7, l.getXMax(), DELTA);
        assertEquals(3, l.getYMin(), DELTA);
        assertEquals(6, l.getYMax(), DELTA);
    }

    @Test
    public void testGetOtherPoint() {
        Point s = new Point(2, 3);
        Point e = new Point(4, 5);
        Line l = new Line(s, e);
        assertEquals(s, l.getOtherPoint(e));
        assertEquals(e, l.getOtherPoint(s));
        assertNull(l.getOtherPoint(new Point(0, 0)));
    }

    @Test
    public void replacePoint() {
        Point p = new Point(0, 0);
        Point q = new Point(1, 1);
        Point r = new Point(2, 2);

        Line l = new Line(p, q);
        l.replacePoint(p, r);
        assertEquals(r, l.getStart());
        assertEquals(q, l.getEnd());

        l = new Line(p, q);
        l.replacePoint(q, r);
        assertEquals(p, l.getStart());
        assertEquals(r, l.getEnd());

        l = new Line(p, q);
        l.replacePoint(new Point(3, 3), r);
        assertEquals(p, l.getStart());
        assertEquals(q, l.getEnd());
    }

    @Test
    public void testContainsPoint() {
        Point p = new Point(0, 0);

        Line l = new Line(p, new Point(1, 1));
        assertTrue(l.contains(p));

        l = new Line(new Point(1, 1), p);
        assertTrue(l.contains(p));

        l = new Line(new Point(1, 1), new Point(2, 2));
        assertFalse(l.contains(p));
    }

    @Test
    public void toStringTest() {
        Line l = new Line(new Point(1, 2), new Point(4, 3));
        assertEquals("<(1.000|2.000)(4.000|3.000)>", l.toString());
    }

    /*
    @Test
    public void testIterable() {
        for(int i = 0; i < 2; i++) {
            int j = 0;
            for (IPoint n : l.iteratePoints()) {
                if (j == 0) {
                    assertEquals(p, n);
                } else {
                    assertEquals(q, n);
                }
                j++;
            }
        }
    } */

}
