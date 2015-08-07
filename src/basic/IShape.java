package basic;

public interface IShape {

	
	
	void move(IVector v);

	void rotate(IPoint pivot, double radian);

	double getXMin();

	double getYMin();

	double getXMax();

	double getYMax();

	//<void addParent(IShape<?> parent); // nicht sichtbar

	void update(); // nicht sichtbar

}
