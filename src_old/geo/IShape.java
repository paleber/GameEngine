package geo;

public interface IShape {

    void move(IVector v);

    void rotateAround(final double angleDeg, final IPoint pivot);
    
}
