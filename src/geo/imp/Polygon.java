package geo.imp;

import geo.basic.IPoint;
import geo.basic.IPointFix;
import geo.basic.IVector;
import geo.shape.ILine;
import geo.shape.ILineFix;
import geo.shape.IPolygon;

import java.util.Iterator;

public class Polygon implements IPolygon {

    private IPoint[] points;
    private ILine[] edges;

    @Override
    public int getNumPoints() {
        return points.length;
    }

    @Override
    public int getNumEdges() {
        return edges.length;
    }

    @Override
    public ILineFix getEdge(int index) {
        return edges[index];
    }

    @Override
    public Iterator<IPointFix> getPointIterator() {
        return new Iterator<IPointFix>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < points.length;
            }

            @Override
            public IPointFix next() {
                return points[index++];
            }

        };

    }

    @Override
    public Iterator<ILineFix> getEdgeIterator() {

        return new Iterator<ILineFix>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < edges.length;
            }

            @Override
            public ILineFix next() {
                return edges[index++];
            }

        };
    }

    @Override
    public IPointFix getPoint(final int index) {
        return points[index];
    }

    @Override
    public void setPoints(final IPoint[] points) {
        this.points = points.clone();
        edges = new ILine[points.length];
        for (int i = 0; i < points.length; i++) {
            edges[i] = new Line();
            edges[i].setPoints(points[i], points[(i + 1) % points.length]);
        }
        calcBoundingBox();
    }

    @Override
    public void move(IVector v) {
        for (IPoint p : points) {
            p.move(v);
        }
    }

    @Override
    public void rotateAround(double angleDeg, IPoint pivot) {
        for (IPoint p : points) {
            p.rotateAround(angleDeg, pivot);
        }
        calcBoundingBox();
    }

    @Override
    public IBoundingBox getBoundingBox() {
        return bb;
    }

    private final IBoundingBox bb = new IBoundingBox() {

        @Override
        public double getXMin() {
            return xMin.getX();
        }

        @Override
        public double getXMax() {
            return xMax.getX();
        }

        @Override
        public double getYMin() {
            return yMin.getY();
        }

        @Override
        public double getYMax() {
            return yMax.getY();
        }

    };

    private IPoint xMin;
    private IPoint xMax;
    private IPoint yMin;
    private IPoint yMax;

    private void calcBoundingBox() {
        xMin = points[0];
        xMax = points[0];
        yMin = points[0];
        yMax = points[0];

        for (IPoint p : points) {

            if (p.getX() < xMin.getX()) {
                xMin = p;
            }

            if (p.getX() > xMax.getX()) {
                xMax = p;
            }

            if (p.getY() < yMin.getY()) {
                yMin = p;
            }

            if (p.getY() > yMax.getY()) {
                yMax = p;
            }
        }
    }
    
}
