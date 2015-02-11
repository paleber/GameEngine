package geo.shape;

import geo.basic.IBoundingBoxCollider;
import geo.basic.IPointFix;

public interface ILineFix extends IBoundingBoxCollider {
    
    IPointFix getStart();

    IPointFix getEnd();

}
