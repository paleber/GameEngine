package sprite;

import geo.basic.IPoint;
import geo.shape.IPolygonFix;

public interface IBall {

    void init(IPoint mid, double angle, double speed);
    
    // TPF setzen
    
    void move();
    
    void setDirection();
    
    void getDirection();
    
    IPolygonFix getPolygon();
}
