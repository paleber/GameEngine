package basic;

import sprite.ISpriteNew;

public interface IPolygon extends Iterable<IPoint>, ISpriteNew{

	void initWithPoints(IPoint... points);
	
	void initByCopying(IPolygon other);
	
	//void move(IVector movement);
	
	//void rotate(IPoint pivot, double radian);
	
	//int getNumberPoints();
}
