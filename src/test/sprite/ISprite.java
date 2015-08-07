package test.sprite;

public interface ISprite<T /*extends ICollider*/>{

    void init(T collider);
    
    T getCollider();
    
    
    
    void setSpeed();
    
    void setRotation();
    
    void move();
    

   // void checkCollision(ICollider collider);
    
    void executeCollision();
    
    
    
}
