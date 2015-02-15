package collision;

public interface IBoundingBoxCollider {

    public interface IBoundingBox {

        double getXMin();

        double getXMax();

        double getYMin();

        double getYMax();

    }

    IBoundingBox getBoundingBox();

}
