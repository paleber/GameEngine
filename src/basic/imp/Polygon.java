package basic.imp;

import basic.ILine;
import basic.IPoint;
import basic.IPolygon;
import basic.IVector;

final class Polygon extends ComplexShape implements IPolygon {

    private Point[] points;
    private ILine[] lines;
    
    private double xMin, yMin, xMax, yMax;
    private boolean doUpdate = true;

    @Override
    public void initWithPoints(IPoint... points) {
        removeAsParents();
        this.points = new Point[points.length];
        for(int i = 0; i < points.length; i++) {
            this.points[i] = (Point) points[i];
            
        }
        addAsParents();
        initLines();
        update();
    }

    @Override
    public void initByCopying(IPolygon other) {
        removeAsParents();
        points = new Point[other.getNumberElements()];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point();
            points[i].initByCopying(other.getPoint(i));
        }
        addAsParents();
        initLines();
        update();
    }
    
    
    private void removeAsParents() {
        if(points != null) {
            for(Point p: points) {
                removeAsParent(p);
            }
        }
    }

    private void addAsParents() {
        for(Point p: points) {
            addAsParent(p);
        }
        update();
    }
    

    private void initLines() {
        lines = new ILine[points.length];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = new Line();
            if (i != lines.length - 1) {
                lines[i].initWithPoints(points[i], points[i + 1]);
            } else {
                lines[i].initWithPoints(points[i], points[0]);
            }
        }
    }

    @Override
    public void move(IVector movement) {
        doUpdate = false;
        for (IPoint p : points) {
            p.move(movement);
        }
        doUpdate = true;
        update();
    }

    @Override
    public void rotate(IPoint pivot, double radian) {
        doUpdate = false;
        for (IPoint p : points) {
            p.rotate(pivot, radian);
        }
        doUpdate = true;
        update();
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
        if (doUpdate) {
            xMin = points[0].getX();
            yMin = points[0].getY();
            xMax = points[0].getX();
            yMax = points[0].getY();
            for (int i = 1; i < points.length; i++) {
                xMin = Math.min(xMin, points[i].getX());
                yMin = Math.min(yMin, points[i].getY());
                xMax = Math.max(xMax, points[i].getX());
                yMax = Math.max(yMax, points[i].getY()); 
            }
        }
    }

    @Override
    public int getNumberElements() {
        return points.length;
    }

    @Override
    public IPoint getPoint(int index) {
        return points[index];
    }

    @Override
    public ILine getLine(int index) {
        return lines[index];
    }
    
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("<");
        for (IPoint p: points) {
            b.append(p);
        }
        b.append(">");
        return b.toString();
    }

}
