package geo.imp.imp3;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

/** GeoModule. */
public final class GeoModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new FactoryModuleBuilder().
                implement(IPoint.class, Point.class).
                implement(IVector.class, Vector.class).
                implement(ILine.class, Line.class).
                implement(ICircle.class, Circle.class).
                implement(IPolygon.class, Polygon.class).
                build(IGeoFactory.class));


    }

}
