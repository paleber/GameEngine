package geo.basic;

public interface IBoundingBoxFix {

    double getXMin();

    double getXMax();

    double getYMin();

    double getYMax();

    boolean collideWith(IBoundingBoxFix other);

}
