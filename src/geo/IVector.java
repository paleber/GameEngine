package geo;

public interface IVector {

    void set(double x, double y);

    void copy(IVector other);

    void stretchBetween(IPoint from, IPoint to);

    void setAngle(double degree, double length);

    void swap();

    void rotate(double degree);

    double getX();

    double getY();

    double getLength();

    void setLength(double length);

    double getAngle();

}
