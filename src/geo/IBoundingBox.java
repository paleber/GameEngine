package geo;

/**
 * Interface of BoundingBox.
 */
public interface IBoundingBox {

    /**
     * Get the minimum x-value.
     *
     * @return x-value.
     */
    double getXMin();

    /**
     * Get the minimum y-value.
     *
     * @return y-value.
     */
    double getYMin();

    /**
     * Get the maximum x-value.
     *
     * @return x-value.
     */
    double getXMax();

    /**
     * Get the maximum y-value.
     *
     * @return y-value.
     */
    double getYMax();

    /**
     * Calculate the middle.
     *
     * @return mid as new point.
     */
    IPoint calculateMid();

    // collideWith

    // contains

}
