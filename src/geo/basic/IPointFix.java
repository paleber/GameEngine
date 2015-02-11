package geo.basic;

public interface IPointFix {

    double getX();

    double getY();
    
    double distanceTo(IPoint other);

    double distanceSquareTo(IPoint other);

}