package basic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import basic.imp.BasicModule;

public class LineTest {

    private static final double DELTA = 1e-9;
    
    private static final Injector INJECTOR = Guice.createInjector(new BasicModule());
    
    private final ILine l = INJECTOR.getInstance(ILine.class);
    private final ILine m = INJECTOR.getInstance(ILine.class);
    private final IPoint s = INJECTOR.getInstance(IPoint.class);
    private final IPoint e = INJECTOR.getInstance(IPoint.class);
    private final IPoint p = INJECTOR.getInstance(IPoint.class);
    private final IVector v = INJECTOR.getInstance(IVector.class);
   
    @Test
    public void initWithPoints() {
        s.initWithXY(1, 2);
        e.initWithXY(4, 3);
        l.initWithPoints(s, e);
        
        assertEquals(1, l.getStart().getX(), DELTA);
        assertEquals(2, l.getStart().getY(), DELTA);
        
        assertEquals(4, l.getEnd().getX(), DELTA);
        assertEquals(3, l.getEnd().getY(), DELTA);
        
        assertEquals(l.getStart(), s);
        assertEquals(l.getEnd(), e);
    }
    
    @Test
    public void initByCopyingPoints() {
        s.initWithXY(1, 2);
        e.initWithXY(4, 3);
        m.initWithPoints(s, e);
        l.initByCopying(m);
        
        assertEquals(1, l.getStart().getX(), DELTA);
        assertEquals(2, l.getStart().getY(), DELTA);
        assertEquals(4, l.getEnd().getX(), DELTA);
        assertEquals(3, l.getEnd().getY(), DELTA);
        
        assertNotEquals(l.getStart(), s);
        assertNotEquals(l.getEnd(), e);
    }
    
    @Test
    public void getXYMinMax() {
        s.initWithXY(1, 2);
        e.initWithXY(4, 3);
        l.initWithPoints(s, e);
        
        assertEquals(1, l.getXMin(), DELTA);
        assertEquals(4, l.getXMax(), DELTA);
        assertEquals(2, l.getYMin(), DELTA);
        assertEquals(3, l.getYMax(), DELTA);
        
        v.initWithXY(-3, 2);
        l.move(v);
        assertEquals(-2, l.getXMin(), DELTA);
        assertEquals(1, l.getXMax(), DELTA);
        assertEquals(4, l.getYMin(), DELTA);
        assertEquals(5, l.getYMax(), DELTA);
        
        p.initWithXY(0, 0);
        l.rotate(p, Math.PI);
        assertEquals(-1, l.getXMin(), DELTA);
        assertEquals(2, l.getXMax(), DELTA);
        assertEquals(-5, l.getYMin(), DELTA);
        assertEquals(-4, l.getYMax(), DELTA);
    }    
    
    @Test
    public void move() {
        s.initWithXY(1, 2);
        e.initWithXY(4, 3);
        l.initWithPoints(s, e);
        v.initWithXY(1, 3);
        
        l.move(v);
        
        assertEquals(2, l.getStart().getX(), DELTA);
        assertEquals(5, l.getStart().getY(), DELTA);
        assertEquals(5, l.getEnd().getX(), DELTA);
        assertEquals(6, l.getEnd().getY(), DELTA);
    }
    
    @Test
    public void rotate() {
        s.initWithXY(1, 2);
        e.initWithXY(4, 3);
        l.initWithPoints(s, e);
        p.initWithXY(0, 0);
        
        l.rotate(p, Math.PI);

        assertEquals(-1, l.getStart().getX(), DELTA);
        assertEquals(-2, l.getStart().getY(), DELTA);
        assertEquals(-4, l.getEnd().getX(), DELTA);
        assertEquals(-3, l.getEnd().getY(), DELTA); 
    }

    @Test
    public void toStringTest() {
        s.initWithXY(1, 2);
        e.initWithXY(4, 3);
        l.initWithPoints(s, e);

        assertEquals("<(1.000|2.000)<>(4.000|3.000)>", l.toString());
    }
    
}
