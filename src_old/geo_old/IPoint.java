package geo_old;


public interface IPoint  {

    void set(double x, double y);

    void copy(IPoint other);

    void move(IVector v);

    void rotateAround(double angleDeg, IPoint pivot);

    double getX();

    double getY();
    
    double distanceTo(IPoint other);

    double distanceSquareTo(IPoint other);
    
}
