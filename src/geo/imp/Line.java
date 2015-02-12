package geo.imp;

import geo.basic.IPoint;
import geo.shape.ILine;

public final class Line implements ILine {

    private IPoint start;
    private IPoint end;

    private final IBoundingBox bb = new BoundingBox();
    
    private final class BoundingBox implements IBoundingBox {
        
        @Override
        public double getXMin() {
            return Math.min(start.getX(), end.getX());
        }

        @Override
        public double getXMax() {
            return Math.max(start.getX(), end.getX());
        }

        @Override
        public double getYMin() {
            return Math.min(start.getY(), end.getY());
        }

        @Override
        public double getYMax() {
            return Math.max(start.getY(), end.getY());
        }
        
    }

    @Override
    public IPoint getStart() {
        return start;
    }

    @Override
    public IPoint getEnd() {
        return end;
    }

    @Override
    public void setPoints(IPoint start, IPoint end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public IBoundingBox getBoundingBox() {
        return bb;
    }

}
