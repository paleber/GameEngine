package geo;

/*
public class IVectorNew {

    void initWithXY(double x, double y);

    void initWithAngleAndLength(double radian, double length);

    void initByCopying(IVector other);

    void initByStretching(IPoint from, IPoint to);

    double getX();

    double getY();

    double getLength();

    double getAngle();

    void setLength(double length);

    void rotate(double radian);

 */

    /*
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
    */


    /*

       void init(double x, double y);

    void copy(IVector other);

    void stretch(IPoint from, IPoint to);

    double getX();

    double getY();

    double getLength();

    double getAngle();

    void setLength(double length);

    void rotate(double radian);


     */


//}







/**
 * Interface of Vector.
 */
public interface IVector {

    /**
     * Get the x-value.
     *
     * @return x-value
     */
    double getX();

    /**
     * Get the y-value.
     *
     * @return y-value
     */
    double getY();

    /**
     * Get the length.
     *
     * @return length
     */
    double getLength();

    /**
     * Get the angle.
     *
     * @return angle in radian
     */
    double getAngle();

    /**
     * Set the length.
     *
     * @param length length
     */
    void setLength(double length);

    /**
     * Rotate.
     *
     * @param radian angle in radian
     */
    void rotate(double radian);

}




