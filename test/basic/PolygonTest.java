package basic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import basic.imp.BasicModule;

public class PolygonTest{

    private static final double DELTA = 1e-9;
    
    private static final Injector INJECTOR = Guice.createInjector(new BasicModule());
    
    private final IPolygon poly = INJECTOR.getInstance(IPolygon.class);
    private final IPolygon poly2 = INJECTOR.getInstance(IPolygon.class);

    private final IPoint p1 = INJECTOR.getInstance(IPoint.class);
    private final IPoint p2 = INJECTOR.getInstance(IPoint.class);
    private final IPoint p3 = INJECTOR.getInstance(IPoint.class);
    private final IPoint pivot = INJECTOR.getInstance(IPoint.class);
    
    private final IVector v = INJECTOR.getInstance(IVector.class);
    
    
    @Test
    public void initWithPoints() {
        p1.initWithXY(0, 0);
        p2.initWithXY(1, 0);
        p3.initWithXY(1, 1);
        
        poly.initWithPoints(p1, p2, p3);
        
        assertEquals(3, poly.getNumberElements());
        assertEquals(0, poly.getPoint(0).getX(), DELTA);
        assertEquals(0, poly.getPoint(0).getY(), DELTA);
        assertEquals(1, poly.getPoint(1).getX(), DELTA);
        assertEquals(0, poly.getPoint(1).getY(), DELTA);
        assertEquals(1, poly.getPoint(2).getX(), DELTA);
        assertEquals(1, poly.getPoint(2).getY(), DELTA);
    }

    @Test
    public void initByCopying() {
        p1.initWithXY(0, 0);
        p2.initWithXY(1, 0);
        p3.initWithXY(1, 1);
        
        poly2.initWithPoints(p1, p2, p3);
        poly.initByCopying(poly2);
        
        assertEquals(3, poly.getNumberElements());
        assertEquals(0, poly.getPoint(0).getX(), DELTA);
        assertEquals(0, poly.getPoint(0).getY(), DELTA);
        assertEquals(1, poly.getPoint(1).getX(), DELTA);
        assertEquals(0, poly.getPoint(1).getY(), DELTA);
        assertEquals(1, poly.getPoint(2).getX(), DELTA);
        assertEquals(1, poly.getPoint(2).getY(), DELTA);
    }

    @Test
    public void removeAsParent() {
        poly.initWithPoints(p1);
        poly.initWithPoints(p1);
    }
    
    @Test
    public void getXYMinMax() {
        p1.initWithXY(1, 4);
        p2.initWithXY(3, 6);
        p3.initWithXY(2, 5);
        
        poly.initWithPoints(p1, p2, p3);
        
        assertEquals(1, poly.getXMin(), DELTA);
        assertEquals(3, poly.getXMax(), DELTA);
        assertEquals(4, poly.getYMin(), DELTA);
        assertEquals(6, poly.getYMax(), DELTA);
    }
    
    
    @Test
    public void move() {
        p1.initWithXY(0, 0);
        p2.initWithXY(1, 0);
        p3.initWithXY(1, 1);
        poly.initWithPoints(p1, p2, p3);
        
        v.initWithXY(2, 3);
        poly.move(v);
         
        assertEquals(3, poly.getPoint(2).getX(), DELTA);
        assertEquals(4, poly.getPoint(2).getY(), DELTA);
    }
    
    @Test
    public void rotate() {
        p1.initWithXY(0, 0);
        p2.initWithXY(1, 2);
        p3.initWithXY(1, 1);
        poly.initWithPoints(p1, p2, p3);
        
        pivot.initWithXY(0, 0);
        poly.rotate(pivot, Math.PI);

        assertEquals(-1, poly.getPoint(1).getX(), DELTA);
        assertEquals(-2, poly.getPoint(1).getY(), DELTA);
    }
    
    
    
    @Test
    public void getLine() {
        p1.initWithXY(0, 0);
        p2.initWithXY(1, 0);
        p3.initWithXY(1, 1);
        
        poly.initWithPoints(p1, p2, p3);
        
        assertEquals(1, poly.getLine(2).getStart().getX(), DELTA);
        assertEquals(1, poly.getLine(2).getStart().getY(), DELTA);
        assertEquals(0, poly.getLine(2).getEnd().getX(), DELTA);
        assertEquals(0, poly.getLine(2).getEnd().getY(), DELTA);
    }
    
    @Test
    public void string() {
        p1.initWithXY(0, 0);
        p2.initWithXY(1, 0);
        p3.initWithXY(1, 1);
        
        poly.initWithPoints(p1, p2, p3);
        
        assertEquals("<(0.000|0.000)(1.000|0.000)(1.000|1.000)>", poly.toString());
    }
    
}
