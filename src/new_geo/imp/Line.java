package new_geo.imp;

import new_geo.ILine;
import new_geo.IPoint;

import java.util.Iterator;

final class Line implements ILine {

    private final Point[] points = new Point[2];

    Line(Point s, Point e) {
        points[0] = s;
        points[1] = e;
    }

    @Override
    public double getXMin() {
        return Math.min(points[0].getX(), points[1].getX());
    }

    @Override
    public double getYMin() {
        return Math.min(points[0].getY(), points[1].getY());
    }

    @Override
    public double getXMax() {
        return Math.max(points[0].getX(), points[1].getX());
    }

    @Override
    public double getYMax() {
        return Math.max(points[0].getY(), points[1].getY());
    }

    /*
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("<");
        b.append(start);
        b.append("<>");
        b.append(end);
        b.append(">");
        return b.toString();
    }*/

    @Override
    public Iterator<IPoint> iteratePoints() {
        return new Iterator<IPoint>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < points.length;
            }

            @Override
            public IPoint next() {
                return points[i++];
            }
        };
    }
}
