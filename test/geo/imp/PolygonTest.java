package geo.imp;

import geo.ILine;
import geo.IPoint;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests for Point.
 */
public class PolygonTest {

    private static final double DELTA = 1e-9;

    @Test
    public void testValueConstructor() {
        Point p = new Point(1, 2);
        Point q = new Point(3, 4);
        Point r = new Point(5, 6);
        Polygon poly = new Polygon(p, q, r);

        assertEquals(3, poly.getNumberElements());
        assertEquals(p, poly.getPoint(0));
        assertEquals(q, poly.getPoint(1));
        assertEquals(r, poly.getPoint(2));
    }

    @Test
    public void testCopyConstructor() {
        Point p = new Point(2, 3);
        Point q = new Point(4, 5);
        Point r = new Point(6, 7);
        Polygon poly = new Polygon(new Polygon(p, q, r));

        assertEquals(3, poly.getNumberElements());
        assertEquals(2, poly.getPoint(0).getX(), DELTA);
        assertEquals(3, poly.getPoint(0).getY(), DELTA);
        assertEquals(4, poly.getPoint(1).getX(), DELTA);
        assertEquals(5, poly.getPoint(1).getY(), DELTA);
        assertEquals(6, poly.getPoint(2).getX(), DELTA);
        assertEquals(7, poly.getPoint(2).getY(), DELTA);
    }

    @Test
    public void testPathConstructor() {
        Point p = new Point(1, 1);
        Vector v = new Vector(2, 0);
        Vector u = new Vector(1, 4);
        Polygon poly = new Polygon(p, v, u);

        assertEquals(3, poly.getNumberElements());
        assertEquals(p, poly.getPoint(0));
        assertEquals(3, poly.getPoint(1).getX(), DELTA);
        assertEquals(1, poly.getPoint(1).getY(), DELTA);
        assertEquals(4, poly.getPoint(2).getX(), DELTA);
        assertEquals(5, poly.getPoint(2).getY(), DELTA);
    }

    @Test
    public void testGetXYMinMax() {
        Point p = new Point(5, 3);
        Point q = new Point(4, 5);
        Point r = new Point(6, 4);
        Polygon poly = new Polygon(p, q, r);

        assertEquals(4, poly.getXMin(), DELTA);
        assertEquals(6, poly.getXMax(), DELTA);
        assertEquals(3, poly.getYMin(), DELTA);
        assertEquals(5, poly.getYMax(), DELTA);
    }

    @Test
    public void testGetLine() {
        Point p = new Point(0, 0);
        Point q = new Point(1, 0);
        Point r = new Point(1, 1);
        Polygon poly = new Polygon(p, q, r);

        assertEquals(1, poly.getLine(2).getStart().getX(), DELTA);
        assertEquals(1, poly.getLine(2).getStart().getY(), DELTA);
        assertEquals(0, poly.getLine(2).getEnd().getX(), DELTA);
        assertEquals(0, poly.getLine(2).getEnd().getY(), DELTA);
    }

    @Test
    public void move() {
        Point p = new Point(0, 0);
        Point q = new Point(1, 0);
        Point r = new Point(1, 1);
        Polygon poly = new Polygon(p, q, r);

        Vector v = new Vector(2, 3);
        poly.move(v);

        assertEquals(3, poly.getPoint(2).getX(), DELTA);
        assertEquals(4, poly.getPoint(2).getY(), DELTA);
    }

    @Test
    public void testRotate() {
        Point p = new Point(0, 0);
        Point q = new Point(1, 2);
        Point r = new Point(1, 1);
        Polygon poly = new Polygon(p, q, r);

        Point pivot = new Point(0, 0);
        poly.rotate(pivot, Math.PI);

        assertEquals(-1, poly.getPoint(1).getX(), DELTA);
        assertEquals(-2, poly.getPoint(1).getY(), DELTA);
    }

    @Test
    public void testPointIterator() {
        Polygon poly = new Polygon(new Point(0, 0), new Point(1, 2), new Point(3, 3));

        for(int i = 0; i < 2; i++) {
            int index = 0;
            for(IPoint p: poly.iteratePoints()) {
                assertEquals(poly.getPoint(index), p);
                index++;
            }
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testPointIteratorNoSuchElementException() {
        Polygon poly = new Polygon(new Point(0, 0), new Point(1, 2), new Point(3, 3));

        Iterator<IPoint> it = poly.iteratePoints().iterator();
        for(int i = 0; i < 4; i++) {
            it.next();
        }
    }

    @Test
    public void testLineIterator() {
        Polygon poly = new Polygon(new Point(0, 0), new Point(1, 2), new Point(3, 3));

        for(int i = 0; i < 2; i++) {
            int index = 0;
            for(ILine l: poly.iterateLines()) {
                assertEquals(poly.getLine(index), l);
                index++;
            }
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testLineIteratorNoSuchElementException() {
        Polygon poly = new Polygon(new Point(0, 0), new Point(1, 2), new Point(3, 3));

        Iterator<ILine> it = poly.iterateLines().iterator();
        for(int i = 0; i < 4; i++) {
            it.next();
        }
    }

    @Test
    public void testToString() {
        Point p = new Point(0, 0);
        Point q = new Point(1, 0);
        Point r = new Point(1, 1);
        Polygon poly = new Polygon(p, q, r);

        assertEquals("<(0.000|0.000)(1.000|0.000)(1.000|1.000)>", poly.toString());
    }

}
