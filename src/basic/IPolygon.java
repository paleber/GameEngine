package basic;

public interface IPolygon extends IShape {

	void initByCopying(IPolygon other);
	
	void initWithPoints(IPoint... points);
	
	int getNumberPoints();
	
	IPoint getPoint();
	
	//void move(IVector movement);
	
	//void rotate(IPoint pivot, double radian);
	
}
