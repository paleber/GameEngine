package basic;

/*
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import geo.imp.imp1.BasicModule;

public class PointTest {

    private static final Injector INJECTOR = Guice
            .createInjector(new BasicModule());
    private static final double DELTA = 1e-9;

    private final IPoint p = INJECTOR.getInstance(IPoint.class);
    private final IPoint q = INJECTOR.getInstance(IPoint.class);

    @Test
    public void initWithXY() {
        p.initWithXY(3, 4);
        Assert.assertEquals(3, p.getX(), DELTA);
        Assert.assertEquals(4, p.getY(), DELTA);
    }

    @Test
    public void initByCopying() {
        q.initWithXY(2, 3);
        p.initByCopying(q);
        Assert.assertEquals(2, p.getX(), DELTA);
        Assert.assertEquals(3, p.getY(), DELTA);
    }

    @Test
    public void move() {
        IVector v = INJECTOR.getInstance(IVector.class);
        v.initWithXY(2, 3);

        p.initWithXY(3, 4);
        p.move(v);

        Assert.assertEquals(5, p.getX(), DELTA);
        Assert.assertEquals(7, p.getY(), DELTA);
    }

    @Test
    public void rotate() {
        q.initWithXY(1, 1);
        p.initWithXY(0, 0);

        p.rotate(q, 0.5 * Math.PI);
        Assert.assertEquals(2, p.getX(), DELTA);
        Assert.assertEquals(0, p.getY(), DELTA);

        p.rotate(q, 2.5 * Math.PI);
        Assert.assertEquals(2, p.getX(), DELTA);
        Assert.assertEquals(2, p.getY(), DELTA);

        p.rotate(q, -3.5 * Math.PI);
        Assert.assertEquals(0, p.getX(), DELTA);
        Assert.assertEquals(2, p.getY(), DELTA);

    }

    @Test
    public void xyMinMax() {
        p.initWithXY(5, 7);
        Assert.assertEquals(5, p.getXMin(), DELTA);
        Assert.assertEquals(5, p.getXMax(), DELTA);
        Assert.assertEquals(7, p.getYMin(), DELTA);
        Assert.assertEquals(7, p.getYMax(), DELTA);
    }

    @Test
    public void parents() {
        ICircle c = INJECTOR.getInstance(ICircle.class);
        
        p.initWithXY(2, 3);
        q.initWithXY(4, 5);

        c.init(p, 1);
        c.init(q, 1);

        Assert.assertEquals(4, c.getMid().getX(), DELTA);
        /*
         * ILine l = INJECTOR.getInstance(ILine.class); p.initWithXY(1, 2);
         * q.initWithXY(4, 3); l.initWithPoints(p, q);
         * 
         * IVector v = INJECTOR.getInstance(IVector.class); v.initWithXY(1, 1);
         * 
         * //p.move(v);
         * 
         * assertEquals(2, l.getXMin(), DELTA); assertEquals(3, l.getYMin(),
         * DELTA);
         * 
         * // TODO
         *
    }

    @Test
    public void toStringTest() {
        p.initWithXY(7, 8);
        Assert.assertEquals("(7.000|8.000)", p.toString());
    }

}
*/