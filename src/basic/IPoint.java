package basic;

public interface IPoint extends IShape {

    //void initWithXY(double x, double y);

    void initByCopying(IPoint other);

	void initWithXY(double x, double y);
	
    double getX();

    double getY();

    //void move(IVector movement);

    //void rotate(IPoint pivot, double radian);

    //String toString();


    
}
