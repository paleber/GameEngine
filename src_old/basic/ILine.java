package basic;

public interface ILine extends IShape {
	
	void initByCopying(ILine other);
	
	void initWithPoints(IPoint start, IPoint end);
	
	IPoint getStart();
	
	IPoint getEnd();
	
}
