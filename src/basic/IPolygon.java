package basic;

public interface IPolygon extends Iterable<IPoint>{

	void initWithPoints(IPoint... points);
	
	void initByCopying(IPolygon other);
	
	void move(IVector movement);
	
	void rotate(IPoint pivot, double radian);
	
	//int getNumberPoints();
}
