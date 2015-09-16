package basic.imp;

import basic.ILine;
import basic.IPoint;
import basic.IVector;

public class Line extends ComplexShape implements ILine {

    private Point start, end;
    private double xMin, yMin, xMax, yMax;

    @Override
    public void initByCopying(ILine other) {
        removeAsParents();
        start = new Point();
        end = new Point();
        start.initByCopying(other.getStart());
        end.initByCopying(other.getEnd());
        addAsParents();
        update();
    }

    @Override
    public void initWithPoints(IPoint start, IPoint end) {
        removeAsParents();
        this.start = (Point) start;
        this.end = (Point) end;
        addAsParents();
        update();
    }

    private void removeAsParents() {
        removeAsParent(start);
        removeAsParent(end);
    }

    private void addAsParents() {
        addAsParent(start);
        addAsParent(end);
    }

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
        xMin = Math.min(start.getX(), end.getX());
        yMin = Math.min(start.getY(), end.getY());
        xMax = Math.max(start.getX(), end.getX());
        yMax = Math.max(start.getY(), end.getY());
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
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("<");
        b.append(start);
        b.append("<>");
        b.append(end);
        b.append(">");
        return b.toString();
    }

}
