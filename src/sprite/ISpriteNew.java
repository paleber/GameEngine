package sprite;

public interface ISpriteNew {

    void initWithCircle();
    
    void initWithPolygon();
    
    void setSpeed();
    
    void setRotation();
    
    void move();
    
    boolean checkCollision(ISpriteNew other);
    
    void executeCollision();
    
    
    
}
