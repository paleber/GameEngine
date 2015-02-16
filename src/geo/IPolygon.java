package geo;

import java.util.Iterator;

import collision.IBoundingBoxCollider;

public interface IPolygon extends IBoundingBoxCollider, IShape {

    void setPoints(IPoint[] point);

    

    int getNumPoints();

    int getNumEdges();

    IPoint getPoint(int index);

    ILine getEdge(int index);

    Iterator<IPoint> getPointIterator();

    Iterator<ILine> getEdgeIterator();

}
