package geo.shape;

import java.util.Iterator;

import geo.basic.IBoundingBoxCollider;
import geo.basic.IPointFix;

public interface IPolygonFix extends IBoundingBoxCollider {

    int getNumPoints();

    int getNumEdges();

    IPointFix getPoint(int index);

    ILineFix getEdge(int index);

    Iterator<IPointFix> getPointIterator();

    Iterator<ILineFix> getEdgeIterator();

}
