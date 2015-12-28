package geo;

/**
 * Interface of Polygon.
 */
public interface IPolygon extends IMovable, IBoundingBox {

    /**
     * Get the number of elements
     *
     * @return number of elements
     */
    int getNumberElements();

    /**
     * Get a point by index.
     *
     * @param index index
     * @return point
     */
    IPoint getPoint(int index);

    /**
     * Get a line by index.
     *
     * @param index index
     * @return line
     */
    ILine getLine(int index);

    /**
     * Iterate through the points.
     *
     * @return point-iterator
     */
    Iterable<IPoint> iteratePoints();

    /**
     * Iterate through the lines.
     *
     * @return line-iterator
     */
    Iterable<ILine> iterateLines();

}
