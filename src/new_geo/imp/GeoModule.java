package new_geo.imp;

import new_geo.*;
import com.google.inject.AbstractModule;

public final class GeoModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IPoint.class).to(Point.class);
        bind(IVector.class).to(Vector.class);
        bind(ILine.class).to(Line.class);
        bind(ICircle.class).to(Circle.class);
        bind(IPolygon.class).to(Polygon.class);
    }

}
