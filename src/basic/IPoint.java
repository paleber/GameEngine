package basic;

public interface IPoint {
    
    void initWithXY(double x, double y);
    void initByCopy(IPoint other);

    double getX();
    double getY();
    
    void move(IVector movement);
    void rotate(IPoint pivot);
    
    String toString();
   
}
