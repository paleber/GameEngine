package geo.shape;

import geo.basic.IPoint;
import geo.basic.IVector;

public interface IPolygon extends IPolygonFix {

    void setPoints(IPoint[] point);

    void move(IVector v);

    void rotateAround(final double angleDeg, final IPoint pivot);

}
