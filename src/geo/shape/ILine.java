package geo.shape;

import geo.basic.IPoint;


public interface ILine extends ILineFix {

    @Override
    IPoint getStart();

    @Override
    IPoint getEnd();

    void setPoints(IPoint start, IPoint end);
    
}
