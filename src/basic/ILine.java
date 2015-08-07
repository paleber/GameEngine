package basic;

public interface ILine extends IShape {

	//void setStart(IPoint start);
	
	//void setEnd(IPoint end);
	
	//void setStart(double x, double y);
	
	//void setEnd(double x, double y);
	
	void initByCopying(ILine other);
	
	void initWithPoints(IPoint start, IPoint end);
	
	IPoint getStart();
	
	IPoint getEnd();
	
}
