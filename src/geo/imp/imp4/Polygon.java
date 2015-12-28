package geo.imp.imp4;

import geo_old.ILine;
import geo_old.IPoint;
import geo_old.IPolygon;
import geo_old.IVector;

import java.util.Iterator;

import collision.IBoundingBox;

class Polygon implements IPolygon {

    private IPoint[] points;
    private ILine[] edges;

    private IPoint xMin;
    private IPoint xMax;
    private IPoint yMin;
    private IPoint yMax;
    private final IBoundingBox bb = new BoundingBox();

    @Override
    public int getNumPoints() {
        return points.length;
    }

    @Override
    public int getNumEdges() {
        return edges.length;
    }

    @Override
    public ILine getEdge(int index) {
        return edges[index];
    }

    @Override
    public Iterator<IPoint> getPointIterator() {
        return new Iterator<IPoint>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < points.length;
            }

            @Override
            public IPoint next() {
                return points[index++];
            }

        };

    }

    @Override
    public Iterator<ILine> getEdgeIterator() {

        return new Iterator<ILine>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < edges.length;
            }

            @Override
            public ILine next() {
                return edges[index++];
            }

        };
    }

    @Override
    public IPoint getPoint(final int index) {
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

  
    public IBoundingBox getBoundingBox() {
        return bb;
    }

    private final class BoundingBox implements IBoundingBox {

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
    }

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
