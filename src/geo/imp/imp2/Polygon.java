package geo.imp.imp2;

import geo.ILine;
import geo.IPoint;
import geo.IPolygon;
import geo.IVector;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class Polygon implements IPolygon {

    private  List<Point> points = new ArrayList<>();
    private  List<Line> lines = new ArrayList<>();

    private double xMin, yMin, xMax, yMax;

    @Override
    public void addPoint(double x, double y) {
        points.add(new Point(x, y));
        update();
    }

    @Override
    public void addPoint(IVector v) {
        Point p = new Point(points.get(points.size() - 1));
        p.move(v);
        points.add(p);
        update();
    }

    @Override
    public void copy(IPolygon other) {
        points.clear();
        lines.clear();
        for (IPoint p : other.iteratePoints()) {
            points.add(new Point(p.getX(), p.getY()));
        }
        update();
    }

    private void initLines() {
        lines.clear();
        for (int i = 0; i < points.size(); i++) {
            lines.add(new Line(points.get(i), points.get((i + 1) % points.size())));
        }
    }

    @Override
    public void move(IVector v) {
        for (Point p : points) {
            p.move(v);
        }
        update();
    }

    @Override
    public void rotate(IPoint pivot, double radian) {
        for (Point p : points) {
            p.rotate(pivot, radian);
        }
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

    private void update() {
        xMin = points.get(0).getX();
        yMin = points.get(0).getY();
        xMax = points.get(0).getX();
        yMax = points.get(0).getY();
        for (int i = 1; i < points.size(); i++) {
            xMin = Math.min(xMin, points.get(i).getX());
            yMin = Math.min(yMin, points.get(i).getY());
            xMax = Math.max(xMax, points.get(i).getX());
            yMax = Math.max(yMax, points.get(i).getY());
        }
    }

    private final Iterable<IPoint> pointIterator = () -> new Iterator<IPoint>() {
        int i = 0;

        @Override
        public boolean hasNext() {
            return i < points.size();
        }

        @Override
        public IPoint next() {
            return points.get(i++);
        }
    };

    @Override
    public Iterable<IPoint> iteratePoints() {
        return pointIterator;
    }

    private final Iterable<ILine> lineIterator = () -> new Iterator<ILine>() {
        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < lines.size();
        }

        @Override
        public ILine next() {
            return lines.get(i++);
        }
    };

    @Override
    public Iterable<ILine> iterateLines() {
        if (lines.size() != points.size()) {
            initLines();
        }

        return lineIterator;
    }


    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("<");
        points.forEach(b::append);
        b.append(">");
        return b.toString();
    }



}
