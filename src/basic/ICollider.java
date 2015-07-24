package basic;

public interface ICollider {

	int getXMin();

	int getYMin();

	int getXMax();

	int getYMax();

	// f�r jedes Objekt einzeln pr�fen
	void checkCollision(ICollider other);

	void executeCollisions();

}
