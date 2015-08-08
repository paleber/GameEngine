package basic;

public interface IPolygon extends IShape {

	void initByCopying(IPolygon other);
	
	void initWithPoints(IPoint... points);
	
	int getNumberElements();
	
	IPoint getPoint(int index);
	
	ILine getLine(int index);
	
}
