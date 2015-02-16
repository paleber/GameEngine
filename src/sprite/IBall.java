package sprite;

import geo.ICircle;
import geo.IPoint;
import geo.IPolygon;
import time.tpf.ITpfCounter;
import collision.IBoundingBoxCollider;

public interface IBall extends IBoundingBoxCollider {

    void init(IPoint mid, double angle, double speed, ITpfCounter tpfCounter);

    void move();

    void collideWith(ICircle circle);

    void collideWith(IPolygon poly);

    ICircle getCircle(); // TODO, make immutable, only for collisionDetection
                          // and Paint

}
