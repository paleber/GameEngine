package geo;

import static org.junit.Assert.assertEquals;
import geo.basic.IBoundingBoxCollider.IBoundingBox;
import geo.basic.IPoint;
import geo.basic.IPointFix;
import geo.basic.IVector;
import geo.imp.Point;
import geo.imp.Polygon;
import geo.imp.Vector;
import geo.shape.ILineFix;
import geo.shape.IPolygon;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class PolygonTest {

    private static final double DELTA = 1e-9;
    private IPolygon poly = new Polygon();
    private IPoint[] points = { new Point(), new Point(), new Point() };

    @Before
    public void setUp() {
        points[0].set(0, 0);
        points[1].set(1, 0);
        points[2].set(1, 1);
        poly.setPoints(points);
    }

    @Test
    public void numPointsEdges() {
        assertEquals(3, poly.getNumPoints());
        assertEquals(3, poly.getNumEdges());
    }

    @Test
    public void getEdge() {
        ILineFix l = poly.getEdge(2);
        assertEquals(points[2], l.getStart());
        assertEquals(points[0], l.getEnd());
    }

    @Test
    public void getPoint() {
        assertEquals(points[1], poly.getPoint(1));
    }

    @Test
    public void move() {
        IVector v = new Vector();
        v.set(3, 1);

        poly.move(v);

        IPointFix p = poly.getPoint(0);
        assertEquals(3, p.getX(), 1e-9);
        assertEquals(1, p.getY(), 1e-9);
    }

    @Test
    public void rotate() {
        IPoint pivot = new Point();
        pivot.set(0.5, 0.5);

        poly.rotateAround(180, pivot);

        IPointFix p = poly.getPoint(0);
        assertEquals(1, p.getX(), 1e-9);
        assertEquals(1, p.getY(), 1e-9);
    }

    @Test
    public void pointIterator() {
        Iterator<IPointFix> it = poly.getPointIterator();
        int i = 0;
        while (it.hasNext()) {
            assertEquals(points[i], it.next());
            i++;
        }
        assertEquals(3, i);
    }
    
    @Test
    public void edgeIterator() {
        Iterator<ILineFix> it = poly.getEdgeIterator();
        int i = 0;
        while (it.hasNext()) {
            assertEquals(poly.getEdge(i), it.next());
            i++;
        }
        assertEquals(3, i);
    }

    @Test
    public void boundingBox() {
       IBoundingBox bb = poly.getBoundingBox();
       assertEquals(0, bb.getXMin(), DELTA);
       assertEquals(0, bb.getYMin(), DELTA);
       assertEquals(1, bb.getXMax(), DELTA);
       assertEquals(1, bb.getYMax(), DELTA);
        
    }
}
