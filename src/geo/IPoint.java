package geo;





    // void initByCopying(IPoint other);

    // void initWithXY(double x, double y);

    //void set(double x, double y);

    //void copy(IPoint other);

    //void move(geo_old.IVector v);

    //void rotateAround(double angleDeg, IPoint pivot);

    //double distanceTo(IPoint other);



/**
 * Interface of Point.
 */
public interface IPoint {

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
     * Calculate the square-distance to an other point.
     *
     * @param other other point
     * @return square-distance
     */
    double squareDistanceTo(IPoint other);

}
