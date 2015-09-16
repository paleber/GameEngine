package basic;

public interface ICircle extends IShape {

    void init(IPoint mid, double radius);
    
    IPoint getMid();
    
    double getRadius();
    
}
