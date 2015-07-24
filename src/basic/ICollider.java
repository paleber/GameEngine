package basic;

public interface ICollider {

    int getXMin();
    
    int getYMin();
    
    int getXMax();
    
    int getYMax();
    
    void checkCollision(ICollider other);
    
    void addCollision(ICollider other);
    
    void executeCollisions();
    
}
