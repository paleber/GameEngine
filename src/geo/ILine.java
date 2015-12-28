package geo;



/*
public class ILineNew {

    void initByCopying(ILine other);

    void initWithPoints(IPoint start, IPoint end);

    IPoint getStart();

    IPoint getEnd();


    // Iterable

    //void setPoints(IPoint start, IPoint end);

}
*/


/**
 * Interface of Line.
 */
public interface ILine { // extends IBoundingBox {

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

}
