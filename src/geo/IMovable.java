package geo;

/**
 * Interface of Movable.
 */
interface IMovable {

	/**
	 * Move along a Vector.
	 *
	 * @param v Vector
	 */
	void move(IVector v);

	/**
	 * Rotate around a point.
	 *
	 * @param pivot  pivot
	 * @param radian angle in radian
	 */
	void rotate(IPoint pivot, double radian);

}

