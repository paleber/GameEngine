package geo.shape;

import geo.basic.IBoundingBoxCollider;
import geo.basic.IPoint;


public interface ILine extends ILineFix, IBoundingBoxCollider {

    @Override
    IPoint getStart();

    @Override
    IPoint getEnd();

    void setPoints(IPoint start, IPoint end);
    
}
