package geo;

public interface IVector {

    void set(double x, double y);

    void copy(IVector other);

    void stretchBetween(IPoint from, IPoint to);

    double getX();

    double getY();

    void setAngle(double degree);

    double getAngle();

    void setLength(double length);

    double getLength();

    void swap();

    void rotate(double degree);

    double dotProduct(IVector other);

    void reflect(ILine l);

    void multScalar(double scalar);
    
}
