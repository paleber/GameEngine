package sprite;

import geo.ICircle;
import geo.ILine;
import geo.IPoint;
import geo.IPolygon;
import geo.IVector;
import geo.imp.GeoModule;

import java.util.Iterator;

import time.tpf.ITpfCounter;
import collision.Collision;
import collision.IBoundingBox;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Ball implements IBall {

    private static final Injector INJECTOR = Guice
            .createInjector(new GeoModule());

    private final IBoundingBox bb = new BoundingBox();

    private ICircle circle;

    private static final double RADIUS = 7;

    private final IVector dir = INJECTOR.getInstance(IVector.class);

    private static final double SPEED = 250;

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
    public void init(IPoint mid, double degree, double speed,
            final ITpfCounter tpfCounter) {
        circle = INJECTOR.getInstance(ICircle.class);
        circle.setMid(mid);
        circle.setRadius(RADIUS);
        this.tpfCounter = tpfCounter;
        dir.setAngle(degree);
    }

    @Override
    public void move() {
        dir.setLength(SPEED * tpfCounter.getTPF());
        circle.move(dir);
    }

    @Override
    public void collideWith(ICircle circle) {
        // TODO Auto-generated method stub

    }

    @Override
    public void collideWith(IPolygon poly) {
        System.out.println("Collision - " + System.currentTimeMillis());
        
        Iterator<ILine> it = poly.getEdgeIterator();
        while(it.hasNext()) {
            System.out.println("außen");
            ILine l = it.next();
            if(Collision.check(l, circle)) {
                
                System.out.println("innen");
                
                // zurück
                dir.swap();
              //  circle.move(dir);
                dir.swap();
                
                // reflect
                dir.reflect(l);
                
               
                circle.move(dir);
                
                
            }
            
            
        }
        
        
        // TODO Suche lediglich nächste Linie oder Punkt
        

    }

    @Override
    public ICircle getShape() {
        return circle;
    }

}
