package geo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import geo.basic.IBoundingBoxCollider.IBoundingBox;
import geo.basic.IPoint;
import geo.imp.Line;
import geo.imp.Point;
import geo.shape.ILine;

import org.junit.Before;
import org.junit.Test;

public class LineTest {

    private IPoint p = new Point();
    private IPoint q = new Point();
    private ILine l = new Line();
    
    @Before
    public void setUp() {
        p.set(2, 1);
        q.set(4, 5);
        l.setPoints(p, q);
    }
    
    @Test
    public void get() {
        assertTrue(l.getStart() == p);
        assertTrue(l.getEnd() == q);
    }
    
    @Test
    public void boundingBox() {
        IBoundingBox bb = l.getBoundingBox();
        assertEquals(2, bb.getXMin(), 0);
        assertEquals(4, bb.getXMax(), 0);
        assertEquals(1, bb.getYMin(), 0);
        assertEquals(5, bb.getYMax(), 0);
    }
    
}
