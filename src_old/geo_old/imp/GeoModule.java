package geo_old.imp;

import geo_old.ICircle;
import geo_old.ILine;
import geo_old.IPoint;
import geo_old.IPolygon;
import geo_old.IVector;

import com.google.inject.AbstractModule;

public final class GeoModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(IPoint.class).to(Point.class);
        bind(IVector.class).to(Vector.class);
        bind(ILine.class).to(Line.class);
        bind(IPolygon.class).to(Polygon.class);
        bind(ICircle.class).to(Circle.class);
    }

}
