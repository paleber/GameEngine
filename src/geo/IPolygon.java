package geo;

import java.util.Iterator;

import collision.IBoundingBoxCollider;

public interface IPolygon extends IBoundingBoxCollider {

    void setPoints(IPoint[] point);

    void move(IVector v);

    void rotateAround(final double angleDeg, final IPoint pivot);

    int getNumPoints();

    int getNumEdges();

    IPoint getPoint(int index);

    ILine getEdge(int index);

    Iterator<IPoint> getPointIterator();

    Iterator<ILine> getEdgeIterator();

}
