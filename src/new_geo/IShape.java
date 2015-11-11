package new_geo;

public interface IShape extends IBoundingBox{

	void move(IVector v);

	void rotate(IPoint pivot, double radian);

	//double getXMid();

	//double getYMid();

}
