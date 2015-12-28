package geo;

import geo2.*;

import java.util.Iterator;


/*
public class IPolygonNew {

    void initByCopying(IPolygon other);

    void initWithPoints(IPoint... points);

    int getNumberElements();

    IPoint getPoint(int index);

    ILine getLine(int index);

    void setPoints(IPoint[] point);



    int getNumPoints();

    int getNumEdges();

    IPoint getPoint(int index);

    ILine getEdge(int index);

    Iterator<IPoint> getPointIterator();

    Iterator<ILine> getEdgeIterator();





	void copy(IPolygon other);

	void addPoint(double x, double y);

	void addPoint(IVector v);

	Iterable<IPoint> iteratePoints();

	Iterable<ILine> iterateLines();

     */


//}



/**
 * Interface of Polygon.
 */
public interface IPolygon { //extends geo2.IShape {

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
