package geo;

import static org.junit.Assert.assertEquals;
import geo.imp.GeoModule;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class PointTest {

    private static final Injector INJECTOR = Guice
            .createInjector(new GeoModule());
    
    private static final double DELTA = 1e-9;

    private IPoint p = INJECTOR.getInstance(IPoint.class);
    private IPoint q = INJECTOR.getInstance(IPoint.class);;

    @Before
    public void setUp() {
        p.set(3, 4);
        q.set(7, 7);
    }

    @Test
    public void get() {
        assertEquals(3, p.getX(), DELTA);
        assertEquals(4, p.getY(), DELTA);
    }

    @Test
    public void getDistance() {
        assertEquals(5, p.distanceTo(q), DELTA);
        assertEquals(25, p.distanceSquareTo(q), DELTA);
    }

    @Test
    public void copy() {
        p.copy(q);
        assertEquals(7, p.getX(), DELTA);
        assertEquals(7, p.getY(), DELTA);
    }

    @Test
    public void move() {
        IVector v = INJECTOR.getInstance(IVector.class);
        v.set(2, 1);
        p.move(v);
        assertEquals(5, p.getX(), DELTA);
        assertEquals(5, p.getY(), DELTA);
    }

    @Test
    public void rotateAround() {
        p.rotateAround(720, q);
        assertEquals(3, p.getX(), DELTA);
        assertEquals(4, p.getY(), DELTA);

        p.rotateAround(-270, q);
        assertEquals(10, p.getX(), DELTA);
        assertEquals(3, p.getY(), DELTA);
    }

    @Test
    public void toStringTest() {
        assertEquals("(3.000|4.000)", p.toString());
    }
}
