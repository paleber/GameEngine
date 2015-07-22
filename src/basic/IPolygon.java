package basic;

public interface IPolygon {

	void initWithPoints(IPoint... points);
	
	void initByCopying(IPolygon other);
	
	void move(IVector movement);
	
	void rotate(IPoint pivot);
	
	void getPointIterator();
	
	void getEdgeIterator();
	
}
