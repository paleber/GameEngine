package sprite;

public interface ISpriteNew extends ICollider {

    void initWithCircle();
    
    void initWithPolygon();
    
    
    
    
    void setSpeed();
    
    void setRotation();
    
    void move();
    

    void checkCollision(ICollider collider);
    
    void executeCollision();
    
    
    
}
