package geo;

public interface ICircle extends IShape {

    void setMid(IPoint point);

    IPoint getMid();

    void setRadius(double radius);

    double getRadius();

}
