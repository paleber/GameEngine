package test.basic;

public interface IPolygon {

void initWithPoints(IPoint... points);
    
    void initByCopying(IPolygon other);
    
    int getNumberPoints();
    
    IPoint getPoint();
    
    void move(IVector movement);
    
    void rotate(IPoint pivot, double radian);
    
}
