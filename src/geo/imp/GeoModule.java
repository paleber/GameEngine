package geo.imp;

import geo.ILine;
import geo.IPoint;
import geo.IPolygon;
import geo.IVector;

import com.google.inject.AbstractModule;

public final class GeoModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(IPoint.class).to(Point.class);
        bind(IVector.class).to(Vector.class);
        bind(ILine.class).to(Line.class);
        bind(IPolygon.class).to(Polygon.class);
    }

}
