package basic.imp;

import basic.ILine;
import basic.IPoint;
import basic.IVector;

public class Line implements ILine, IComplexShape {

    private IPoint start, end;
    private double xMin, yMin, xMax, yMax;

    @Override
    public void move(IVector v) {
        start.move(v);
        end.move(v);
    }

    @Override
    public void rotate(IPoint pivot, double radian) {
        start.rotate(pivot, radian);
        end.rotate(pivot, radian);
    }

    @Override
    public double getXMin() {
        return xMin;
    }

    @Override
    public double getYMin() {
        return yMin;
    }

    @Override
    public double getXMax() {
        return xMax;
    }

    @Override
    public double getYMax() {
        return yMax;
    }

    @Override
    public void update() {
        xMin = Math.min(xMin, xMax);
        yMin = Math.min(yMin, yMax);
        xMax = Math.max(xMin, xMax);
        yMax = Math.max(yMin, yMax);
    }

    @Override
    public void initByCopying(ILine other) {
        start = new Point();
        start.initByCopying(other.getStart());
        end = new Point();
        end.initByCopying(other.getEnd());
    }

    @Override
    public void initWithPoints(IPoint start, IPoint end) {
        // TODO Auto-generated method stub
        this.start = start;
        this.end = end;
    }

    @Override
    public IPoint getStart() {
        return start;
    }

    @Override
    public IPoint getEnd() {
        return end;
    }
    
    private void registerInPoints() {
        
    }

}
