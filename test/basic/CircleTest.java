package basic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import basic.imp.BasicModule;

public class CircleTest{

    private static final double DELTA = 1e-9;
    
    private static final Injector INJECTOR = Guice.createInjector(new BasicModule());
    

    private final IPoint m = INJECTOR.getInstance(IPoint.class);
    private final IPoint p = INJECTOR.getInstance(IPoint.class);
    private final IVector v = INJECTOR.getInstance(IVector.class);
    private final ICircle c = INJECTOR.getInstance(ICircle.class);
    
    @Test
    public void init() {
        m.initWithXY(4, 5);
        c.init(m, 2);
        
        assertEquals(4, c.getMid().getX(), DELTA);
        assertEquals(5, c.getMid().getY(), DELTA);
        assertEquals(2, c.getRadius(), DELTA);
    }
    
    @Test
    public void move() {
        m.initWithXY(1, 2);
        c.init(m, 2);
      
        v.initWithXY(1, 3);
        c.move(v);
        
        assertEquals(2, c.getMid().getX(), DELTA);
        assertEquals(5, c.getMid().getY(), DELTA);
    }
    
    @Test
    public void getXYMinMax() {
        m.initWithXY(4, 5);
        c.init(m, 2);
        
        assertEquals(2, c.getXMin(), DELTA);
        assertEquals(6, c.getXMax(), DELTA);
        assertEquals(3, c.getYMin(), DELTA);
        assertEquals(7, c.getYMax(), DELTA);
    }

    @Test
    public void rotate() {
        m.initWithXY(1, 2);
        c.init(m, 2);
        p.initWithXY(0, 0);
        
        c.rotate(p, Math.PI);

        assertEquals(-1, c.getMid().getX(), DELTA);
        assertEquals(-2, c.getMid().getY(), DELTA);
    }
    
    @Test
    public void string() {
        m.initWithXY(4, 5);
        c.init(m, 2);
        assertEquals("<(4.000|5.000)r=2.000>", c.toString());
    }

    
}
