package new_geo;

import java.util.Iterator;

public interface IPolygon extends IShape {

	void copy(IPolygon other);

	void addPoint(double x, double y);

	void addPoint(IVector v);

	Iterable<IPoint> iteratePoints();

	Iterable<ILine> iterateLines();

}
