package geo.basic;

public interface IVector extends IVectorFix {

    void set(double x, double y);

    void copy(IVector other);

    void stretchBetween(IPoint from, IPoint to);

    void setAngle(double degree, double length);

    void swap();

    void rotate(double degree);

}
