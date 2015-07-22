package basic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import basic.imp.BasicModule;

public class VectorTest {

    private static final Injector INJECTOR = Guice
            .createInjector(new BasicModule());
    private final IVector v = INJECTOR.getInstance(IVector.class);
    private static final double DELTA = 1e-9;

    @Test
    public void initWithXY() {
        v.initWithXY(5, 3);
        assertEquals(5, v.getX(), DELTA);
        assertEquals(3, v.getY(), DELTA);
    }

    @Test
    public void initWithAngleAndLength() {
        v.initWithAngleAndLength(0.75 * Math.PI, Math.sqrt(2));
        assertEquals(-1, v.getX(), DELTA);
        assertEquals(1, v.getY(), DELTA);

        v.initWithAngleAndLength(-5 * Math.PI, 2);
        assertEquals(-2, v.getX(), DELTA);
        assertEquals(0, v.getY(), DELTA);
    }

    @Test
    public void initByCopying() {
        IVector u = INJECTOR.getInstance(IVector.class);
        u.initWithXY(1, 3);

        v.initByCopying(u);
        assertEquals(1, v.getX(), DELTA);
        assertEquals(3, v.getY(), DELTA);
    }

    @Test
    public void initByStretching() {
        IPoint p = INJECTOR.getInstance(IPoint.class);
        p.initWithXY(-2, -1);

        IPoint q = INJECTOR.getInstance(IPoint.class);
        q.initWithXY(3, 2);

        v.initByStretching(p, q);
        assertEquals(5, v.getX(), DELTA);
        assertEquals(3, v.getY(), DELTA);

    }

    @Test
    public void getLength() {
        v.initWithAngleAndLength(2, 3);
        assertEquals(3, v.getLength(), DELTA);
    }

    @Test
    public void getAngle() {
        v.initWithAngleAndLength(-5 * Math.PI, 3);
        assertEquals(Math.PI, v.getAngle(), DELTA);
    }

    @Test
    public void setLength() {
        v.setLength(3);
        assertEquals(3, v.getLength(), DELTA);

    }

    @Test
    public void rotate() {
        v.initWithAngleAndLength(0.25 * Math.PI, 1);
        v.rotate(-1.5 * Math.PI);
        assertEquals(0.75 * Math.PI, v.getAngle(), DELTA);
    }

    @Test
    public void toStringTest() {
        v.initWithXY(2, 3);
        assertEquals("<2.000|3.000>", v.toString());
    }

}
