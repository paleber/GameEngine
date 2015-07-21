package basic.imp;

import com.google.inject.AbstractModule;

import basic.IPoint;
import basic.IVector;

public class BasicModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IPoint.class).to(Point.class);
        bind(IVector.class).to(Vector.class);
    }

}
