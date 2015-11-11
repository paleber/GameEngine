package geo_old;

import static org.junit.Assert.assertEquals;
import geo_old.imp.GeoModule;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class VectorTest {

    private static final Injector INJECTOR = Guice
            .createInjector(new GeoModule());
    
    private static final double DELTA = 1e-9;

    IVector v = INJECTOR.getInstance(IVector.class);
    IVector u = INJECTOR.getInstance(IVector.class);

    @Before
    public void setUp() {
        v.set(3, 4);
        u.set(5, 4);
    }

    @Test
    public void get() {
        assertEquals(3, v.getX(), DELTA);
        assertEquals(4, v.getY(), DELTA);
    }

    @Test
    public void length() {
        v.setLength(3);
        assertEquals(3, v.getLength(), DELTA);
    }

    @Test
    public void angle() {
        v.setAngle(0);
        assertEquals(0, v.getAngle(), DELTA);

        v.setAngle(-270);
        assertEquals(90, v.getAngle(), DELTA);

        v.setAngle(360);
        assertEquals(0, v.getAngle(), DELTA);
    }

    @Test
    public void swap() {
        v.setAngle(90);
        v.swap();
        assertEquals(270, v.getAngle(), DELTA);
    }

    @Test
    public void copy() {
        v.copy(u);
        assertEquals(5, v.getX(), DELTA);
        assertEquals(4, v.getY(), DELTA);
    }

    @Test
    public void toStringTest() {
        assertEquals("<3.000|4.000>", v.toString());
    }

    @Test
    public void rotate() {
        v.setAngle(0);
        v.rotate(90);
        assertEquals(90, v.getAngle(), DELTA);
    }

    @Test
    public void stretchBetween() {
        IPoint p = INJECTOR.getInstance(IPoint.class);
        p.set(-1, -1);
        IPoint q = INJECTOR.getInstance(IPoint.class);
        q.set(2, 1);
        v.stretchBetween(p, q);

        assertEquals(3, v.getX(), DELTA);
        assertEquals(2, v.getY(), DELTA);
    }
    
    @Test
    public void dotProduct() {
        IVector u = INJECTOR.getInstance(IVector.class);
        u.set(3, 4);
        IVector v = INJECTOR.getInstance(IVector.class);
        v.set(-2, 1);
        assertEquals(-2, u.dotProduct(v), DELTA);
    }
}
