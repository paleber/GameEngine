package geo.imp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
