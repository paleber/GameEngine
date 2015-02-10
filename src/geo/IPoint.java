package geo;

public interface IPoint extends IPointFix {

	void set(double x, double y);
	
	void copy(IPoint other);
	
	void move(IVector v);

	void rotateAround(double angleDeg, IPoint pivot);
	
}