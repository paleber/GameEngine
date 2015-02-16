package sprite;

import time.tpf.ITpfCounter;
import geo.ICircle;
import geo.IPoint;
import geo.IPolygon;
import geo.IVector;
import geo.imp.GeoModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Ball implements IBall {

    private static final Injector INJECTOR = Guice.createInjector(new GeoModule());
    
    private final IBoundingBox bb = new BoundingBox();
    
    private ICircle circle;
    
    private static final double RADIUS = 5;
    
    private final IVector direction = INJECTOR.getInstance(IVector.class);
    
    private static final double SPEED = 100;
    
    private ITpfCounter tpfCounter;
    
    private final class BoundingBox implements IBoundingBox {

        @Override
        public double getXMin() {
            return circle.getMid().getX() - circle.getRadius();
        }

        @Override
        public double getXMax() {
            return circle.getMid().getX() + circle.getRadius();
        }

        @Override
        public double getYMin() {
            return circle.getMid().getY() - circle.getRadius();
        }

        @Override
        public double getYMax() {
            return circle.getMid().getY() + circle.getRadius();
        }
        
    }
    
    @Override
    public IBoundingBox getBoundingBox() {
        return bb;
    }

    // TODO use assisted inject
    @Override 
    public void init(IPoint mid, double degree, double speed, final ITpfCounter tpfCounter) {
        circle = INJECTOR.getInstance(ICircle.class);
        circle.setMid(mid);
        circle.setRadius(RADIUS);
        this.tpfCounter = tpfCounter;
        direction.setAngle(degree);
    }

    @Override
    public void move() {
        direction.setLength(SPEED * tpfCounter.getTPF());
        circle.move(direction);
    }

    @Override
    public void collideWith(ICircle circle) {
        // TODO Auto-generated method stub

    }

    @Override
    public void collideWith(IPolygon poly) {
        // TODO Auto-generated method stub

    }

    @Override
    public ICircle getCircle() {
        return circle;
    }

}
