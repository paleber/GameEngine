package basic;

public interface IPoint {

    void initWithXY(double x, double y);

    void initByCopying(IPoint other);

    double getX();

    double getY();

    void move(IVector movement);

    void rotate(IPoint pivot, double radian);

    String toString();

}
