package basic.imp;

import com.google.inject.AbstractModule;

import basic.ICircle;
import basic.ILine;
import basic.IPoint;
import basic.IPolygon;
import basic.IVector;

public class BasicModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IPoint.class).to(Point.class);
        bind(IVector.class).to(Vector.class);
        bind(ILine.class).to(Line.class);
        bind(IPolygon.class).to(Polygon.class);
        bind(ICircle.class).to(Circle.class);
    }

}
