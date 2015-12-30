package geo.imp;

import com.google.inject.assistedinject.Assisted;

import com.google.inject.assistedinject.AssistedInject;
import geo.ILine;
import geo.IPoint;
import geo.IPolygon;
import geo.IVector;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Implementation of Polygon.
 */
final class Polygon extends BoundingBox implements IPolygon {

    private final Point[] points;
    private final Line[] lines;

    private final Iterable<IPoint> pointIterator =
            () -> new Iterator<IPoint>() {
                private int index = 0;

                @Override
                public boolean hasNext() {
                    return index < points.length;
                }

                @Override
                public IPoint next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    return points[index++];
                }
            };

    private final Iterable<ILine> lineIterator =
            () -> new Iterator<ILine>() {
                private int index = 0;

                @Override
                public boolean hasNext() {
                    return index < lines.length;
                }

                @Override
                public ILine next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    return lines[index++];
                }
            };

    @AssistedInject
    Polygon(@Assisted final IPoint... p) {
        points = new Point[p.length];
        for (int i = 0; i < p.length; i++) {
            points[i] = (Point) p[i];
        }
        lines = new Line[points.length];
        initLines();
        addAsParent();
    }

    @AssistedInject
    Polygon(@Assisted final IPoint p, @Assisted final IVector... v) {
        points = new Point[1 + v.length];
        points[0] = (Point) p;
        for (int i = 0; i < v.length; i++) {
            points[i + 1] = new Point(points[i]);
            points[i + 1].move(v[i]);
        }
        lines = new Line[points.length];
        initLines();
        addAsParent();
    }

    @AssistedInject
    Polygon(@Assisted final IPolygon other) {
        Polygon poly = (Polygon) other;
        points = new Point[poly.points.length];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(poly.points[i]);
        }
        lines = new Line[points.length];
        initLines();
        addAsParent();
    }

    @AssistedInject
    Polygon(@Assisted final ILine... lines) {


        List<Line> list = new ArrayList<>();
        for(ILine l: lines) {
            list.add((Line) l);
        }

        points = new Point[lines.length];
        this.lines = new Line[lines.length];

        points[0] = (Point) list.get(0).getStart();
        for(int i = 0; i < lines.length - 1; i++) {
            boolean found = false;
            for (Line l: list) {
                IPoint p = l.getOtherPoint(points[i]);
                if (p != null) {
                    this.points[i + 1] = (Point) p;
                    this.lines[i] = l;
                    list.remove(l);
                    found = true;
                    break;
                }
            }

            if(!found) {
                throw new IllegalArgumentException();
            }
        }

        if(list.get(0).getOtherPoint(points[0]) != points[points.length-1]) {
            throw new IllegalArgumentException();
        }

        lines[lines.length - 1] = list.get(0);
        addAsParent();
    }

    private void initLines() {
        for (int i = 0; i < points.length; i++) {
            lines[i] = new Line(points[i], points[(i + 1) % points.length]);
        }
    }

    private void addAsParent() {
        for (Point p : points) {
            p.addParent(this);
        }
    }

    @Override
    public void move(final IVector v) {
        for (Point p : points) {
            p.move(v);
        }
        updateBoundingBox();
    }

    @Override
    public void rotate(final IPoint pivot, final double radian) {
        for (Point p : points) {
            p.rotate(pivot, radian);
        }
        updateBoundingBox();
    }

    @Override
    double updateXMin() {
        double xMin = points[0].getX();
        for (int i = 1; i < points.length; i++) {
            xMin = Math.min(xMin, points[i].getX());
        }
        return xMin;
    }

    @Override
    double updateXMax() {
        double xMax = points[0].getX();
        for (int i = 1; i < points.length; i++) {
            xMax = Math.max(xMax, points[i].getX());
        }
        return xMax;
    }

    @Override
    double updateYMin() {
        double yMin = points[0].getY();
        for (int i = 1; i < points.length; i++) {
            yMin = Math.min(yMin, points[i].getY());
        }
        return yMin;
    }

    @Override
    double updateYMax() {
        double yMax = points[0].getY();
        for (int i = 1; i < points.length; i++) {
            yMax = Math.max(yMax, points[i].getY());
        }
        return yMax;
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
    public Iterable<IPoint> iteratePoints() {
        return pointIterator;
    }

    @Override
    public Iterable<ILine> iterateLines() {
        return lineIterator;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("<");
        for (Point p : points) {
            b.append(p);
        }
        b.append(">");
        return b.toString();
    }

}
