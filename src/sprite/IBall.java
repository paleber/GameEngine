package sprite;

import collision.IBoundingBoxCollider;
import geo.IPoint;
import geo.IPolygon;

public interface IBall extends IBoundingBoxCollider {

    void init(IPoint mid, double angle, double speed);
    
    // TPF setzen
    
    void move();
    
    void setDirection();
    
    void getDirection();
    
    IPolygon getPolygon();
}
