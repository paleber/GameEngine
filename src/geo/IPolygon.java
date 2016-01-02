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

    /**
     * Merge the points with same coordinates and lines with same points of two
     * Polygons. Elements of this Polygon are replaced.
     *
     * @param other other Polygon
     * @param delta maximal distance for merging two points
     */
    void mergePointsAndLines(IPolygon other, double delta);

    /** Check if the polygon contains the point.
     * @param p point
     * @return true if the polygon contains the point
     */
    boolean contains(IPoint p);

    /** Check if the polygon contains the line.
     * @param l line
     * @return true if the polygon contains the line
     */
    boolean contains(ILine l);

}
