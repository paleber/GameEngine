package basic;

public interface IPoint extends IShape {

    void initByCopying(IPoint other);

	void initWithXY(double x, double y);
	
    double getX();

    double getY();

}
