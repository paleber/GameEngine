package basic;
/*
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
        
        Assert.assertEquals(3, poly.getNumberElements());
        Assert.assertEquals(0, poly.getPoint(0).getX(), DELTA);
        Assert.assertEquals(0, poly.getPoint(0).getY(), DELTA);
        Assert.assertEquals(1, poly.getPoint(1).getX(), DELTA);
        Assert.assertEquals(0, poly.getPoint(1).getY(), DELTA);
        Assert.assertEquals(1, poly.getPoint(2).getX(), DELTA);
        Assert.assertEquals(1, poly.getPoint(2).getY(), DELTA);
    }

    @Test
    public void initByCopying() {
        p1.initWithXY(0, 0);
        p2.initWithXY(1, 0);
        p3.initWithXY(1, 1);
        
        poly2.initWithPoints(p1, p2, p3);
        poly.initByCopying(poly2);
        
        Assert.assertEquals(3, poly.getNumberElements());
        Assert.assertEquals(0, poly.getPoint(0).getX(), DELTA);
        Assert.assertEquals(0, poly.getPoint(0).getY(), DELTA);
        Assert.assertEquals(1, poly.getPoint(1).getX(), DELTA);
        Assert.assertEquals(0, poly.getPoint(1).getY(), DELTA);
        Assert.assertEquals(1, poly.getPoint(2).getX(), DELTA);
        Assert.assertEquals(1, poly.getPoint(2).getY(), DELTA);
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
        
        Assert.assertEquals(1, poly.getXMin(), DELTA);
        Assert.assertEquals(3, poly.getXMax(), DELTA);
        Assert.assertEquals(4, poly.getYMin(), DELTA);
        Assert.assertEquals(6, poly.getYMax(), DELTA);
    }
    
    
    @Test
    public void move() {
        p1.initWithXY(0, 0);
        p2.initWithXY(1, 0);
        p3.initWithXY(1, 1);
        poly.initWithPoints(p1, p2, p3);
        
        v.initWithXY(2, 3);
        poly.move(v);
         
        Assert.assertEquals(3, poly.getPoint(2).getX(), DELTA);
        Assert.assertEquals(4, poly.getPoint(2).getY(), DELTA);
    }
    
    @Test
    public void rotate() {
        p1.initWithXY(0, 0);
        p2.initWithXY(1, 2);
        p3.initWithXY(1, 1);
        poly.initWithPoints(p1, p2, p3);
        
        pivot.initWithXY(0, 0);
        poly.rotate(pivot, Math.PI);

        Assert.assertEquals(-1, poly.getPoint(1).getX(), DELTA);
        Assert.assertEquals(-2, poly.getPoint(1).getY(), DELTA);
    }
    
    
    
    @Test
    public void getLine() {
        p1.initWithXY(0, 0);
        p2.initWithXY(1, 0);
        p3.initWithXY(1, 1);
        
        poly.initWithPoints(p1, p2, p3);
        
        Assert.assertEquals(1, poly.getLine(2).getStart().getX(), DELTA);
        Assert.assertEquals(1, poly.getLine(2).getStart().getY(), DELTA);
        Assert.assertEquals(0, poly.getLine(2).getEnd().getX(), DELTA);
        Assert.assertEquals(0, poly.getLine(2).getEnd().getY(), DELTA);
    }
    
    @Test
    public void string() {
        p1.initWithXY(0, 0);
        p2.initWithXY(1, 0);
        p3.initWithXY(1, 1);
        
        poly.initWithPoints(p1, p2, p3);
        
        Assert.assertEquals("<(0.000|0.000)(1.000|0.000)(1.000|1.000)>", poly.toString());
    }
    
}
*/