package basic.imp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import basic.IPoint;
import basic.IPolygon;
import basic.IVector;

final class Polygon implements IPolygon {

    private final List<IPoint> points = new ArrayList<>();
    
    @Override
    public void initWithPoints(IPoint... points) {
        this.points.clear();
        for(IPoint p: points) {
            this.points.add(p);
        }
    }
    
    @Override
    public void initByCopying(IPolygon other) {
        points.clear();
        for (IPoint p: other) {
            IPoint q = new Point();
            q.initByCopying(p);
            points.add(q);
        }
    }

    @Override
    public void move(IVector movement) {
        for(IPoint p: points) {
            p.move(movement);
        }
    }

    @Override
    public void rotate(IPoint pivot, double radian) {
        for(IPoint p: points) {
            p.rotate(pivot, radian);
        }
    }

    @Override
    public Iterator<IPoint> iterator() {
        
        return new Iterator<IPoint>() {
            private int index = 0;
            
            @Override
            public boolean hasNext() {
                return index >= points.size();
            }

            @Override
            public IPoint next() {
                return points.get(index++);
                
            }
        };
    }
}
