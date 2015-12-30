package geo;

/**
 * Interface of Line.
 */
public interface ILine extends IBoundingBox {

    /**
     * Get the start.
     *
     * @return start
     */
    IPoint getStart();


    /**
     * Get the end.
     *
     * @return end
     */
    IPoint getEnd();


    /**
     * Get the other point of the line.
     *
     * @param p given point
     * @return other point or null if the given point is not part of the line
     */
    IPoint getOtherPoint(IPoint p);

    // Iterable

}
