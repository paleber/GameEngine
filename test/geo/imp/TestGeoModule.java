package geo.imp;

import com.google.inject.Guice;
import com.google.inject.Injector;
import geo.ICircle;
import geo.IPolygon;
import geo.IVector;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TestGeoModule {

    private static final Injector INJ = Guice.createInjector(new GeoModule());

    @Test
    public void testConfigure() {
        assertNotNull(INJ.getInstance(IVector.class));
        assertNotNull(INJ.getInstance(IPolygon.class));
        assertNotNull(INJ.getInstance(ICircle.class));
    }

}
