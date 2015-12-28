package geo;

/*
public interface IShape {  // Bounding box extrahieren

	void move(basic.IVector v);

	void rotate(IPoint pivot, double radian);

	double getXMin();

	double getYMin();

	double getXMax();

	double getYMax();

*/

	// void move(geo_old.IVector v);

	// void rotateAround(final double angleDeg, final IPoint pivot);

	//double getXMid();

	//double getYMid();


//}


/**
 * Interface of Shape.
 */
interface IShape {

	// getXMid() + getYMid() --> getMid() ???
	// Bounding Box auslagern ???

	/**
	 * Move the Shape along a Vector.
	 *
	 * @param v Vector
	 */
	void move(IVector v);

	/**
	 * Rotate the Shape around a point.
	 *
	 * @param pivot  pivot
	 * @param radian angle in radian
	 */
	void rotate(IPoint pivot, double radian);

	/**
	 * Get the minimum x-value.
	 *
	 * @return x-value.
	 */
	double getXMin();

	/**
	 * Get the minimum y-value.
	 *
	 * @return y-value.
	 */
	double getYMin();

	/**
	 * Get the maximum x-value.
	 *
	 * @return x-value.
	 */
	double getXMax();

	/**
	 * Get the maximum y-value.
	 *
	 * @return y-value.
	 */
	double getYMax();

	/**
	 * Get the middle x-value.
	 *
	 * @return x-value.
	 */
	double getXMid();

	/**
	 * Get the middle y-value.
	 *
	 * @return y-value.
	 */
	double getYMid();


}

