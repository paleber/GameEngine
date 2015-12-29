package geo.imp;

import com.google.inject.Guice;
import geo.IGeoFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Tests for GeoModule.
 */
public class GeoModuleTest {

    private static final IGeoFactory GEO = Guice.createInjector(
            new GeoModule()).getInstance(IGeoFactory.class);

    @Test
    public void testGeoModule() {
        assertNotNull(GEO.createPoint(1, 2));
        assertNotNull(GEO.createVector(3, 4));
        assertNotNull(GEO.createLine(new Point(1, 2), new Point(3, 4)));
        assertNotNull(GEO.createCircle(new Point(1, 2), 3));
        assertNotNull(GEO.createPolygon(new Point(1,2), new Point(3, 4), new Point(5, 6)));
    }

}
