package sprite;

import collision.IBoundingBoxCollider;
import geo.ICircle;
import geo.ILine;
import geo.IPoint;
import geo.IPolygon;

public interface IBall extends IBoundingBoxCollider {

    void init(IPoint mid, double angle, double speed);

    // TPF Counter über DI-Singleton

    void move();

  //  void collideWith(ICircle circle)
    
    void collideWith(ICircle circle);
    
    void collideWith(IPolygon poly);
    
    IPolygon getPolygon(); // TODO, make immutable, only for collisionDetection and Paint

}
