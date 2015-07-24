package basic;

public interface ICollider {

	int getXMin();

	int getYMin();

	int getXMax();

	int getYMax();

	// für jedes Objekt einzeln prüfen
	void checkCollision(ICollider other);

	void executeCollisions();

}
