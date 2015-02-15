package geo;

import collision.IBoundingBoxCollider;

public interface ILine extends IBoundingBoxCollider {

    IPoint getStart();

    IPoint getEnd();
    
    void setPoints(IPoint start, IPoint end);
    
}


