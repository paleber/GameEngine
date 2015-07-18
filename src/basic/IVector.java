package basic;

public interface IVector {

    void initWithXY(double x, double y);
    void initWithAngle(double radian, double length);
    void initByCopying(IVector other);
    void initByStretching(IPoint from, IPoint to);
    
    double getX();
    double getY();
    double getLength();
    double getAngleRadian();
    
    String toString();

}
