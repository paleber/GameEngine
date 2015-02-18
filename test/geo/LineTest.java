package geo;

import static org.junit.Assert.assertTrue;
import geo.imp.GeoModule;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class LineTest {

    private static final Injector INJECTOR = Guice
            .createInjector(new GeoModule());

    private IPoint p = INJECTOR.getInstance(IPoint.class);
    private IPoint q = INJECTOR.getInstance(IPoint.class);
    private ILine l = INJECTOR.getInstance(ILine.class);

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

    /*@Test
    public void boundingBox() {
        IBoundingBox bb = l.getBoundingBox();
        assertEquals(2, bb.getXMin(), 0);
        assertEquals(4, bb.getXMax(), 0);
        assertEquals(1, bb.getYMin(), 0);
        assertEquals(5, bb.getYMax(), 0);
    } */

}
